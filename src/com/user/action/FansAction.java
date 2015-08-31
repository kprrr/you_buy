package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.FansDao;
import com.user.model.fans;
import com.opensymphony.xwork2.ModelDriven;

/**
 * fans请求处理
 * @author 张宏
 *
 */
@Component("fansAction")
@Scope("prototype")
public class FansAction extends BaseAction implements ModelDriven<fans>{
	
	@Autowired
	@Resource
	public FansDao fansDao;
	
	//获取fans-get
	public void get(){
		PageList pageList = fansDao.getFans(fans, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加fans-insert
	public void insert(){
		String outMess = fansDao.addFans(fans);
		this.outJson(outMess);
	}
	
	//删除fans-remove
	public void remove(){
		String outMess = fansDao.deleteFans(fans);
		this.outJson(outMess);
	}
	
	//修改fans-update
	public void update(){
		String outMess = fansDao.updateFans(fans);
		this.outJson(outMess);
	}
	
	fans fans = new fans();
	public fans getModel() {
		// TODO Auto-generated method stub
		return fans;
	}
}
