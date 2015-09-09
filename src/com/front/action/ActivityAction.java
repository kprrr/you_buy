package com.front.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.activity;
import com.front.model.wxuser;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.model.site;



@Component("activityAction")
@Scope("prototype")
public class ActivityAction extends BaseAction implements ModelDriven<activity>{
	private static final long serialVersionUID = 1L;
	activity activity = new activity();
	public activity getModel() {
		return activity;
	}
	
//	@Autowired
//	@Resource
//	public Property property;

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
//	/**
//	 *活动入口
//	 * mall-tran
//	 */
//	public void tran() {
//		String fromPage = getRequest().getParameter("fromPage");
//		Map<String, Object> map = new HashMap<String, Object>();
//		if(fromPage != null && !"".equals(fromPage)) {
//			if(fromPage.equals("share")) {
//				map.put("id", getRequest().getParameter("id"));
//				map.put("fromPage", fromPage);
//			}else if(fromPage.equals("index")){
//				map.put("fromPage", fromPage);
//				
//			}
//		}
//		mallService.tran(getRequest(), getResponse(), this, "mall-redirectUrl",map);
//		
//		
//	}
//	
//	/**
//	 * 分派url
//	 * mall-redirectUrl
//	 */
//	public String redirectUrl() throws Exception{
//		session.clear();
//		zh_mall_wxuser user = mallService.redirectUrl(getRequest(), getResponse(), new zh_mall_wxuser(), session);
//		session.put(user, "wxuser");
//		String from = getRequest().getParameter("fromPage");
//		String redirectUrl = "";
//		if(from != null && !"".equals(from)) { 
//			if(from.equals("share")) {
//				redirectUrl ="mall-toDetail?id="+getRequest().getParameter("id");
//			}else if(from.equals("index")){
//				redirectUrl ="mall-listIndex";
//			}
//		}
//	     this.setRedirectName(redirectUrl);
//	     return REDIRECT;
//			
//	}
//	
//	
//	/**
//	 *  mall-listIndex
//	 * @return
//	 */
//	public String listIndex() {
//		String url = "";
////		 String from = getRequest().getParameter("resource");
////		 zh_mall_wxuser wxuser = (zh_mall_wxuser) session.get("wxuser");
////		 if(from==null ||from.equals("index")){
//// 			 url = "/WEB-INF/pages/index.jsp";
////		 }else if(from.equals("shareToDetail")){
////			 //String cmId = cm.getId(); 
////			 url="/WEB-INF/pages/detail.jsp";
////		 }
//		 //url = "/product_show.jsp";
//		 url = "/zh_mall_index.jsp";
//		 this.setForwardJsp(url); // 到抽奖页面
//		 return FORWARD;
//	}
//	
//	/**
//	 * index页面列表查询
//	 * 除去6.4新增的4种机型
//	 * mall-queryGoodList
//	 */
//	public void queryGoodList() {
//		zh_mall_wxuser wxuser = (zh_mall_wxuser) session.get("wxuser");
//		String orderName;
////		product.setActivity_id("1");
//		session.put("product", product);
//		try {
//			List<zh_mall_product> goodList = serviceDao.getList(product, "sqlSelectForList");
//			this.outJson(goodList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 6.4新增4种机型的查询
//	 */
//	public void queryGoodForNewList() {
//		zh_mall_wxuser wxuser = (zh_mall_wxuser) session.get("wxuser");
//		String orderName;
//		session.put("product", product);
//		try {
//			List<zh_mall_product> goodList = serviceDao.getList(product, "sqlSelectForNewList");
//			this.outJson(goodList);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 详情查看
//	 * mall-toDetail
//	 * @return
//	 */
//	public String toDetail() {
//		product = (zh_mall_product) serviceDao.findObjByCondition(product, sqlSelectName);
//		session.put("product", product);
//				this.setForwardJsp("/product_detail.jsp");
//				return FORWARD;
//	}
//	
//	/**
//	 * 详情页
//	 * mall-detailQuery
//	 */
//	public void detailQuery() {
//		zh_mall_wxuser wxuser = (zh_mall_wxuser) session.get("wxuser");
//			zh_mall_product productSession = (zh_mall_product) session.get("product");
////				List<zh_mall_product_img> imgList = mallService.getList(product,"sqlSelectForImgList");
////				product.setImgList(imgList);
////				List<zh_mall_product_info> in	foList = mallService.getList(product, "sqlSelectForInfoList");
////				product.setInfoList(infoList);
////			product = (zh_mall_product) mallService.findObjByCondition(product,"sqlSelectForDetail");
//		product = mallService.queryProductDetail(productSession);
////		try {
////			System.out.println("=================到详情页=====从请求中获取到的商品型号(转码前)："+product.getProduct_name());
////			System.out.println("============到详情页==========从请求中获取到的商品型号（转码后用的UTF-8）："+new String(product.getProduct_name().getBytes("ISO-8859-1"), "UTF-8"));
////			System.out.println("==============到详情页========从请求中获取到的商品型号（转码后用的GBK）："+new String(product.getProduct_name().getBytes("ISO-8859-1"), "GBK"));
////		} catch (Exception e) {
////		}
//		session.put("product", product);
//			this.outJson(product);
//	}
//	
//	/**
//	 * 到合约计划页
//	 * mall-toContactPlan
//	 * @return
//	 */
//	public String toContactPlan() {
//		session.put("order", null);
//		zh_mall_product productSession = (zh_mall_product) session.get("product");
//		String productInfo = getRequest().getParameter("productInfo");
////		try {
////			productInfo = new String(productInfo.getBytes("ISO-8859-1"), "UTF-8");
////		System.out.println("======================从请求中获取到的商品型号(转码前)："+productInfo);
////			System.out.println("======================从请求中获取到的商品型号（转码后用的UTF-8）："+productInfo);
////			System.out.println("======================从请求中获取到的商品型号（转码后用的GBK）："+new String(getRequest().getParameter("productInfo").getBytes("ISO-8859-1"), "GBK"));
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		}
////		System.out.println("+================="+getRequest().getParameter("productInfo"));
//		zh_mall_activity activity = new zh_mall_activity();
//		activity = (zh_mall_activity) mallService.queryContactPlan(productSession);
//		this.setAttribute("activity", activity);
//		session.put("activity", activity);
//		zh_mall_order order = new zh_mall_order();
//		order.setProductInfo(productInfo.substring(0,productInfo.length()-1));
//		session.put("order", order);
//		this.setForwardJsp("/product_plan.jsp");
//		return FORWARD;
//	}
//	
//	
//	/**
//	 * 到购买页面
//	 * mall-toProductBuy
//	 * @return
//	 */
//	public String toProductBuy() {
//		
//		
//		this.setForwardJsp("/product_buy.jsp");
//		return FORWARD;
//	}
//	
//	
//	/**
//	 * vote-ImageUpload
//	 * 图片上传
//	 */
////	public void ImageUpload() {
////		File file = cm.getImgurlFile();
////		String fileFileName = cm.getImgurlFileFileName();
////		fileFileName = fileFileName.substring(fileFileName.lastIndexOf("."),fileFileName.length());
////		fileFileName = String.valueOf(new Date().getTime()) + fileFileName;
////		String path = getFilePath() + "/upload/" + fileFileName;
////		String pathName="upload/+" + fileFileName;
////		try {
////			FileInputStream fis = new FileInputStream(file);
////			System.out.println("===" + fis.available());
////			if (fis.available() >= 5242880) {
////				this.jsonSystemOutPrint(codeMess(10005, "上传文件过大,请重上传其他图片!"));
////			} else {
////				byte[] b = new byte[500];
////				FileOutputStream fos = new FileOutputStream(path);
////				while (fis.read(b) > 0) {
////					fos.write(b);
////				}
//////				this.jsonSystemOutPrint(codeMess(Code.SCODE, "/upload/"
//////						+ fileFileName));
////			}
////		} catch (IOException e) {
////			this.jsonSystemOutPrint(codeMess(0, "上传失败"));
////		}
////		String mess=this.codeMess(10000, pathName);
////		this.jsonSystemOutPrint(mess);
////	}
//	
//	
	public void add() {
		wxuser wxuser = (com.front.model.wxuser) session.get("wxuser");
		site sites = new site();
		List<site> sitesList = serviceDao.getList(sites, sites.sqlSelect(sites));
	}

}
