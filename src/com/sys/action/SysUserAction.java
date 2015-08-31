package com.sys.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.dao.SysUserDao;
import com.sys.model.admin;

/**
 * 系统用户处理
 * 
 * @author 张宏
 */
@Component("sysUserAction")
@Scope("prototype")
public class SysUserAction extends BaseAction implements ModelDriven<admin> {

	@Autowired
	@Resource
	public SysUserDao sysUserDao;

	// sysUser-login
	public String login() {
		String page = "login.jsp";
		String mess = "用户名或密码错误!";
		admin loginUser = sysUserDao.getUser(sysUser);
		if (loginUser != null
				&& loginUser.getPassword().equals(sysUser.getPassword())) {
			// 登陆成功
			session.put("systemUserInfo", loginUser);
			page = "index.jsp";
//			try {
//				this.getResponse().sendRedirect("index.jsp");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return REDIRECT;
		}
		this.setForwardJsp(page);
		this.setAttribute("mess", mess);
		return FORWARD;
	}

	// 退出登陆 sysUser-logOut
	public String logOut() {
		session.clear();
		this.setForwardJsp("login.jsp");
		return FORWARD;
	}

	// sysUser-get
//	public void get() {
//		PageList pl = sysUserDao.getSysUser(sysUser, rows, page);
//		this.outJson(pl);
//	}

	// sysUser-add
//	public void add() {
//		String mess = sysUserDao.addUser(sysUser);
//		this.outJson(mess);
//	}

	// sysUser-update
//	public void update() {
//		String mess = sysUserDao.updateUser(sysUser);
//		this.outJson(mess);
//	}

	// sysUser-remove
//	public void remove() {
//		String mess = sysUserDao.deleteUser(sysUser);
//		this.outJson(mess);
//	}

	// sysUser-listPage
	public String listPage() {

		return FORWARD;
	}

	admin sysUser = new admin();

	public admin getModel() {
		return sysUser;
	}
}
