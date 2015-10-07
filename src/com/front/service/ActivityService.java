package com.front.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.BaseService;
import com.base.Common;
import com.base.Constant;
import com.base.JdbcDao;
import com.base.PageList;
import com.base.ServiceDao;
import com.front.model.activity;
import com.front.model.collects;
import com.front.model.message;
import com.front.model.signup;
import com.front.model.wxuser;
import com.juxinbox.model.AccessToken;
import com.juxinbox.sdk.WeiXinSdk;
import com.sys.model.site;
import com.util.Distance;
import com.util.Property;
import com.util.TimeUtil;

@Component("activityService")
@Scope("prototype")
public class ActivityService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
	@Autowired
	@Resource
	public Property property;
	
	@Autowired
	@Resource
	public MessageService messageService;
	
	@Autowired
	@Resource
	public UserService userService;
	
	public void tran(HttpServletRequest request,HttpServletResponse response,BaseAction action,String redirectUrl,Map<String, Object> map) {
		property.setRealPath(action.getFilePath());
		WeiXinSdk sdk=new WeiXinSdk(request, response, Common.AppId,Common.AppSecret);
		String url = action.getBaseUrl()+redirectUrl;
		if(map != null &&map.size()>0) {
			url = url + "?";
			 for (String key : map.keySet()) {
				   //System.out.println("key= "+ key + " and value= " + map.get(key));
				   url = url + key+"="+ map.get(key) +"&";
				  }
			 url = url.substring(0, url.length()-1);
		}
		
		sdk.sendCodeRequest(url, com.juxinbox.tool.Scope.snsapi_base,"1");
	}
	
	public wxuser redirectUrl(HttpServletRequest request,
			HttpServletResponse response, wxuser wxuser,Map session) throws Exception{
		WeiXinSdk sdk = new WeiXinSdk(Common.AppId,Common.AppSecret);
//		System.out.println("Appid:"+Common.AppId+";AppSerect:"+Common.AppSecret);
//		System.out.println("Code=="+request.getParameter("code"));
		AccessToken accessToken = sdk.getUserAccessToken(request.getParameter("code"));
//		System.out.println("openId："+accessToken.getOpenid()+";unionid:"+accessToken.getUnionid());
		//这里将openId改为unionId
		String wxId=accessToken.getOpenid();
		wxuser.setWxId(wxId);
		try {
			List<wxuser> userList = serviceDao.getList(wxuser, sqlSelectName);
			if (userList.size() <= 0) {
				wxuser = null;
			} else {
				wxuser = userList.get(0);
				session.put("wxuser", wxuser);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wxuser;
		
		 
	}
	
	public String addActivity(site site,activity activity,wxuser wxuser) {
		site = (com.sys.model.site) serviceDao.getList(site, sqlSelectName).get(0);
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
			PageList pageList = serviceDao.getList(activity, "sqlSelectWithWxuser", activity.getPageSize()==0?"10":String.valueOf(activity.getPageSize()),activity.getPageNum()==null?"1":String.valueOf(activity.getPageNum()));
			List<activity> list = pageList.getList();
			for(int i = 0;i<list.size();i++) {
				activity a = list.get(i);
				//System.out.println(wxuser.getWxuser_longitude()+";"+wxuser.getWxuser_latitude()+";"+a.getActivity_longitude()+";"+a.getAcitivity_latitude());
				a.setDistance(Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
					Double.valueOf(wxuser.getWxuser_latitude()),
					Double.valueOf(a.getActivity_longitude()),
					Double.valueOf(a.getAcitivity_latitude())));
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
		activity = (activity) serviceDao.getList(activity, sqlSelectName).get(0);
		//更新报名人数
		activity.setSigned_num(activity.getSigned_num()+1);
		//插入报名
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
		//插入消息
		message msg = new message();
		msg.setId(serviceDao.createKey());
		msg.setSender_id(wxuser.getId());
		msg.setSender_photo(wxuser.getPhoto());
		msg.setSex(wxuser.getSex());
		msg.setSender_nickname(wxuser.getNickname());
		msg.setReceiver_id(activity.getCreate_userid());
		msg.setReceiver_photo(activity.getPhoto());
		msg.setIsread(Constant.NOT_READ);
		msg.setContent(wxuser.getNickname()+"已报名了您发布的"+activity.getActivity_name()+"活动");
		msg.setIsdelete(1);
		try {
				sqlMap = new HashMap<Object, String>();
				sqlMap.clear();
				sqlMap.put(mySign, mySign.sqlInsert());
				sqlMap.put(activity, activity.sqlUpdate(activity));
				sqlMap.put(msg, msg.sqlInsert());
				String mess = this.executeSqlMap(serviceDao, sqlMap);
				return mess;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<signup> querySignsByActivityAndWxuserId(activity activity,wxuser wxuser) {
		signup mySign = new signup();
		mySign.setActivity_id(activity.getId());
		mySign.setUser_id(wxuser.getId());
		List<signup> list = serviceDao.getList(mySign, "sqlSelectByActivityId");
		return list;
	}
	
	public List<signup> querySigns(wxuser wxuser) {
		// TODO Auto-generated method stub
		signup mySign = new signup();
		mySign.setUser_id(wxuser.getId());
		List<signup> list = serviceDao.getList(mySign, sqlSelectName);
		for(int i = 0;i<list.size();i++) {
			signup a = list.get(i);
			//System.out.println(wxuser.getWxuser_longitude()+";"+wxuser.getWxuser_latitude()+";"+a.getActivity_longitude()+";"+a.getAcitivity_latitude());
			a.setDistance(a.getDistance());
			int timeFlag = TimeUtil.compareToCurrent(a.getActivity_starttime());
			if(timeFlag == 1) { //未开始
				a.setActivity_status(Constant.TO_BE_START);
			} else if(timeFlag == 0) {//进行中
				a.setActivity_status(Constant.DOING);
			}else if(timeFlag == 2) {//已结束
				a.setActivity_status(Constant.END_UP);
			}
		}
		Collections.sort(list);
		return list;
	}

	public activity getActivity(activity activity) {
		// TODO Auto-generated method stub
		activity = (com.front.model.activity) serviceDao.getList(activity, sqlSelectName).get(0);
		
		return activity;
	}
}
