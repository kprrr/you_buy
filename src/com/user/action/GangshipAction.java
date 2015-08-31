package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangshipDao;
import com.user.model.gangship;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gangship请求处理
 * @author 张宏
 *
 */
@Component("gangshipAction")
@Scope("prototype")
public class GangshipAction extends BaseAction implements ModelDriven<gangship>{
	
	@Autowired
	@Resource
	public GangshipDao gangshipDao;
	
	//获取gangship-get
	public void get(){
		PageList pageList = gangshipDao.getGangship(gangship, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangship-insert
	public void insert(){
		String outMess = gangshipDao.addGangship(gangship);
		this.outJson(outMess);
	}
	
	//删除gangship-remove
	public void remove(){
		String outMess = gangshipDao.deleteGangship(gangship);
		this.outJson(outMess);
	}
	
	//修改gangship-update
	public void update(){
		String outMess = gangshipDao.updateGangship(gangship);
		this.outJson(outMess);
	}
	
	gangship gangship = new gangship();
	public gangship getModel() {
		// TODO Auto-generated method stub
		return gangship;
	}
}
