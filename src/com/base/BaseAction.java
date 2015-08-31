package com.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.sys.model.sys_user;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * stauts 甯哥敤鏂规硶
 * 
 * @author 寮犲畯
 */
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements SessionAware {

	protected String FORWARD = "forwardJsp"; // 椤甸潰璺宠浆
	protected String ACTION = "action"; // 璇锋眰璺宠浆
	protected String REDIRECT = "redirect"; // 閲嶅畾鍚�
	protected int SCODE = 1;// 鎴愬姛
	protected int ECODE = 0;// 鎴愬姛

	protected String forwardJsp = null;
	protected String actionName = null;
	protected String redirectName = null;

	public String rows;
	public String page;

	protected String SMESS = "鎴愬姛!";
	protected String EMESS = "澶辫触!";

	// 鑾峰彇寰俊骞冲彴鍙戦�杩囨潵鐨刾ost鏁版嵁
	public String getPostXml() {
		if (this.getRequest().getMethod().equals("POST")) {
			try {
				InputStream in = this.getRequest().getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] data = new byte[500];
				int count = -1;
				while ((count = in.read(data, 0, 500)) != -1)
					outStream.write(data, 0, count);
				data = null;
				return new String(outStream.toByteArray(), "utf-8");
			} catch (Exception e) {
				return null;
			}
		} else {
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

	// 鑾峰彇tomcat璺緞
	public String getFilePath() {
		return this.getRequest().getSession().getServletContext().getRealPath(
				"");
	}

	public String getBaseUrl() {
		String path = this.getRequest().getContextPath();
		String basePath = this.getRequest().getScheme() + "://"
				+ this.getRequest().getServerName() + ":"
				+ this.getRequest().getServerPort() + path + "/";
		return basePath;
	}

	public String getRequestUrl() {
		String path = this.getRequest().getContextPath();
		String basePath = this.getRequest().getScheme() + "://"
				+ this.getRequest().getServerName() + ":"
				+ this.getRequest().getServerPort() + path + "/";
		return basePath;
	}

	// 鎵цjavaScript鏂规硶
	public void executeJavaScriptFunction(boolean parent, String functionName,
			String fileName, int type, String fileId) {
		String js = "<script>window.";
		if (parent) {
			js += "parent.";
		}
		js += functionName + "('" + fileName + "','" + type + "','" + fileId
				+ "');</script>";

		this.outJson(js);
	}

	public String codeMess(int code, String mess) {
		String temp = "{\"code\":\"" + code + "\",\"mess\":\"" + mess + "\"}";// json
																				// 鏍煎紡
		return temp;
	}

	public String codeJson(int code, String json) {
		String temp = "{\"code\":\"" + code + "\",\"mess\":" + json + "}";// json
																			// 鏍煎紡
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

	@SuppressWarnings("unchecked")
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

	// 鍒ゆ柇鏄惁鐧诲綍
	public sys_user loginSystemUser() {
		sys_user user = (sys_user) session.get("systemUserInfo");// 闇�鐧诲綍鐨勫叏閮ㄤ负post璇锋眰
		if (user != null) {
			if (true || this.getRequest().getMethod().equals("POST")) {
				return user;
			} else {
				outJson(codeMess(ECODE, "闈炴硶璇锋眰"));
				return null;
			}
		} else {
			outJson(codeMess(ECODE, "璇峰厛鐧诲綍骞冲彴"));
			return null;
		}
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
			// 鍐欏埌鏃ュ織鏂囦欢涓�
			String errorMess = "\r\n璇锋眰鍙兘 瀛樺湪闂 瀵艰嚧 绋嬪簭閿欒!\r\n鍘熻姹傛槸 锛�"
					+ getRequest().getRequestURL();
			logger.info(errorMess);
			try {
				this.getResponse().getWriter().write(errorMess);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
			}
		}
	}

	public void outJson(String mess) {
		this.getResponse().setContentType("text/json;charset=utf-8");
		try {
			this.getResponse().getWriter().write(mess);
		} catch (Exception e) {
			// 鍐欏埌鏃ュ織鏂囦欢涓�
			String errorMess = "\r\n璇锋眰鍙兘 瀛樺湪闂 瀵艰嚧 绋嬪簭閿欒!\r\n鍘熻姹傛槸 锛�"
					+ getRequest().getRequestURL();
			logger.info(errorMess);
			try {
				this.getResponse().getWriter().write(errorMess);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
			}
		}
	}

	public void outHtml(String mess) {
		this.getResponse().setContentType("text/html;charset=utf-8");
		try {
			this.getResponse().getWriter().write(mess);
		} catch (Exception e) {
			// 鍐欏埌鏃ュ織鏂囦欢涓�
			String errorMess = "\r\n璇锋眰鍙兘 瀛樺湪闂 瀵艰嚧 绋嬪簭閿欒!\r\n鍘熻姹傛槸 锛�"
					+ getRequest().getRequestURL();
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

		this.getResponse().setContentType("text/json;charset=UTF-8");
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

		this.getResponse().setContentType("text/json;charset=UTF-8");
		JSONArray jo = JSONArray.fromObject(list);
		try {
			this.getResponse().getWriter().write(
					"{\"code\":\"10000\",\"data\":" + jo.toString() + "}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void outJson(Object o) {
		this.getResponse().setContentType("text/json;charset=UTF-8");
		JsonConfig jc = new JsonConfig();
		jc.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object arg0, String arg1, Object arg2) {
				boolean r = false;
				r = r || arg1.equals("pass_word") || arg1.equals("f_ids")
						|| arg1.equals("role") || arg1.equals("ward")
						|| arg1.equals("content"); // 娣诲姞闇�鍒犻櫎鐨勫瓧娈�

				return r;
			}
		});
		JSONObject js = JSONObject.fromObject(o, jc);
		try {
			this.getResponse().getWriter().write(
					"{\"code\":\"10000\",\"data\":" + js.toString() + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 鏄惁閫夋嫨绗竴涓暟鎹�
	public boolean one = false;

	// 鍙互鍓旈櫎鏌愪簺瀛楁鐨勬柟娉�
	public void outJson(final PageList pl) {

		if (selectMenu != null) {
			outJsonForSelect(pl);
		} else {
			this.getResponse().setContentType("text/json;charset=UTF-8");
			JSONArray jo = JSONArray.fromObject(pl.getRows());
			if (pl.getRemoves() != null && pl.getRemoves().size() != 0) { // 鏈夎鍒犻櫎鐨勫瓧娈�
				JsonConfig jc = new JsonConfig();
				jc.setJsonPropertyFilter(new PropertyFilter() {
					public boolean apply(Object arg0, String arg1, Object arg2) {
						boolean r = false;
						for (String temp : pl.getRemoves()) {
							r = r || arg1.equals(temp); // 娣诲姞闇�鍒犻櫎鐨勫瓧娈�
						}
						return r;
					}
				});
				jo = JSONArray.fromObject(pl.getRows(), jc);
			}
			try {
				if (one) {
					if (jo.size() > 0) {
						this.getResponse().getWriter().write(
								"{\"code\":1,\"mess\":" + jo.get(0).toString()
										+ "}");
					}
				} else {
					this.getResponse().getWriter().write(
							"{\"code\":1,\"rows\":" + jo.toString()
									+ ",\"total\":\"" + pl.getTotal() + "\"}");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 闇�鏌ヨ鐨勫瓧娈�
	public String selectMenu;

	// 鏌ヨ鍥哄畾鏁板�
	public void outJsonForSelect(final PageList pl) {
		this.getResponse().setContentType("text/json;charset=UTF-8");
		JSONArray jo = null;
		JsonConfig jc = new JsonConfig();
		jc.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object arg0, String arg1, Object arg2) {
				boolean r = true;
				for (String temp : selectMenu.split(",")) {
					r = !arg1.equals(temp); // 娣诲姞闇�娣诲姞鐨勫瓧娈�
					if (!r) {
						break;
					}
				}
				return r;
			}
		});
		jo = JSONArray.fromObject(pl.getRows(), jc);
		try {
			this.getResponse().getWriter().write(jo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
