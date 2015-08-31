package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangWarDao;
import com.user.model.gang_war;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_war请求处理
 * @author 张宏
 *
 */
@Component("gangWarAction")
@Scope("prototype")
public class GangWarAction extends BaseAction implements ModelDriven<gang_war>{
	
	@Autowired
	@Resource
	public GangWarDao gangWarDao;
	
	//获取gangWar-get
	public void get(){
		PageList pageList = gangWarDao.getGangWar(gangWar, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangWar-insert
	public void insert(){
		String outMess = gangWarDao.addGangWar(gangWar);
		this.outJson(outMess);
	}
	
	//删除gangWar-remove
	public void remove(){
		String outMess = gangWarDao.deleteGangWar(gangWar);
		this.outJson(outMess);
	}
	
	//修改gangWar-update
	public void update(){
		String outMess = gangWarDao.updateGangWar(gangWar);
		this.outJson(outMess);
	}
	
	gang_war gangWar = new gang_war();
	public gang_war getModel() {
		// TODO Auto-generated method stub
		return gangWar;
	}
}
