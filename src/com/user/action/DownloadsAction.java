package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.DownloadsDao;
import com.user.model.downloads;
import com.opensymphony.xwork2.ModelDriven;

/**
 * downloads请求处理
 * @author 张宏
 *
 */
@Component("downloadsAction")
@Scope("prototype")
public class DownloadsAction extends BaseAction implements ModelDriven<downloads>{
	
	@Autowired
	@Resource
	public DownloadsDao downloadsDao;
	
	//获取downloads-get
	public void get(){
		PageList pageList = downloadsDao.getDownloads(downloads, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加downloads-insert
	public void insert(){
		String outMess = downloadsDao.addDownloads(downloads);
		this.outJson(outMess);
	}
	
	//删除downloads-remove
	public void removes(){
		String outMess = downloadsDao.deleteDownloads(downloads);
		this.outJson(outMess);
	}
	
	//修改downloads-update
	public void update(){
		String outMess = downloadsDao.updateDownloads(downloads);
		this.outJson(outMess);
	}
	
	downloads downloads = new downloads();
	public downloads getModel() {
		// TODO Auto-generated method stub
		return downloads;
	}
}
