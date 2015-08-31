package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.UserPrizeADao;
import com.user.model.user_prize_a;
import com.opensymphony.xwork2.ModelDriven;

/**
 * user_prize_a请求处理
 * @author 张宏
 *
 */
@Component("userPrizeAAction")
@Scope("prototype")
public class UserPrizeAAction extends BaseAction implements ModelDriven<user_prize_a>{
	
	@Autowired
	@Resource
	public UserPrizeADao userPrizeADao;
	
	//获取userPrizeA_get
	public void get(){
		PageList pageList = userPrizeADao.getUserPrizeA(userPrizeA, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加userPrizeA_insert
	public void insert(){
		String outMess = userPrizeADao.addUserPrizeA(userPrizeA);
		this.outJson(outMess);
	}
	
	//删除userPrizeA_remove
	public void remove(){
		String outMess = userPrizeADao.deleteUserPrizeA(userPrizeA);
		this.outJson(outMess);
	}
	
	//修改userPrizeA_update
	public void update(){
		String outMess = userPrizeADao.updateUserPrizeA(userPrizeA);
		this.outJson(outMess);
	}
	
	user_prize_a userPrizeA = new user_prize_a();
	public user_prize_a getModel() {
		// TODO Auto-generated method stub
		return userPrizeA;
	}
}
