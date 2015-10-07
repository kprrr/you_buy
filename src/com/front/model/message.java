package com.front.model;

import java.io.Serializable;

/**
 * message
 * @author lxj
 *
 */
public class message implements Serializable{
	
	private String id;//
	private String sender_id;//
	private String sender_nickname;//
	private String sender_photo;
	private Integer sex;
	private String receiver_id;//
	private String receiver_photo;
	private String content;//
	private Integer isread;//是否已读 0-未读 ，1-已读
	private String createtime;//
	private Integer isdelete;//
	
	private String timeFlag;//
	
	
	
	public String getSender_nickname() {
		return sender_nickname;
	}
	public void setSender_nickname(String sender_nickname) {
		this.sender_nickname = sender_nickname;
	}
	public String getTimeFlag() {
		return timeFlag;
	}
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getIsread() {
		return isread;
	}
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSender_photo() {
		return sender_photo;
	}
	public void setSender_photo(String sender_photo) {
		this.sender_photo = sender_photo;
	}
	public String getReceiver_photo() {
		return receiver_photo;
	}
	public void setReceiver_photo(String receiver_photo) {
		this.receiver_photo = receiver_photo;
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
		sql.append("insert into message ");
		sql.append("(id,sender_id,sender_photo,sender_nickname,sex,receiver_id,receiver_photo,isread,content,createtime, isdelete) ");
		sql.append(" values ");
		sql.append(" (:id,:sender_id,:sender_photo,:sender_nickname,:sex,:receiver_id,:receiver_photo,:isread,:content,CURRENT_TIMESTAMP, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from message ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(message message){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, sender_photo,sex,sender_id, sender_nickname,receiver_id, receiver_photo,isread,content, createtime, isdelete ");
		sql.append("from message where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	
	
	public String sqlSelectDistinct(message message) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(sender_id),m.*	from message m	GROUP BY sender_id 	ORDER BY createtime desc");
		return sql.toString();
	}
	
	
	//生成修改语句
	public String sqlUpdate(message message){
		StringBuffer sql = new StringBuffer();
		sql.append("update message ");
		
		sql.append("set id = :id");
		if(message.getSender_id()!=null&&message.getSender_id().length()>0){
			sql.append(",sender_id = :sender_id");
		}
		if(message.getReceiver_id()!=null&&message.getReceiver_id().length()>0){
			sql.append(",receiver_id = :receiver_id");
		}
		if(message.getContent()!=null&&message.getContent().length()>0){
			sql.append(",content = :content");
		}
		if(message.getCreatetime()!=null&&message.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(message.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		
		
		return sql.toString();
	}

}
