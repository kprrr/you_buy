package com.base;

import com.sys.dao.ServerDao;
import net.sf.json.JSONObject;
import org.hibernate.jdbc.util.FormatStyle;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

/**
 * jdbc 基层
 * 
 * @author 张宏
 */
public class JdbcDao extends SimpleJdbcDaoSupport {

	// 错误代码
	protected int eCode = 0;

	// 成功代码
	protected int sCode = 1;
	protected String sMess = "success";

	@Resource
	private TransactionTemplate templateTransactionTemplate;
	@Resource
	private JdbcTemplate template;

	@PostConstruct
	public void injsctJdbc() {
		super.setJdbcTemplate(template);
	}

	// 防止sql漏洞
	public String getString(String string) {
		return string.replace("'", "\"");
	}

	protected String orderPidSql(String pid) {
		return " start with pid = '" + pid + "' connect by prior id = pid ";
	}

	protected String orderidSql(String id) {
		return " start with id = '" + id + "' connect by prior id = pid ";
	}

	// 执行sql语句
	@SuppressWarnings("unchecked")
	public <T> List<T> selectSql(final String sql, final Object o) {
		List<T> temp = null;
		try {
			temp = (List<T>) templateTransactionTemplate
					.execute(new TransactionCallback() {
						public Object doInTransaction(TransactionStatus arg0) {
							logger.info(FormatStyle.BASIC.getFormatter()
									.format(sql));
							List<T> temp = (List<T>) getSimpleJdbcTemplate()
									.query(sql, getItems(o.getClass()),
											setItems(o));
							return temp;
						}
					});
		} catch (TransactionException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public PageList getList(ServerDao.ServerModel modelImp, String pageSize,
			String pageNo) {
		PageList pl = new PageList();
		String sql = modelImp.sqlSelect(modelImp);
		int counts = this.getCount(sql, modelImp);
		pl.setCounts(counts);
		List list;
		if (pageSize != null) {
			pageNo = pageNo == null ? "1" : pageNo;
			list = this.selectSql(sql, modelImp, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		} else {
			list = this.selectSql(sql, modelImp);
		}
		pl.setList(list);
		return pl;
	}

	// 执行sql语句 分页显示
	@SuppressWarnings("unchecked")
	public <T> List<T> selectSql(final String sql, final Object o,
			final String pageSize, final String pageNo) {

		List<T> temp = null;
		try {
			temp = (List<T>) templateTransactionTemplate
					.execute(new TransactionCallback() {
						public Object doInTransaction(TransactionStatus arg0) {
							String pageSizeTemp = pageSize == null ? "1"
									: pageSize;
							String pageNoTemp = pageNo == null ? "1" : pageNo;
							// 计算分页
							int sIndex = Integer.parseInt(pageSizeTemp)
									* (Integer.parseInt(pageNoTemp) - 1);
							int eIndex = Integer.parseInt(pageSizeTemp);

							String tempsql = sql + " limit " + sIndex + ","
									+ eIndex;
							logger.info(FormatStyle.BASIC.getFormatter()
									.format(tempsql));
							List<T> temp = (List<T>) getSimpleJdbcTemplate()
									.query(tempsql, getItems(o.getClass()),
											setItems(o));
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

	// 获取总记录数
	public int getCount(final String sql, final Object o) {
		Integer temp = (Integer) templateTransactionTemplate
				.execute(new TransactionCallback() {
					public Object doInTransaction(TransactionStatus arg0) {
						// TODO Auto-generated method stub
						String sqlTemp = sql.substring(sql.indexOf("from"), sql
								.length());
						SqlParameterSource sps = new BeanPropertySqlParameterSource(
								o);
						return getSimpleJdbcTemplate().queryForInt(
								"SELECT count(*) " + sqlTemp, sps);
					}
				});
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

	// 执行操作sql语句
	public Boolean executeSql(final Object o, final String... sqls) {
		Boolean temp = true;
		int count = 0;
		for (String sql : sqls) {
			try {
				count++;
				SqlParameterSource sps = new BeanPropertySqlParameterSource(o);
				getSimpleJdbcTemplate().update(sql, sps);
				logger.info(FormatStyle.BASIC.getFormatter().format(sql)
						+ "\r\n已成功执行!\r\n");
			} catch (DataAccessException e) {
				logger.info(e.getMessage());
				count = 0;
				temp = false;
			}
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
				logger.info(FormatStyle.BASIC.getFormatter().format(sql)
						+ "\r\n已成功执行!\r\n");
			} catch (DataAccessException e) {
				logger.info(e.getMessage());
				count = 0;
				temp = false;
			}
		}
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
					logger.info(FormatStyle.BASIC.getFormatter().format(sql)
							+ "\r\n已成功执行!\r\n");
				} catch (DataAccessException e) {
					logger.info(e.getMessage());
					count = 0;
					temp = false;
				}
			}
		}
		return temp;
	}

	// 批量执行sql命令
	public int[] executeSqls(String sql, List<Object> list) {
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
		List<T> list = (List<T>) templateTransactionTemplate
				.execute(new TransactionCallback() {
					public Object doInTransaction(TransactionStatus arg0) {
						logger.info("\r\n "
								+ FormatStyle.BASIC.getFormatter().format(sql));
						List<T> temp = (List<T>) getSimpleJdbcTemplate().query(
								"select * " + sql, getItems(o.getClass()),
								setItems(o));
						return temp;
					}
				});
		return list.size() != 0 ? true : false;
	}

	// 解析反馈的数据
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

	public void setTemplateTransactionTemplate(
			TransactionTemplate templateTransactionTemplate) {
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

	public String codeJson(int code, String mess) {
		JSONObject jo = new JSONObject();
		jo.put("code", code);
		jo.put("mess", mess);
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

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	public static String valueBeforeMD5 = "";
	public static String valueAfterMD5 = "";
	private static Random myRand;
	private static SecureRandom mySecureRand;

	private static String s_id;
	private static final int PAD_BELOW = 0x10;
	private static final int TWO_BYTES = 0xFF;

	/*
	 * Static block to take care of one time secureRandom seed. It takes a few
	 * seconds to initialize SecureRandom. You might want to consider removing
	 * this static block or replacing it with a "time since first loaded" seed
	 * to reduce this time. This block will run only once per JVM instance.
	 */

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
}
