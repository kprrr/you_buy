package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangGameDao;
import com.user.model.gang_game;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang_game请求处理
 * @author 张宏
 *
 */
@Component("gangGameAction")
@Scope("prototype")
public class GangGameAction extends BaseAction implements ModelDriven<gang_game>{
	
	@Autowired
	@Resource
	public GangGameDao gangGameDao;
	
	//获取gangGame-get
	public void get(){
		PageList pageList = gangGameDao.getGangGame(gangGame, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gangGame-insert
	public void insert(){
		String outMess = gangGameDao.addGangGame(gangGame);
		this.outJson(outMess);
	}
	
	//删除gangGame-remove
	public void remove(){
		String outMess = gangGameDao.deleteGangGame(gangGame);
		this.outJson(outMess);
	}
	
	//修改gangGame-update
	public void update(){
		String outMess = gangGameDao.updateGangGame(gangGame);
		this.outJson(outMess);
	}
	
	gang_game gangGame = new gang_game();
	public gang_game getModel() {
		// TODO Auto-generated method stub
		return gangGame;
	}
}
