package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangTaskDao;
import com.user.model.gang_task;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_task请求处理
 * @author 张宏
 *
 */
@Component("gangTaskAction")
@Scope("prototype")
public class GangTaskAction extends BaseAction implements ModelDriven<gang_task>{
	
	@Autowired
	@Resource
	public GangTaskDao gangTaskDao;
	
	//获取gangTask-get
	public void get(){
		PageList pageList = gangTaskDao.getGangTask(gangTask, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangTask-insert
	public void insert(){
		String outMess = gangTaskDao.addGangTask(gangTask);
		this.outJson(outMess);
	}
	
	//删除gangTask-remove
	public void remove(){
		String outMess = gangTaskDao.deleteGangTask(gangTask);
		this.outJson(outMess);
	}
	
	//修改gangTask-update
	public void update(){
		String outMess = gangTaskDao.updateGangTask(gangTask);
		this.outJson(outMess);
	}
	
	gang_task gangTask = new gang_task();
	public gang_task getModel() {
		// TODO Auto-generated method stub
		return gangTask;
	}
}
