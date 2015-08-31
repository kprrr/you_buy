package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangArtiDao;
import com.user.model.gang_arti;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_arti请求处理
 * @author 张宏
 *
 */
@Component("gangArtiAction")
@Scope("prototype")
public class GangArtiAction extends BaseAction implements ModelDriven<gang_arti>{
	
	@Autowired
	@Resource
	public GangArtiDao gangArtiDao;
	
	//获取gangArti-get
	public void get(){
		PageList pageList = gangArtiDao.getGangArti(gangArti, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangArti-insert
	public void insert(){
		String outMess = gangArtiDao.addGangArti(gangArti);
		this.outJson(outMess);
	}
	
	//删除gangArti-remove
	public void remove(){
		String outMess = gangArtiDao.deleteGangArti(gangArti);
		this.outJson(outMess);
	}
	
	//修改gangArti-update
	public void update(){
		String outMess = gangArtiDao.updateGangArti(gangArti);
		this.outJson(outMess);
	}
	
	gang_arti gangArti = new gang_arti();
	public gang_arti getModel() {
		// TODO Auto-generated method stub
		return gangArti;
	}
}
