package com.weixin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信多图文
 * @author 张宏
 *
 */
public class Image {
	private String title;
	private String description;
	private String picUrl;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public static List<Image> dataCreate() {
		List<Image> images = new ArrayList<Image>();
		Image image1 = new Image();
		image1.setTitle("\n服务用户信息");
		image1.setDescription("");
		image1.setPicUrl("");
		image1.setUrl("");
		images.add(image1);
		Image image2 = new Image();
		image2.setTitle("4S店\n用户认证\\用户积分\\用户级别");
		image2.setDescription("");
		image2.setPicUrl("http://www.juxinbox.com/portal/upload/1409107099970.jpg");
		image2.setUrl("http://www.baidu.com");
		images.add(image2);
		Image image3 = new Image();
		image3.setTitle("4S店2\n用户认证\\用户积分\\用户级别");
		image3.setDescription("");
		image3.setPicUrl("http://www.juxinbox.com/portal/upload/1409107099970.jpg");
		image3.setUrl("http://www.baidu.com");
		images.add(image3);
		Image image4 = new Image();
		image4.setTitle("为您查找到以下服务用户信息，点击头像查看详情");
		image4.setDescription("");
		image4.setPicUrl("");
		image4.setUrl("#");
		images.add(image4);
		return  images;
	}
	public static  List<Image> singleImage() {
		List<Image> images = new ArrayList<Image>();
		Image image = new Image();
		image.setTitle("用户%s向你发送了一条信息\n如有多条回复，请点击此处回复本条");
		image.setDescription("");
		image.setPicUrl("");
		image.setUrl("#");
		images.add(image);
		return  images;
	}
	
}
