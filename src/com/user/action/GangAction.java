package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.GangDao;
import com.user.model.gang;
import com.opensymphony.xwork2.ModelDriven;

/**
 * gang请求处理
 * @author 张宏
 *
 */
@Component("gangAction")
@Scope("prototype")
public class GangAction extends BaseAction implements ModelDriven<gang>{
	
	@Autowired
	@Resource
	public GangDao gangDao;
	
	//获取gang-get
	public void get(){
		PageList pageList = gangDao.getGang(gang, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加gang-insert
	public void insert(){
		String outMess = gangDao.addGang(gang);
		this.outJson(outMess);
	}
	
	//删除gang-remove
	public void remove(){
		String outMess = gangDao.deleteGang(gang);
		this.outJson(outMess);
	}
	
	//修改gang-update
	public void update(){
		String outMess = gangDao.updateGang(gang);
		this.outJson(outMess);
	}
	
	gang gang = new gang();
	public gang getModel() {
		// TODO Auto-generated method stub
		return gang;
	}
}
