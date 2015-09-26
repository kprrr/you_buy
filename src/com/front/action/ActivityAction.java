package com.front.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.PageList;
import com.base.ServiceDao;
import com.front.model.activity;
import com.front.model.collects;
import com.front.model.signup;
import com.front.model.wxuser;
import com.front.service.ActivityService;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.model.site;
import com.util.Distance;



@Component("activityAction")
@Scope("prototype")
public class ActivityAction extends BaseAction implements ModelDriven<activity>{
	private static final long serialVersionUID = 1L;
	activity activity = new activity();
	public activity getModel() {
		return activity;
	}
	
	@Autowired
	@Resource
	public ActivityService activityService;

	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
//	@Autowired
//	@Resource
//	public MallService mallService;
	
//	
//	/**
//	 * mall-index
//	 * @return
//	 */
//	public String index() {
//		zh_mall_wxuser wxuser = new zh_mall_wxuser();
//		wxuser.setId("0001b3f459cc086099a6fc4e268be9d3");
//		try {
//			List<zh_mall_wxuser> userList = serviceDao.getList(wxuser, sqlSelectName, null, null).getList();
//			wxuser = userList.get(0);
//			session.put("wxuser", wxuser);
////			List<WorkingSpace> obList =  Common.getWorkingSpaceList();
////			session.put("wsList", obList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		  String url = "/zh_mall_index.jsp";
//	         this.setForwardJsp(url); // 到抽奖页面
//	 		return FORWARD;
//	}
//
	/**
	 *活动入口
	 * activity-tran
	 */
	public void tran() {
		String fromPage = getRequest().getParameter("fromPage");
		Map<String, Object> map = new HashMap<String, Object>();
		if(fromPage != null && !"".equals(fromPage)) {
			if(fromPage.equals("share")) {
				map.put("id", getRequest().getParameter("id"));
				map.put("fromPage", fromPage);
			}else if(fromPage.equals("index")){
				map.put("fromPage", fromPage);
				
			}else if(fromPage.equals("user")) {
				map.put("user", fromPage);
			}
		}
		activityService.tran(getRequest(), getResponse(), this, "activity-redirectUrl",map);
		
		
	}
//	
//	/**
//	 * 分派url
//	 * activity-redirectUrl
//	 */
	public String redirectUrl() throws Exception{
		session.clear();
		wxuser user = activityService.redirectUrl(getRequest(), getResponse(), new wxuser(), session);
		session.put(user, "wxuser");
		String from = getRequest().getParameter("fromPage");
		String redirectUrl = "";
		if(from != null && !"".equals(from)) { 
			if(from.equals("share")) {
				redirectUrl ="activity-toDetail?id="+getRequest().getParameter("id");
			}else if(from.equals("index")){
				redirectUrl ="activity-listIndex";
			}else if(from.equals("user")) {
				redirectUrl ="user-index";
			}
		}
	     this.setRedirectName(redirectUrl);
	     return REDIRECT;
			
	}
	
	
	/**
	 *  activity-listIndex
	 * @return
	 */
	public String listIndex() {
		String url = "";
//		 String from = getRequest().getParameter("resource");
//		 zh_mall_wxuser wxuser = (zh_mall_wxuser) session.get("wxuser");
//		 if(from==null ||from.equals("index")){
// 			 url = "/WEB-INF/pages/index.jsp";
//		 }else if(from.equals("shareToDetail")){
//			 //String cmId = cm.getId(); 
//			 url="/WEB-INF/pages/detail.jsp";
//		 }
		 //url = "/product_show.jsp";
		 url = "/zh_mall_index.jsp";
		 this.setForwardJsp(url); // 到首页
		 return FORWARD;
	}
	
	public void queryAll() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		PageList list = activityService.queryAll(activity,wxuser);
		this.outJson(list);
	}	
	
	/**
	 * 到发起约战页，筛选出最近的场馆信息
	 */
	public void toAdd() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		site sites = new site();
		site nearestSite = new site();
		List<site> sitesList = serviceDao.getList(sites, sites.sqlSelect(sites));
		for(int i=0;i<sitesList.size();i++) {
			site site = sitesList.get(i);
			site.setDistance(Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
					Double.valueOf(wxuser.getWxuser_latitude()),
					Double.valueOf(site.getLongitude()),
					Double.valueOf(site.getLatitude())));
			if(nearestSite.getId() != null) {
				if(site.getDistance() <=nearestSite.getDistance()) {
					nearestSite = site;
				}
			}else {
				nearestSite = site;
			}
		}
		this.outJson(nearestSite);
	}

	public void addActivity() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		site site = activity.getSite();
		String mess = "";
		if(site.getId() != null && !"".equals(site.getId())) {
			mess = activityService.addActivity(site,activity,wxuser);
		}else {
			mess = activityService.addActivity(activity,wxuser);
		}
	}
	
	
	/**
	 * 分享
	 */
	public void shareActivity() {
		synchronized (activity) {
			try {
				this.outJson(serviceDao.updateObject(activity, activity.sqlUpdateWithAddShare(activity)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	 
	/**
	 * 收藏活动
	 */
	public void collectActivity() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		String mess = activityService.collectActivity(activity,wxuser);
		this.outJson(mess);
	}
	
	/**
	 * 我的收藏查询
	 */
	public void queryCollects() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<collects> list = activityService.queryCollects(wxuser);
		this.outJson(list);
	}
	
	/**
	 * 参与活动
	 */
	public void signUp() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		String mess = activityService.signUpActivity(activity,wxuser);
		this.outJson(mess);
	}	
	
	/**
	 * 我参与的活动查询
	 */
	public void querySigns() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<signup> list = activityService.querySigns(wxuser);
		this.outJson(list);
	}
}
