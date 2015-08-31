package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangArtiShipDao;
import com.user.model.gang_arti_ship;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_arti_ship请求处理
 * @author 张宏
 *
 */
@Component("gangArtiShipAction")
@Scope("prototype")
public class GangArtiShipAction extends BaseAction implements ModelDriven<gang_arti_ship>{
	
	@Autowired
	@Resource
	public GangArtiShipDao gangArtiShipDao;
	
	//获取gangArtiShip-get
	public void get(){
		PageList pageList = gangArtiShipDao.getGangArtiShip(gangArtiShip, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangArtiShip-insert
	public void insert(){
		String outMess = gangArtiShipDao.addGangArtiShip(gangArtiShip);
		this.outJson(outMess);
	}
	
	//删除gangArtiShip-remove
	public void remove(){
		String outMess = gangArtiShipDao.deleteGangArtiShip(gangArtiShip);
		this.outJson(outMess);
	}
	
	//修改gangArtiShip-update
	public void update(){
		String outMess = gangArtiShipDao.updateGangArtiShip(gangArtiShip);
		this.outJson(outMess);
	}
	
	gang_arti_ship gangArtiShip = new gang_arti_ship();
	public gang_arti_ship getModel() {
		// TODO Auto-generated method stub
		return gangArtiShip;
	}
}
