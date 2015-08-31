package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.UserDao;
import com.user.model.user;
import com.opensymphony.xwork2.ModelDriven;

/**
 * user请求处理
 * @author 张宏
 *
 */
@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<user>{
	
	@Autowired
	@Resource
	public UserDao userDao;
	
	//获取user-get
	public void get(){
		PageList pageList = userDao.getUser(user, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加user-insert
	public void insert(){
		String outMess = userDao.addUser(user);
		this.outJson(outMess);
	}
	
	//删除user-remove
	public void remove(){
		String outMess = userDao.deleteUser(user);
		this.outJson(outMess);
	}
	
	//修改user-update
	public void update(){
		String outMess = userDao.updateUser(user);
		this.outJson(outMess);
	}
	
	user user = new user();
	public user getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
