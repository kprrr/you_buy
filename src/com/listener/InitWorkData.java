package com.listener;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.base.Common;
import com.sys.dao.RegionDao;
import com.sys.model.region;
import com.util.Property;

public class InitWorkData implements ApplicationListener {

	 @Autowired
	    @Resource
	    public RegionDao regionDao;
	 
	 @Autowired
		@Resource
		public Property property;
	
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		// TODO Auto-generated method stub
//		if(arg0.().getParent() == null){//root application context 没有parent，他就是老大.  
//	         //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。  
//	    }  
		List list = this.regionDao.getRegion(new region());
//		System.out.println("获取到数据："+list.size()+"条");
		Common.regionList = list;
		Common.AppId=property.getValueByKey("AppId");
		Common.AppSecret=property.getValueByKey("AppSecret");
	}

}
