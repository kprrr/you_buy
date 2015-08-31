package com.user.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.user.dao.BannerDao;
import com.user.model.banner;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 广告请求处理
 * @author 张宏
 *
 */
@Component("bannerAction")
@Scope("prototype")
public class BannerAction extends BaseAction implements ModelDriven<banner>{
	
	@Autowired
	@Resource
	public BannerDao bannerDao;
	
	//获取banner_get
	public void get(){
		PageList pageList = bannerDao.getBanner(banner, rows, page);
		
		this.outJson(pageList);
	}
	
	//添加banner_insert
	public void insert(){
		String outMess = bannerDao.addBanner(banner);
		this.outJson(outMess);
	}
	
	//删除banner_remove
	public void remove(){
		String outMess = bannerDao.deleteBanner(banner);
		this.outJson(outMess);
	}
	
	//修改banner_update
	public void update(){
		String outMess = bannerDao.updateBanner(banner);
		this.outJson(outMess);
	}
	
	banner banner = new banner();
	public banner getModel() {
		// TODO Auto-generated method stub
		return banner;
	}
}
