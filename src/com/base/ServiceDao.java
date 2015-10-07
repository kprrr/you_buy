package com.base;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.jdbc.util.FormatStyle;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import net.sf.json.JSONObject;



@Component("serviceDao")
@Scope("prototype")
public class ServiceDao extends SimpleJdbcDaoSupport {

	protected int SCODE = 1;// 成功
	protected int ECODE = 0;// 失败
	protected String SMESS = "success";
	
	
	
	@Resource
	private TransactionTemplate templateTransactionTemplate;
	@Resource
	private JdbcTemplate template;

	public ServiceDao() {
		//logger.info("\n初始化接口 " + this.getClass() + "成功!");
	}

	@PostConstruct
	public void injsctJdbc() {
		super.setJdbcTemplate(template);
	}

	// 防止sql漏洞
	public String getString(String string) {
		return string.replace("'", "\"");
	}

	
	
	
	
	// 执行sql语句
	@SuppressWarnings("unchecked")
	public <T> List<T> selectSql(final String sql, final Object o) {
		List<T> temp = null;
		try {
			temp = (List<T>) templateTransactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus arg0) {
					logger.info(FormatStyle.BASIC.getFormatter().format(sql));
					List<T> temp = (List<T>) getSimpleJdbcTemplate().query(sql, getItems(o.getClass()), setItems(o));
					logger.info("当前查询到:" + temp.size() + "条");

					return temp;
				}
			});
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return temp;
	}

	// 执行sql语句 分页显示
	@SuppressWarnings("unchecked")
	public <T> List<T> selectSql(final String sql, final Object o, final String pageSize, final String pageNo) {
		List<T> temp = null;
		try {
			temp = (List<T>) templateTransactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus arg0) {
					String pageSizeTemp = pageSize == null ? "1" : pageSize;
					String pageNoTemp = pageNo == null ? "1" : pageNo;
					// 计算分页
					int sIndex = Integer.parseInt(pageSizeTemp) * (Integer.parseInt(pageNoTemp) - 1);
					int eIndex = Integer.parseInt(pageSizeTemp);
					String tempsql =  sql + " limit " + sIndex + "," + eIndex;
					logger.info(FormatStyle.BASIC.getFormatter().format(tempsql));
					List<T> temp = (List<T>) getSimpleJdbcTemplate().query(tempsql, getItems(o.getClass()), setItems(o));
					logger.info("当前查询到:" + temp.size() + "条");
					return temp;
				}
			});
			// getSimpleJdbcTemplate().getJdbcOperations().
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return temp;
	}

