package com.base;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * stauts 常用方法
 * 
 * @author 张宏
 * 
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements SessionAware {

	
	protected String FORWARD = "forwardJsp";          //页面跳转   
	protected String ACTION = "action";		          //请求跳转   
	protected String REDIRECT = "redirect";	          //重定向    
	protected int SCODE = 1;// 成功
	protected int ECODE = 0;// 成功
	
	protected String forwardJsp = null;
	protected String actionName = null;
	protected String redirectName = null;
	
	public String pageSize;
	public String pageNo;

	protected String SMESS = "成功!";
	protected String EMESS = "失败!";
	
	protected String sqlSelectName="sqlSelect";
	protected String sqlInsertName="sqlInsert";
	protected String sqlDeleteName="sqlDelete";
	protected String sqlUpdateName="sqlUpdate";

	
	protected HashMap<Object, String> sqlMap = new HashMap<Object, String>();
//	protected StringBuffer mess ;
	
	//执行sql的公共方法
	public String executeSqlMap(ServiceDao serviceDao,HashMap<Object, String> sqlMap) {
		String mess="";
		Boolean flag = serviceDao.executeSql(sqlMap);
		if(flag) {
			mess=this.codeMess(SCODE, SMESS);
		}else {
			mess=this.codeMess(ECODE, EMESS);
		}
		return mess;
	}
	
	//获取微信平台发送过来的post数据
	public String getPostXml(){
		if(this.getRequest().getMethod().equals("POST")){
			try {
				InputStream in = this.getRequest().getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
				byte[] data = new byte[500];  
				int count = -1;  
				while((count = in.read(data,0,500)) != -1)  
				outStream.write(data, 0, count);  
				 data = null;  
				       return new String(outStream.toByteArray(),"utf-8");  
			} catch (Exception e) {
				return null;
			}
		}else
		{
			return null;
		}
	}
	
	
	public String getRedirectName() {
		return redirectName;
	}

	public void setRedirectName(String redirectName) {
		this.redirectName = redirectName;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getForwardJsp() {
		return forwardJsp;
	}

	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	public void setWIJsp(String forwardJsp) {
		String temp = "/WEB-INF/page/" + forwardJsp + ".jsp";
		this.setForwardJsp(temp);
	}

	public void successJsp(String action) {
		this.setAttribute("action", action);
		this.setForwardJsp("success.jsp");
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unchecked")
	protected Map session;
	@SuppressWarnings("unused")
	private static final String ACTION_MESSAGES = "actionMessages";
	@SuppressWarnings("unused")
	private static final String ACTION_ERRORS = "actionErrors";

	public BaseAction() {
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	//
	public void setAttribute(String key, Object value) {
		this.getRequest().setAttribute(key, value);
	}
	

	//获取tomcat路径
	public String getFilePath(){
		return this.getRequest().getSession().getServletContext().getRealPath(
		"");
	}
	
	public String getBaseUrl(){
		String path = this.getRequest().getContextPath();
		String basePath = this.getRequest().getScheme()+"://"+this.getRequest().getServerName()+":"+this.getRequest().getServerPort()+path+"/";
		return basePath;
	}
	
	public String getRequestUrl(){
		String path = this.getRequest().getContextPath();
		String basePath = this.getRequest().getScheme()+"://"+this.getRequest().getServerName()+":"+this.getRequest().getServerPort()+path+"/";
		return basePath;
	}
	
	//执行javaScript方法 
	public void executeJavaScriptFunction(boolean parent,
			String functionName,
			String fileName,
			int type,
			String fileId){
		String js = "<script>window.";
		if(parent){
			js+="parent.";
		}
		js+= functionName + "('"+fileName+"','"+type+"','"+ fileId +"');</script>";
	
		this.outJson(js);
	}
	
	public String codeMess(int code, String mess) {
		String temp = "{\"code\":\"" + code + "\",\"mess\":\"" + mess + "\"}";// json 格式
		return temp;
	}
	public String codeJson(int code, String json) {
		String temp = "{\"code\":\"" + code + "\",\"mess\":" + json + "}";// json 格式
		return temp;
	}
	
	@SuppressWarnings("unchecked")
	public void addActionError(String error) {
		super.addActionError(error);
		session.put("actionErrors", super.getActionErrors());
	}

	@SuppressWarnings("unchecked")
	public void addActionMessage(String message) {
		super.addActionMessage(message);
		session.put("actionMessages", super.getActionMessages());
	}

	public void clearErrorsAndMessages() {
		clearErrors();
		clearMessages();
		super.clearErrorsAndMessages();
	}

	public void clearErrors() {
		session.remove("actionErrors");
	}

	public void clearMessages() {
		session.remove("actionMessages");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection getActionErrors() {
		Collection errors = super.getActionErrors();
		if (errors.isEmpty()) {
			errors = (Collection) session.get("actionErrors");
			if (!errors.isEmpty()) {
				super.setActionErrors(errors);
				clearErrors();
			}
		}
		return errors;
	}

	public String getWorkPath() {
		return this.getRequest().getSession().getServletContext().getRealPath(
				"");
	}

	@SuppressWarnings("unchecked")
	public Collection getActionMessages() {
		Collection messages = super.getActionMessages();
		if (messages.isEmpty()) {
			messages = (Collection) session.get("actionMessages");
			if (!messages.isEmpty()) {
				super.setActionMessages(messages);
				clearMessages();
			}
		}
		return messages;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}

	public void outImage(InputStream mess) {
		this.getResponse().setContentType("image/jpeg;charset=utf-8");
		try {
			this.getResponse().getWriter().write(mess.toString());
		} catch (Exception e) {
			//写到日志文件中
			String errorMess ="\r\n请求可能 存在问题 导致 程序错误!\r\n原请求是 ： " +getRequest().getRequestURL();
			logger.info(errorMess);
			try {
				this.getResponse().getWriter().write(errorMess);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
			}
		}
	}
	
	public void outJson(String mess) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		try {
			this.getResponse().getWriter().write(mess);
		} catch (Exception e) {
			//写到日志文件中
			String errorMess ="\r\n请求可能 存在问题 导致 程序错误!\r\n原请求是 ： " +getRequest().getRequestURL();
			logger.info(errorMess);
			try {
				this.getResponse().getWriter().write(errorMess);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void outJson(List list, int pageCount, String pageNo) {

		this.getResponse().setContentType("text/html;charset=UTF-8");
		JSONArray jo = JSONArray.fromObject(list);
		try {
			this.getResponse().getWriter().write(
					"{\"code\":\"10000\",\"data\":" + jo.toString()
							+ ",\"pageCount\":\"" + pageCount
							+ "\",\"pageNo\":" + pageNo + "}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void outJson(List list) {

		this.getResponse().setContentType("text/html;charset=UTF-8");
		JSONArray jo = JSONArray.fromObject(list);
		try {
			this.getResponse().getWriter().write(
					"{\"code\":\"1\",\"data\":" + jo.toString() + "}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void outJson(Object o){
		this.getResponse().setContentType("text/html;charset=UTF-8");
		JsonConfig jc = new JsonConfig();
		jc.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object arg0, String arg1, Object arg2) {
				boolean r = false;
					r = r ||
					arg1.equals("pass_word")||
					arg1.equals("f_ids")||
					arg1.equals("role")||
					arg1.equals("ward")||
					arg1.equals("content");				//添加需要删除的字段
				
				return r;
			}
		});
		JSONObject js = JSONObject.fromObject(o,jc);
		try {
			this.getResponse().getWriter().write("{\"code\":\"1\",\"data\":" + js.toString()+"}" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void jsonSystemOutPrint(String mess) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		try {
			this.getResponse().getWriter().write(mess);
		} catch (Exception e) {
			//写到日志文件中
			String errorMess ="\r\n请求可能 存在问题 导致 程序错误!\r\n原请求是 ： " +getRequest().getRequestURL();
			logger.info(errorMess);
			try {
				this.getResponse().getWriter().write(errorMess);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
			}
		}
	}
	
	//可以剔除某些字段的方法
	public void outJson(final PageList pl) {

		this.getResponse().setContentType("text/html;charset=UTF-8");
		JSONArray jo = null;
		JSONObject je = null;
		if(pl.getRemoves()!=null&&pl.getRemoves().length!=0){	//有要删除的字段
			JsonConfig jc = new JsonConfig();
			jc.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object arg0, String arg1, Object arg2) {
					boolean r = false;
					for(String temp : pl.getRemoves()){
						r = r ||arg1.equals(temp);				//添加需要删除的字段
					}
					return r;
				}
			});
		}else{
			jo =JSONArray.fromObject(pl.getList()); 
		}
		try {
			//System.out.println("{\"code\":\"10000\",\"data\":" + jo.toString()+ ",\"pageCount\":\""+pageCount+"\",\"pageNo\":"+pageNo+"}");
			if(je!=null){
				this.getResponse().getWriter().write(je.toString());
			}else
			{

				this.getResponse().getWriter().write("{\"code\":1,\"rows\":" + jo.toString()+ ",\"total\":\""+pl.getCounts()+"\"}" );

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	//需要查询的字段
	public String selectMenu;
	//查询固定数值
	public void outJsonForSelect(final PageList pl) {
		this.getResponse().setContentType("text/html;charset=UTF-8");
		JSONArray jo = null;
			JsonConfig jc = new JsonConfig();
			jc.setJsonPropertyFilter(new PropertyFilter() {
				public boolean apply(Object arg0, String arg1, Object arg2) {
					boolean r = true;
					for(String temp : selectMenu.split(",")){
						r = !arg1.equals(temp);				//添加需要添加的字段
						if(!r){
							break;
						}
					}
					return r;
				}
			});
			jo = JSONArray.fromObject(pl.getList(), jc);
		try {
			this.getResponse().getWriter().write(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
