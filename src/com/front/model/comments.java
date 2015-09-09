package com.front.model;

import java.io.Serializable;

/**
 * comments
 * @author lxj
 *
 */
public class comments implements Serializable{

	private String id;//
	private String activity_id;//
	private String commentator_id;//
	private String commentator_name;//
	private String commentator_photo;//
	private String content;//
	private Integer isreply;//
	private String recevier_id;//
	private String receiver_name;//
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
	public String getCommentator_id() {
		return commentator_id;
	}
	public void setCommentator_id(String commentator_id) {
		this.commentator_id = commentator_id;
	}
	public String getCommentator_name() {
		return commentator_name;
	}
	public void setCommentator_name(String commentator_name) {
		this.commentator_name = commentator_name;
	}
	public String getCommentator_photo() {
		return commentator_photo;
	}
	public void setCommentator_photo(String commentator_photo) {
		this.commentator_photo = commentator_photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIsreply() {
		return isreply;
	}
	public void setIsreply(Integer isreply) {
		this.isreply = isreply;
	}
	public String getRecevier_id() {
		return recevier_id;
	}
	public void setRecevier_id(String recevier_id) {
		this.recevier_id = recevier_id;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
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
		sql.append("insert into comments ");
		sql.append("(id, activity_id, commentator_id, commentator_name, commentator_photo, content, isreply, recevier_id, receiver_name, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :activity_id, :commentator_id, :commentator_name, :commentator_photo, :content, :isreply, :recevier_id, :receiver_name, :createtime, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from comments ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(comments comments){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, activity_id, commentator_id, commentator_name, commentator_photo, content, isreply, recevier_id, receiver_name, createtime, isdelete ");
		sql.append("from comments where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(comments comments){
		StringBuffer sql = new StringBuffer();
		sql.append("update comments ");
		
		sql.append("set id = :id");
		if(comments.getActivity_id()!=null&&comments.getActivity_id().length()>0){
			sql.append(",activity_id = :activity_id");
		}
		if(comments.getCommentator_id()!=null&&comments.getCommentator_id().length()>0){
			sql.append(",commentator_id = :commentator_id");
		}
		if(comments.getCommentator_name()!=null&&comments.getCommentator_name().length()>0){
			sql.append(",commentator_name = :commentator_name");
		}
		if(comments.getCommentator_photo()!=null&&comments.getCommentator_photo().length()>0){
			sql.append(",commentator_photo = :commentator_photo");
		}
		if(comments.getContent()!=null&&comments.getContent().length()>0){
			sql.append(",content = :content");
		}
		if(comments.getIsreply()!=null){
			sql.append(",isreply = :isreply");
		}
		if(comments.getRecevier_id()!=null&&comments.getRecevier_id().length()>0){
			sql.append(",recevier_id = :recevier_id");
		}
		if(comments.getReceiver_name()!=null&&comments.getReceiver_name().length()>0){
			sql.append(",receiver_name = :receiver_name");
		}
		if(comments.getCreatetime()!=null&&comments.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(comments.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		
		
		return sql.toString();
	}

}
