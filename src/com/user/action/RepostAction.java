package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.RepostDao;
import com.user.model.repost;
import com.opensymphony.xwork2.ModelDriven;

/**
 * repost请求处理
 * @author 张宏
 *
 */
@Component("repostAction")
@Scope("prototype")
public class RepostAction extends BaseAction implements ModelDriven<repost>{
	
	@Autowired
	@Resource
	public RepostDao repostDao;
	
	//获取repost-get
	public void get(){
		PageList pageList = repostDao.getRepost(repost, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加repost-insert
	public void insert(){
		String outMess = repostDao.addRepost(repost);
		this.outJson(outMess);
	}
	
	//删除repost-remove
	public void remove(){
		String outMess = repostDao.deleteRepost(repost);
		this.outJson(outMess);
	}
	
	//修改repost-update
	public void update(){
		String outMess = repostDao.updateRepost(repost);
		this.outJson(outMess);
	}
	
	repost repost = new repost();
	public repost getModel() {
		// TODO Auto-generated method stub
		return repost;
	}
}
