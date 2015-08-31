package com.sys.model;

import java.io.Serializable;

/**
 * sites
 * @author lxj
 *
 */
public class site implements Serializable{

	private String id;//
	private String name;//
	private Integer type;//
	private String img;//
	private Float price;//
	private String place;//
	private String region_id;//
	private String tel;//
	private String Longitude;//
	private String Latitude;//
	private String createtime;//
	private Integer isdetele;//

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	 
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRegion_id() {
		return region_id;
	}
	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String Longitude) {
		this.Longitude = Longitude;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String Latitude) {
		this.Latitude = Latitude;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getIsdetele() {
		return isdetele;
	}
	public void setIsdetele(Integer isdetele) {
		this.isdetele = isdetele;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into sites ");
		sql.append("(id, name, type, img, price, place, region_id, tel, Longitude, Latitude, createtime, isdetele) ");
		sql.append("values ");
		sql.append("(:id, :name, :type, :img, :price, :place, :region_id, :tel, :Longitude, :Latitude, CURRENT_TIMESTAMP, :isdetele) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from sites where id=:id ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(site sites){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, name, type, img, price, place, region_id, tel, Longitude, Latitude, createtime, isdetele ");
		sql.append("from sites where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(site sites){
		StringBuffer sql = new StringBuffer();
		sql.append("update sites ");
		
		sql.append("set id = :id");
		if(sites.getName()!=null&&sites.getName().length()>0){
			sql.append(",name = :name");
		}
		if(sites.getType()!=null){
			sql.append(",type = :type");
		}
		if(sites.getImg()!=null&&sites.getImg().length()>0){
			sql.append(",img = :img");
		}
		if(sites.getPrice()!=null){
			sql.append(",price = :price");
		}
		if(sites.getPlace()!=null&&sites.getPlace().length()>0){
			sql.append(",place = :place");
		}
		if(sites.getRegion_id()!=null&&sites.getRegion_id().length()>0){
			sql.append(",region_id = :region_id");
		}
		if(sites.getTel()!=null&&sites.getTel().length()>0){
			sql.append(",tel = :tel");
		}
		if(sites.getLongitude()!=null&&sites.getLongitude().length()>0){
			sql.append(",Longitude = :Longitude");
		}
		if(sites.getLatitude()!=null&&sites.getLatitude().length()>0){
			sql.append(",Latitude = :Latitude");
		}
		if(sites.getCreatetime()!=null&&sites.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(sites.getIsdetele()!=null){
			sql.append(",isdetele = :isdetele");
		}
		
		
		return sql.toString();
	}

}
