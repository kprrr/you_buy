package com.front.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.BaseService;
import com.base.Constant;
import com.base.JdbcDao;
import com.base.PageList;
import com.base.ServiceDao;
import com.front.model.activity;
import com.front.model.collects;
import com.front.model.signup;
import com.front.model.wxuser;
import com.sys.model.site;
import com.util.Distance;
import com.util.TimeUtil;

public class ActivityService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;
	public String addActivity(site site,activity activity,wxuser wxuser) {
		site = (com.sys.model.site) serviceDao.getList(site, site.sqlSelect(site)).get(0);
		activity.setId(JdbcDao.createKey());
		activity.setActivity_longitude(site.getLongitude());
		activity.setAcitivity_latitude(site.getLatitude());
		activity.setSite_name(site.getName());
		activity.setSigned_num(0);
		activity.setCreate_userid(wxuser.getId());
		activity.setActivity_status(Constant.TO_BE_START);
		activity.setShared_times(0);
		activity.setIsdelete(1);
		String mess = "";
		try {
			mess = serviceDao.addObject(activity, sqlInsertName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
	}
	
	public String addActivity(activity activity,wxuser wxuser) {
		activity.setId(JdbcDao.createKey());
		activity.setSigned_num(0);
		activity.setCreate_userid(wxuser.getId());
		activity.setActivity_status(Constant.TO_BE_START);
		activity.setShared_times(0);
		activity.setIsdelete(1);
		String mess = "";
		try {
			mess = serviceDao.addObject(activity, sqlInsertName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
		
	}

	public PageList queryAll(activity activity,wxuser wxuser) {
		// TODO Auto-generated method stub
		try {
			PageList pageList = serviceDao.getList(activity, activity.sqlSelectWithWxuser(activity), String.valueOf(activity.getPageSize()), String.valueOf(activity.getPageNum()));
			List<activity> list = pageList.getList();
			for(int i = 0;i<list.size();i++) {
				activity a = list.get(i);
				a.setDistance(Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
					Double.valueOf(wxuser.getWxuser_latitude()),
					Double.valueOf(activity.getActivity_longitude()),
					Double.valueOf(activity.getAcitivity_latitude())));
				int timeFlag = TimeUtil.compareToCurrent(a.getStarttime());
				if(timeFlag == 1) { //未开始
					a.setActivity_status(Constant.TO_BE_START);
				} else if(timeFlag == 0) {//进行中
					a.setActivity_status(Constant.DOING);
				}else if(timeFlag == 2) {//已结束
					a.setActivity_status(Constant.END_UP);
				}
			}
			Collections.sort(list);
			pageList.setList(list);
			return pageList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String collectActivity(activity activity,wxuser wxuser) {
		// TODO Auto-generated method stub
		activity = (activity) serviceDao.getList(activity, activity.sqlSelect(activity)).get(0);
		collects myCollect = new collects();
		myCollect.setId(JdbcDao.createKey());
		myCollect.setUser_id(wxuser.getId());
		myCollect.setActivity_id(activity.getId());
		myCollect.setIsotherpay(activity.getIsotherpay());
		myCollect.setSite_name(activity.getSite_name());
		myCollect.setSite_address(activity.getSite_address());
		myCollect.setDistance((int)Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
					Double.valueOf(wxuser.getWxuser_latitude()),
					Double.valueOf(activity.getActivity_longitude()),
					Double.valueOf(activity.getAcitivity_latitude())));
		myCollect.setActivity_starttime(activity.getStarttime());
		myCollect.setSignup_num(activity.getSigned_num());
		myCollect.setIsdelete(1);
		
		try {
			String mess = serviceDao.addObject(myCollect, myCollect.sqlInsert());
			return mess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<collects> queryCollects(wxuser wxuser) {
		// TODO Auto-generated method stub
		collects myCollect = new collects();
		myCollect.setUser_id(wxuser.getId());
		List<collects> list = serviceDao.getList(myCollect, myCollect.sqlSelect(myCollect));
		return list;
	}

	public String signUpActivity(activity activity, wxuser wxuser) {
		// TODO Auto-generated method stub
		activity = (activity) serviceDao.getList(activity, activity.sqlSelect(activity)).get(0);
		signup mySign = new signup();
		mySign.setId(JdbcDao.createKey());
		mySign.setUser_id(wxuser.getId());
		mySign.setActivity_id(activity.getId());
		mySign.setIsotherpay(activity.getIsotherpay());
		mySign.setSite_name(activity.getSite_name());
		mySign.setSite_address(activity.getSite_address());
		mySign.setDistance((int)Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
					Double.valueOf(wxuser.getWxuser_latitude()),
					Double.valueOf(activity.getActivity_longitude()),
					Double.valueOf(activity.getAcitivity_latitude())));
		mySign.setActivity_starttime(activity.getStarttime());
		mySign.setSignup_num(activity.getSigned_num());
		mySign.setIsdelete(1);
		
		try {
			String mess = serviceDao.addObject(mySign, mySign.sqlInsert());
			return mess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<signup> querySigns(wxuser wxuser) {
		// TODO Auto-generated method stub
		signup mySign = new signup();
		mySign.setUser_id(wxuser.getId());
		List<signup> list = serviceDao.getList(mySign, mySign.sqlSelect(mySign));
		return list;
	}
}
