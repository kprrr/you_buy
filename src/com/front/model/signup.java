package com.front.model;

import java.io.Serializable;

/**
 * signup
 * @author lxj
 *
 */
public class signup implements Serializable{

	private String id;//
	private String activity_id;//
	private String user_id;//
	private Integer isotherpay;
	private String site_name;//
	private String site_address;//
	private Integer distance;//
	private String activity_starttime;//
	private Integer signup_num;//
	private String createtime;//
	private Integer isdelete;//

	
	
	public Integer getIsotherpay() {
		return isotherpay;
	}
	public void setIsotherpay(Integer isotherpay) {
		this.isotherpay = isotherpay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	public String getSite_address() {
		return site_address;
	}
	public void setSite_address(String site_address) {
		this.site_address = site_address;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	public String getActivity_starttime() {
		return activity_starttime;
	}
	public void setActivity_starttime(String activity_starttime) {
		this.activity_starttime = activity_starttime;
	}
	public Integer getSignup_num() {
		return signup_num;
	}
	public void setSignup_num(Integer signup_num) {
		this.signup_num = signup_num;
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
		sql.append("insert into signup ");
		sql.append("(id, activity_id, user_id,isotherpay, site_name, site_address, distance, activity_starttime, signup_num, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :activity_id, :user_id, :isotherpay,:site_name, :site_address, :distance, :activity_starttime, :signup_num, CURRENT_TIMESTAMP, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from signup ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(signup signup){
		StringBuffer sql = new StringBuffer();
//		sql.append("select id, activity_id, user_id, site_name, site_address, distance, activity_starttime, signup_num, createtime, isdelete ");
//		sql.append("from signup where 1 = 1 ");
		sql.append("SELECT c.*,u.nickname,u.sex,u.photo from signup c,wxuser u where u.id=c.user_id and c.user_id  = :user_id ");
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(signup signup){
		StringBuffer sql = new StringBuffer();
		sql.append("update signup ");
		
		sql.append("set id = :id");
		if(signup.getActivity_id()!=null&&signup.getActivity_id().length()>0){
			sql.append(",activity_id = :activity_id");
		}
		if(signup.getUser_id()!=null&&signup.getUser_id().length()>0){
			sql.append(",user_id = :user_id");
		}
		if(signup.getSite_name()!=null&&signup.getSite_name().length()>0){
			sql.append(",site_name = :site_name");
		}
		if(signup.getSite_address()!=null&&signup.getSite_address().length()>0){
			sql.append(",site_address = :site_address");
		}
		if(signup.getDistance()!=null){
			sql.append(",distance = :distance");
		}
		if(signup.getActivity_starttime()!=null&&signup.getActivity_starttime().length()>0){
			sql.append(",activity_starttime = :activity_starttime");
		}
		if(signup.getSignup_num()!=null){
			sql.append(",signup_num = :signup_num");
		}
		if(signup.getCreatetime()!=null&&signup.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(signup.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		
		
		return sql.toString();
	}

}
