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
	private String price;//
	private String place;//
	private String region_id;//
	private String tel;//
	private String longitude;//
	private String latitude;//
	private String createtime;//
	private Integer isdetele;//
	
	
	private String region_name;
	
	

	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
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
	 
	 
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
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
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
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
		sql.append(" (id, name, type, img, price, place, region_id, tel, longitude, latitude, createtime, isdetele) ");
		sql.append(" values ");
		sql.append("(:id, :name, :type,:img, :price,:place,:region_id,:tel,:longitude,:latitude, CURRENT_TIMESTAMP, :isdetele) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from sites where id=:id ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(site site){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, name, type, img, price, place, region_id, tel, longitude, latitude, createtime, isdetele ");
		sql.append("from sites where 1 = 1 ");
		if(site.getId()!=null&&site.getId().length()>0){
			sql.append(" and id = :id");
		}
		if(site.getName()!=null&&site.getName().length()>0){
			sql.append(" and name = :name");
		}
		
		return sql.toString();
	}
	
	public String sqlSelectWithRegionName(site site) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT r.region_name as region_name,s.* from sites s LEFT JOIN region r ON s.region_id = r.region_id where 1=1 ");
		if(site.getId()!=null&&site.getId().length()>0){
			sql.append(" and id = :id");
		}
		if(site.getName()!=null&&site.getName().length()>0){
			sql.append(" and name = :name");
		}
		return sql.toString();
	}
	
	
	//生成修改语句
	public String sqlUpdate(site sites){
		StringBuffer sql = new StringBuffer();
		sql.append("update sites ");
		
		sql.append("set id = :id");
		if(sites.getName()!=null&&sites.getName().length()>0){
			sql.append(",name = '"+sites.getName()+"'");
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
			sql.append(",longitude = :longitude");
		}
		if(sites.getLatitude()!=null&&sites.getLatitude().length()>0){
			sql.append(",latitude = :latitude");
		}
		if(sites.getCreatetime()!=null&&sites.getCreatetime().length()>0){
			sql.append(",createtime = CURRENT_TIMESTAMP");
		}
		if(sites.getIsdetele()!=null){
			sql.append(",isdetele = :isdetele");
		}
		sql.append( " where id=:id");
		
		return sql.toString();
	}

}
