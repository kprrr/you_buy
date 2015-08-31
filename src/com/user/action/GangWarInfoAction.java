package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangWarInfoDao;
import com.user.model.gang_war_info;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_war_info请求处理
 * @author 张宏
 *
 */
@Component("gangWarInfoAction")
@Scope("prototype")
public class GangWarInfoAction extends BaseAction implements ModelDriven<gang_war_info>{
	
	@Autowired
	@Resource
	public GangWarInfoDao gangWarInfoDao;
	
	//获取gangWarInfo-get
	public void get(){
		PageList pageList = gangWarInfoDao.getGangWarInfo(gangWarInfo, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangWarInfo-insert
	public void insert(){
		String outMess = gangWarInfoDao.addGangWarInfo(gangWarInfo);
		this.outJson(outMess);
	}
	
	//删除gangWarInfo-remove
	public void remove(){
		String outMess = gangWarInfoDao.deleteGangWarInfo(gangWarInfo);
		this.outJson(outMess);
	}
	
	//修改gangWarInfo-update
	public void update(){
		String outMess = gangWarInfoDao.updateGangWarInfo(gangWarInfo);
		this.outJson(outMess);
	}
	
	gang_war_info gangWarInfo = new gang_war_info();
	public gang_war_info getModel() {
		// TODO Auto-generated method stub
		return gangWarInfo;
	}
}