//	public PageList getList(ModelImp modelImp, String pageSize, String pageNo) {
//		PageList pl = new PageList();
//		String sql = modelImp.sqlSelect(modelImp);
//		int counts = this.getCount(sql, modelImp);
//		pl.setCounts(counts);
//		List list;
//		if (pageSize != null) {
//			pageNo = pageNo == null ? "1" : pageNo;
//			list = this.selectSql(sql, modelImp, pageSize, pageNo);
//			int pageCount = this.getPageCount(counts, pageSize);
//			pl.setPageCount(pageCount);
//		} else {
//			list = this.selectSql(sql, modelImp);
//		}
//		pl.setList(list);
//		return pl;
//	}
	
	public Object findObjByCondition(Object o) {
		try {
			List<Object> objList = this.getList(o,
					"sqlSelect");
			if (objList.size() <= 0) {
				return null;
			} else {
				return objList.get(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Object findObjByCondition(Object o,String methodName) {
		try {
			List<Object> objList = this.getList(o,
					methodName);
			if (objList.size() <= 0) {
				return null;
			} else {
				return objList.get(0);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List getList(Object o,String methodName) {
		
		List list = null;
		String sql;
		try {
			sql = returnSql(o, methodName);
			list = this.selectSql(sql, o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public PageList getList(Object o,String methodName,String pageSize,String pageNo) throws Exception {
		PageList pl = new PageList();
		String sql = returnSql(o, methodName);
		int counts = this.getCount(sql, o);
		pl.setCounts(counts);
		List list;
		if (pageSize != null) {
			pageNo = pageNo == null ? "1" : pageNo;
			list = this.selectSql(sql, o, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else {
			list = this.selectSql(sql, o);
		}

		pl.setList(list);
		return pl;
	}

	// 获取总记录数
	public int getCount(final String sql, final Object o) {
		Integer temp = (Integer) templateTransactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus arg0) {
				String sqlTemp = sql.substring(sql.indexOf("from"), sql.length());
				SqlParameterSource sps = new BeanPropertySqlParameterSource(o);
				return getSimpleJdbcTemplate().queryForInt("SELECT count(*) " + sqlTemp, sps);
			}
		});
		logger.info("符合条件总数:" + temp + "条");
		return temp;
	}

	public int getPageCount(int counts, String p) {
		p = p == null ? "1" : p;
		int pageSize = Integer.parseInt(p);
		int pageCount = counts / pageSize;
		if (counts % pageSize > 0) {
			pageCount++;
		}
		return pageCount;
	}

	// 执行操作sql语句s
	public Boolean executeSqlArray(final Object o, final String[] sqls) {
		boolean temp = true;
		int count = 0;
		for (String sql : sqls) {
			try {
				count++;
				SqlParameterSource sps = new BeanPropertySqlParameterSource(o);
				getSimpleJdbcTemplate().update(sql, sps);
				logger.info(FormatStyle.BASIC.getFormatter().format(sql) + "\r\n已成功执行!\r\n");
			} catch (DataAccessException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
				count = 0;
				temp = false;
			}
		}
		logger.info("已成功执行sql语句:" + count + "条\r\n");
		return temp;
	}
	
	public String addObject(final Object o,String methodName) throws Exception{
		String outMess = this.codeMess(SCODE, SMESS);
		String sql = returnSqlWithNoParam(o, methodName);
		if(!this.executeSql(o, sql)){
			outMess = this.codeMess(ECODE, "添加失败!");
		}
		return outMess;
	}
	
	public String updateObject(final Object o,String methodName) throws Exception{
		String outMess = this.codeMess(SCODE, SMESS);
		String sql = returnSql(o, methodName);
		if(!this.executeSql(o, sql)){
			outMess = this.codeMess(ECODE, "添加失败!");
		}
		return outMess;
	}
	
	public String operateObject(final Object o,String methodName) throws Exception{
		String outMess = this.codeMess(SCODE, SMESS);
		String sql = returnSqlWithNoParam(o, methodName);
		if(!this.executeSql(o, sql)){
			outMess = this.codeMess(ECODE, "操作失败!");
		}
		return outMess;
	}
	
	
	public Boolean executeSql(final Map<Object, String> map) {
		Boolean temp = null;
		temp = (Boolean) templateTransactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus arg0) {
				boolean temp = true;
				int count = 0;
				 Set<Object> key = map.keySet();
				 for (Iterator it = key.iterator(); it.hasNext();) {
					 try {
						 Object o = (Object) it.next();
						 SqlParameterSource sps = new BeanPropertySqlParameterSource(o); //用来将每个object的成员变量的值取出
						 String sql = map.get(o);
						 getSimpleJdbcTemplate().update(sql, sps);
						 count++;
						 logger.info(map.get(o) + "\r\n已成功执行!\r\n");
					 }catch (DataAccessException e) {
						 arg0.setRollbackOnly();
						 e.printStackTrace();
							count = 0;
							temp = false;
					}
			        }
				
				 logger.info("已成功执行sql语句:" + count + "条\r\n");

					return temp;
			}
		});
		return temp;
	}
	
//	public Boolean executeSql2(final Map<Object, String> map) {
//		final String[] sql={"insert into exchangerecord (id,createtime) values ('aa',CURRENT_TIMESTAMP)","insert into exchangerecord (id,moonCake_count,createtime) values ('ab','11',CURRENT_TIMESTAMP)"};
//		Boolean temp = null;
//		final Wxuserlist wxuser = new Wxuserlist();
//				int count = 0;
//				 for (int i =0;i<sql.length;i++) {
//					 try {
//						 SqlParameterSource sps = new BeanPropertySqlParameterSource(wxuser); //用来将每个object的成员变量的值取出
//						 getSimpleJdbcTemplate().update(sql[i], sps);
//						 count++;
//						 System.out.println("运行成功111111111111");
//					 }catch (DataAccessException e) {
//						 e.printStackTrace();
//							count = 0;
//							temp = false;
//							System.out.println("运行失败2222222222222");
//					}
//			        }
//				
//				 logger.info("已成功执行sql语句:" + count + "条\r\n");
//
//					return temp;
//	}
	
	
	public Boolean executeSql(final Object o, final String... sqls) {
		Boolean temp = null;
		try {
			temp = (Boolean) templateTransactionTemplate
					.execute(new TransactionCallback() {
						public Object doInTransaction(TransactionStatus arg0) {
							boolean temp = true;
							int count = 0;
							for (String sql : sqls) { 
								try {
									count++;
									SqlParameterSource sps = new BeanPropertySqlParameterSource(
											o);
									getSimpleJdbcTemplate().update(sql, sps);
									logger.info(sql + "\r\n已成功执行!\r\n");
								} catch (DataAccessException e) {
									e.printStackTrace();
									count = 0;
									temp = false;
								}
							}
							// logger.info("[" + o.getClass().getSimpleName() +
							// "] 表  受影响行数 :" + count +"行\r\n ");
							logger.info("已成功执行sql语句:" + count + "条\r\n");

							return temp;
						}
					});
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return temp;

	}

	// 执行操作sql语句
	public Boolean executeSql(final String... sqls) {
		boolean temp = true;
		int count = 0;
		for (String sql : sqls) {
			try {
				count++;
				template.execute(sql);
				logger.info(FormatStyle.BASIC.getFormatter().format(sql) + "\r\n已成功执行!\r\n");
			} catch (DataAccessException e) {
				logger.info(e.getMessage());
				count = 0;
				temp = false;
			}
		}
		logger.info("成功执行sql条数 :" + count + "条\r\n ");
		return temp;
	}

	// 执行操作sql语句
	public Boolean executeSql(final String[]... sqlss) {
		boolean temp = true;
		int count = 0;
		for (String[] sqls : sqlss) {
			for (String sql : sqls) {
				try {
					count++;
					template.execute(sql);
					logger.info(FormatStyle.BASIC.getFormatter().format(sql) + "\r\n已成功执行!\r\n");
				} catch (DataAccessException e) {
					logger.info(e.getMessage());
					count = 0;
					temp = false;
				}
			}
		}
		logger.info("成功执行sql条数 :" + count + "条\r\n ");
		return temp;
	}

	// 批量执行sql命令
	public int[] executeSqls(String sql, List list) {
		for (int i = 0; i < list.size(); i++) {
			executeSql(list.get(i), sql);
		}
		logger.info("已批量执行" + list.size() + "条sql");
		return null;
	}

	/**
	 * 判断是否存在
	 * 
	 * @param <T>
	 * @param sql
	 * @param o
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Boolean isExise(final String sql, final Object o) {
		List<T> list = (List<T>) templateTransactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(TransactionStatus arg0) {
				logger.info("\r\n " + FormatStyle.BASIC.getFormatter().format(sql));
				List<T> temp = (List<T>) getSimpleJdbcTemplate().query(sql, getItems(o.getClass()), setItems(o));
				return temp;
			}
		});
		return list.size() != 0 ? true : false;
	}

	// 执行存储过程PROCEDURE
	public <T> Boolean executeProcedure(final Object o, final String... sqls) {
		Boolean temp = null;
		try {
			temp = (Boolean) templateTransactionTemplate.execute(new TransactionCallback() {
				public Object doInTransaction(TransactionStatus arg0) {
					boolean temp = true;
					int count = 0;
					for (String sql : sqls) {
						try {
							count++;
							SqlParameterSource sps = new BeanPropertySqlParameterSource(o);
							getSimpleJdbcTemplate().update(sql, sps);
							logger.info(FormatStyle.BASIC.getFormatter().format(sql) + "\r\n存储过程--已成功执行!\r\n");
						} catch (DataAccessException e) {
							e.printStackTrace();
							count = 0;
							temp = false;
						}
					}
					logger.info("存储过程--已成功执行sql语句:" + count + "条\r\n");
					return temp;
				}
			});
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return temp;
	}

	// 解析反馈的数据
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ParameterizedBeanPropertyRowMapper getItems(Class clazz) {
		return ParameterizedBeanPropertyRowMapper.newInstance(clazz);
	}

	// 注值
	public BeanPropertySqlParameterSource setItems(Object clazz) {
		return new BeanPropertySqlParameterSource(clazz);
	}

	public TransactionTemplate getTemplateTransactionTemplate() {
		return templateTransactionTemplate;
	}

	public void setTemplateTransactionTemplate(TransactionTemplate templateTransactionTemplate) {
		this.templateTransactionTemplate = templateTransactionTemplate;
	}

	/**
	 * 错误字符串
	 * 
	 * @param code
	 *            错误码
	 * @param mess
	 *            错误信息
	 * @return
	 */
	public String codeMess(int code, String mess) {
		JSONObject jo = new JSONObject();
		jo.put("code", code);
		jo.put("mess", mess);
		return jo.toString();
	}

	public String codeMess() {
		JSONObject jo = new JSONObject();
		jo.put("code", 10000);
		jo.put("mess", "success");
		return jo.toString();
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public double getPrice(double price) {
		DecimalFormat df = new DecimalFormat(".##");
		price = Double.parseDouble(df.format(price));
		return price;
	}

	// 空字符串验证
	public boolean valiDateParamNull(Object param) {
		if (param != null && !param.equals("")) {
			return true;
		}
		return false;
	}

	public String getMethod(String classname, String flag, Object o) {
		String sql = null;
		try {
			Class<?> clazz = Class.forName(o.getClass().getName());
			Object obj = clazz.newInstance();
			Method method = obj.getClass().getMethod(classname + flag, o.getClass());
			sql = (String) method.invoke(obj, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
	
	public String returnSql(Object o,String methodName)  throws Exception{
		Class classType = o.getClass();
		Method method = classType.getMethod(methodName, new Class[]{classType});
		Object result = method.invoke(o, new Object[]{o});
//		System.out.println(result);
		return (String)result;
	}
	
	
	public String returnSqlWithNoParam(Object o,String methodName) throws Exception{
		Class classType = o.getClass();
		Method method = classType.getMethod(methodName, new Class[]{});
		Object result = method.invoke(o, new Object[]{});
//		System.out.println(result);
		return (String)result;
	}
	
	private static SecureRandom mySecureRand;
	private static Random myRand;
	private static String s_id;
	public static String valueBeforeMD5 = "";
	public static String valueAfterMD5 = "";
	private static final int PAD_BELOW = 0x10;
	private static final int TWO_BYTES = 0xFF;
	static {
		mySecureRand = new SecureRandom();
		long secureInitializer = mySecureRand.nextLong();
		myRand = new Random(secureInitializer);
		try {
			s_id = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
	
	public static String createKey() {
		boolean secure = true;
		MessageDigest md5 = null;
		StringBuffer sbValueBeforeMD5 = new StringBuffer(128);

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}

		try {
			long time = System.currentTimeMillis();
			long rand = 0;

			if (secure) {
				rand = mySecureRand.nextLong();
			} else {
				rand = myRand.nextLong();
			}
			sbValueBeforeMD5.append(s_id);
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(time));
			sbValueBeforeMD5.append(":");
			sbValueBeforeMD5.append(Long.toString(rand));

			valueBeforeMD5 = sbValueBeforeMD5.toString();
			md5.update(valueBeforeMD5.getBytes());

			byte[] array = md5.digest();
			StringBuffer sb = new StringBuffer(32);
			for (int j = 0; j < array.length; ++j) {
				int b = array[j] & TWO_BYTES;
				if (b < PAD_BELOW)
					sb.append('0');
				sb.append(Integer.toHexString(b));
			}

			valueAfterMD5 = sb.toString();

		} catch (Exception e) {
			System.out.println(e);
		}
		String raw = valueAfterMD5.toUpperCase();
		StringBuffer sb2 = new StringBuffer(64);
		sb2.append(raw.substring(0, 8));
		// sb2.append("-");
		sb2.append(raw.substring(8, 12));
		// sb2.append("-");
		sb2.append(raw.substring(12, 16));
		// sb2.append("-");
		sb2.append(raw.substring(16, 20));
		// sb2.append("-");
		sb2.append(raw.substring(20));
		String temp = sb2.toString();
		temp = temp.toLowerCase();// 转换成小写
		return temp;
	}
	
	public static void main(String[] args) {
//		WxUser r = new WxUser();
//		Class classType = r.getClass();
//		Method method;
//		try {
//			method = classType.getMethod("sqlInsert", new Class[]{});
//			Object result = method.invoke(r, new Object[]{});
//			Object result2 = method.invoke(null, new Object[]{});
//			System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		WxUser.a="aa";
//		System.out.println(WxUser.a);
//		WxUser.a="bb";
//		System.out.println(WxUser.a);
		
	}
		
}
