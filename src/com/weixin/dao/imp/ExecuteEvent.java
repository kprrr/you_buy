package com.weixin.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.tools.Tool;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.Common;
import com.base.JdbcDao;
import com.base.ServiceDao;
import com.front.model.wxuser;
import com.front.service.UserService;
import com.juxinbox.model.WxUserInfo;
import com.juxinbox.sdk.WeiXinSdk;
import com.util.WeiXinXml;
import com.weixin.model.ws_mess;

import net.sf.json.JSONObject;

/**
 * 处理欢迎语的
 * @author lxj
 *
 */



public class ExecuteEvent {
	
	
	
	private wxuser wxuser;
	
	//开始处理
	public String start(UserService userService,ws_mess mess){
		String outMess = "";
		//判断是取消还是关注
		String type = mess.getEvent();
		if(type.equals("subscribe")){//开始订阅
			outMess = WeiXinXml.text(mess, "欢迎关注!");
			wxuser  = new wxuser();
			WeiXinSdk sdk = new WeiXinSdk(Common.AppId, Common.AppSecret);
			WxUserInfo wxUserInfo = sdk.getUserInfo(mess.getFromUserName());
			wxuser.setWxId(mess.getFromUserName());
			wxuser.setNickname(wxUserInfo.getNickname());
			wxuser.setPhoto(wxUserInfo.getHeadimgurl());
			wxuser.setSex(Integer.valueOf(wxUserInfo.getSex()));
			wxuser.setWxuser_longitude(mess.getLocation_X());
			wxuser.setWxuser_latitude(mess.getLocation_Y());
			try {
				outMess=userService.addWxuser(wxuser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(type.equals("unsubscribe")){//取消订阅
			System.out.println("用户取消订阅");
		}else if(type.equals("CLICK")){//按钮点击事件
			try {
//				String eventKey = mess.getEventKey();
//				String[] temp = eventKey.split("-");
//				app_data nextAppData = new app_data();
//				if(temp[0].equals("id")){
//					nextAppData.setId(temp[1]);
//				}else{
//					nextAppData.setPid(temp[1]);
//				}
//				nextAppData.setApp_id(a.getId());
//				nextAppData.setCreateuser(a.getCreateuser());
//				//默认显示首页提示文字
//				String topText = a.getTop_text();
//				String bottomText = a.getBottom_text();
//				//nextAppData.setSta(1);//取非隐藏数据
//				List<app_data> appDatas = dao.selectSql(nextAppData.sqlSelect(nextAppData), nextAppData);
//				//生成列表
//				outMess = menusToString(dao,appDatas, mess, topText, bottomText);
//				switch (appDatas.size()) {
//				case 0://没有任何信息返回到主菜单
//					//判断是否为首页
//					outMess = WeiXinXml.text(mess, "暂无任何内容!");
//					break;
//				case 1://如果查询只有一个菜单 直接进入
//					mess.setContent("1");
//					mess.setMsgType("text");//输入文字了
////					outMess = dao.getMess(dao.url, mess);
//				default:
//					break;
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(type.equals("SCAN")){//二维码
            //读取二维码内容


        }
		return outMess;
	}
	
	
	//将查询到的菜单转换为字符 并记录用户最后一次操作
//	public String menusToString(WeiXinServerDaoImp dao,List<app_data> appDatas,ws_mess mess,String topText,String bottomText){
//		//处理查询结果
//		StringBuffer temp = new StringBuffer();
//		//顶部提示
//		if(topText!=null){
//			temp.append(topText + "\n");
//		}
//		//记录最后一次操作
//		List<app_user_execute> appUserExecutes = new ArrayList<app_user_execute>();
//		
//		//读取是否显示序号
//		app_tool appAuthority = new app_tool();
//		String hideNo = "0";//显示
//		JSONObject jo = appAuthority.getSetting(dao, Tool.隐藏编号);
//		if(jo!=null){
//			hideNo = jo.getString("hideno");
//		}
//		int i = 0;
//		for(app_data data : appDatas){
//			app_user_execute appUserExecute = new app_user_execute();
//			appUserExecute.setMenu_id(data.getId());
//			appUserExecute.setNo(i++);
//			appUserExecute.setWx_id(mess.getFromUserName());
//			appUserExecutes.add(appUserExecute);
//			
//			temp.append((hideNo.equals("0")?((i) + "、"):"") + data.getTitle() + "\n");
//		}
//		//底部提示
//		if(bottomText!=null){
//			temp.append(bottomText);
//		}
//		
//		//执行最后用户操作
//		app_user appUser = new app_user();
//		appUser.setWx_id(mess.getFromUserName());
//		appUser.setLast_text(temp.toString());
//		appUser.executeLastInfo(dao, appUser, appUserExecutes);
//		
//		return WeiXinXml.text(mess, temp.toString());
//	}
}
