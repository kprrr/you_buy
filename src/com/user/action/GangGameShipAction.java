package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangGameShipDao;
import com.user.model.gang_game_ship;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_game_ship请求处理
 * @author 张宏
 *
 */
@Component("gangGameShipAction")
@Scope("prototype")
public class GangGameShipAction extends BaseAction implements ModelDriven<gang_game_ship>{
	
	@Autowired
	@Resource
	public GangGameShipDao gangGameShipDao;
	
	//获取gangGameShip-get
	public void get(){
		PageList pageList = gangGameShipDao.getGangGameShip(gangGameShip, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangGameShip-insert
	public void insert(){
		String outMess = gangGameShipDao.addGangGameShip(gangGameShip);
		this.outJson(outMess);
	}
	
	//删除gangGameShip-remove
	public void remove(){
		String outMess = gangGameShipDao.deleteGangGameShip(gangGameShip);
		this.outJson(outMess);
	}
	
	//修改gangGameShip-update
	public void update(){
		String outMess = gangGameShipDao.updateGangGameShip(gangGameShip);
		this.outJson(outMess);
	}
	
	gang_game_ship gangGameShip = new gang_game_ship();
	public gang_game_ship getModel() {
		// TODO Auto-generated method stub
		return gangGameShip;
	}
}
