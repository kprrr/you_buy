package com.front.model;

import java.io.Serializable;

/**
 * signup_num
 * @author lxj
 *
 */
public class signup_num implements Serializable{

	private String id;//
	private String activity_id;//
	private Integer 活动人数上限;//
	private Integer limit_num;//
	private String createtime;//
	private Integer isdelete;//

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
	public Integer get活动人数上限() {
		return 活动人数上限;
	}
	public void set活动人数上限(Integer 活动人数上限) {
		this.活动人数上限 = 活动人数上限;
	}
	public Integer getLimit_num() {
		return limit_num;
	}
	public void setLimit_num(Integer limit_num) {
		this.limit_num = limit_num;
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
		sql.append("insert into signup_num ");
		sql.append("(id, activity_id, 活动人数上限, limit_num, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :activity_id, :活动人数上限, :limit_num, :createtime, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from signup_num ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(signup_num signupNum){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, activity_id, 活动人数上限, limit_num, createtime, isdelete ");
		sql.append("from signup_num where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(signup_num signupNum){
		StringBuffer sql = new StringBuffer();
		sql.append("update signup_num ");
		
		sql.append("set id = :id");
		if(signupNum.getActivity_id()!=null&&signupNum.getActivity_id().length()>0){
			sql.append(",activity_id = :activity_id");
		}
		if(signupNum.get活动人数上限()!=null){
			sql.append(",活动人数上限 = :活动人数上限");
		}
		if(signupNum.getLimit_num()!=null){
			sql.append(",limit_num = :limit_num");
		}
		if(signupNum.getCreatetime()!=null&&signupNum.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(signupNum.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		
		
		return sql.toString();
	}

}
