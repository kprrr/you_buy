package com.front.model;

import java.io.Serializable;

/**
 * wxuser
 * @author lxj
 *
 */
public class wxuser implements Serializable{

	private String id;//
	private String wxId;//
	private String nickname;//
	private String photo;//
	private Integer sex;//
	private Integer age;//
	private String registtime;//
	private String wxuser_address;//
	private String signature;//
	private String tel;//
	private float wxuser_longitude;
	private float wxuser_latitude;
	private String createtime;//
	private Integer isdelete;//

	public float getWxuser_longitude() {
		return wxuser_longitude;
	}
	public void setWxuser_longitude(float wxuser_longitude) {
		this.wxuser_longitude = wxuser_longitude;
	}
	public float getWxuser_latitude() {
		return wxuser_latitude;
	}
	public void setWxuser_latitude(float wxuser_latitude) {
		this.wxuser_latitude = wxuser_latitude;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getRegisttime() {
		return registtime;
	}
	public void setRegisttime(String registtime) {
		this.registtime = registtime;
	}
	public String getWxuser_address() {
		return wxuser_address;
	}
	public void setWxuser_address(String wxuser_address) {
		this.wxuser_address = wxuser_address;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into wxuser ");
		sql.append("(id, wxId, nickname, photo, sex, age, registtime, wxuser_address, signature, tel, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :wxId, :nickname, :photo, :sex, :age, CURRENT_TIMESTAMP, :wxuser_address, :signature, :tel, CURRENT_TIMESTAMP, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from wxuser ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(wxuser wxuser){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, wxId, nickname, photo, sex, age, registtime, wxuser_address, signature, tel, createtime, isdelete ");
		sql.append("from wxuser where 1 = 1 ");
		if(wxuser.getId()!=null&&wxuser.getId().length()>0){
			sql.append(" and id = :id");
		}
		if(wxuser.getWxId()!=null&&wxuser.getWxId().length()>0){
			sql.append(" and wxId = :wxId");
		}
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(wxuser wxuser){
		StringBuffer sql = new StringBuffer();
		sql.append("update wxuser ");
		
		sql.append("set id = :id");
		if(wxuser.getWxId()!=null&&wxuser.getWxId().length()>0){
			sql.append(",wxId = :wxId");
		}
		if(wxuser.getNickname()!=null&&wxuser.getNickname().length()>0){
			sql.append(",nickname = :nickname");
		}
		if(wxuser.getPhoto()!=null&&wxuser.getPhoto().length()>0){
			sql.append(",photo = :photo");
		}
		if(wxuser.getSex()!=null){
			sql.append(",sex = :sex");
		}
		if(wxuser.getAge()!=null){
			sql.append(",age = :age");
		}
		if(wxuser.getRegisttime()!=null&&wxuser.getRegisttime().length()>0){
			sql.append(",registtime = :registtime");
		}
		if(wxuser.getWxuser_address()!=null&&wxuser.getWxuser_address().length()>0){
			sql.append(",wxuser_address = :wxuser_address");
		}
		if(wxuser.getSignature()!=null&&wxuser.getSignature().length()>0){
			sql.append(",signature = :signature");
		}
		if(wxuser.getTel()!=null&&wxuser.getTel().length()>0){
			sql.append(",tel = :tel");
		}
		if(wxuser.getCreatetime()!=null&&wxuser.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(wxuser.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		sql.append(" where id = :id");
		
		return sql.toString();
	}

}
