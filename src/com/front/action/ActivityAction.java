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
import com.front.service.UserService;
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
	
	@Autowired
	@Resource
	public UserService userService;
	
	
	
	/**
	 * 测试首页进入方法
	 * activity-index
	 * @return
	 */
	public String index() {
		wxuser wxuser = new wxuser();
		wxuser.setId("4");
		wxuser = (wxuser) serviceDao.getList(wxuser, sqlSelectName).get(0);
		session.put("wxuser", wxuser);
		
		  String url = "/pages/front/index_home.jsp";
	         this.setForwardJsp(url); // 到抽奖页面
	 		return FORWARD;
	}
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
	
	
	/**
	 * activity-queryAll
	 */
	public void queryAll() {
		wxuser  wxuser = (wxuser) session.get("wxuser");
		System.out.println("当前页:"+activity.getPageNum());
		System.out.println("当前页:"+getRequest().getParameter("pageNum"));
		PageList list = activityService.queryAll(activity,wxuser);
		this.outJson(list);
	}	
	
	
	/**
	 * 到报名详情页面
	 * activity-toDetail
	 * @return
	 */
	public String toDetail(){
		String url = "";
		//System.out.println("toDeetal");
		wxuser wxuser = (wxuser) session.get("wxuser");
		activity = activityService.getActivity(activity);
		wxuser createUser = new wxuser();
		createUser.setId(activity.getCreate_userid());
		createUser = userService.queryWxuser(createUser);
		this.setAttribute("activity", activity);
		activity.setNickname(createUser.getNickname());
		activity.setPhoto(createUser.getPhoto());
		activity.setSex(createUser.getSex());
		activity.setTel(createUser.getTel());
		session.put("activity", activity);
		this.setAttribute("createUser", createUser);
		 url = "/pages/front/homeEnroll.jsp";
		 this.setForwardJsp(url); 
		 return FORWARD;
	}
	
	
	/**
	 * 到发起约战页，筛选出最近的场馆信息
	 * activity-toAdd
	 */
	public String toAdd() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		site sites = new site();
		site nearestSite = new site();
		List<site> sitesList = serviceDao.getList(sites, sqlSelectName);
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
		this.setAttribute("nearestSite", nearestSite);
		String url = "";
		 url = "/pages/front/homeFillin.jsp";
		 this.setForwardJsp(url); 
		 return FORWARD;
//		this.outJson(nearestSite);
	}

	/**
	 * activity-getSiteByBaidu
	 */
	public void getSiteByBaidu(){
		wxuser wxuser = (wxuser) session.get("wxuser");
		site nearestSite = new site();
		List<site> sitesList = serviceDao.getList(nearestSite, sqlSelectName);
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
	
	
	
	
	/**
	 * activity-addActivity
	 */
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
	 * activity-addActivity_test
	 */
	public void addActivity_test() {
		//32.1586610000,119.4281740000
		wxuser wxuser = new wxuser();
		wxuser = (wxuser) serviceDao.getList(wxuser, sqlSelectName).get(1);
		session.put("wxuser", wxuser);
//		wxuser = (wxuser) session.get("wxuser");
//		site site = new site();
//		site = (site) serviceDao.getList(site, sqlSelectName).get(0);
//		activity.setSite(site);
//		//32.1607390000,119.4215630000
//		String mess = "";
//		if(site.getId() != null && !"".equals(site.getId())) {
//			mess = activityService.addActivity(site,activity,wxuser);
//		}else {
//			mess = activityService.addActivity(activity,wxuser);
//		}
		this.outJson(this.codeMess(1, "11"));
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
	 * activity-signUp
	 * @return 我参与的活动
	 * 我要报名，参与活动
	 */
	public String signUp() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		activity = (com.front.model.activity) session.get("activity");
		String mess = "";
		List<signup> list = activityService.querySignsByActivityAndWxuserId(activity, wxuser);
		if(list != null && list.size()>0) {
			mess = this.codeMess(0, "已经报过名");
		}else {
			mess = activityService.signUpActivity(activity,wxuser);
		}
		
		String url = "";
		 url = "/pages/front/homeFillin.jsp";
		 this.setForwardJsp(url); 
		 return FORWARD;
	}	
	
	/**
	 * activity-querySigns
	 * 我参与的活动查询
	 */
	public void querySigns() {
		wxuser wxuser = (wxuser) session.get("wxuser");
		List<signup> list = activityService.querySigns(wxuser);
		this.outJson(list);
	}
}
