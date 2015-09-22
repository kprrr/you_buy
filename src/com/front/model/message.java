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
	private String receiver_id;//
	private String content;//
	private Integer issystem;//
	private String createtime;//
	private Integer isdelete;//

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
	public Integer getIssystem() {
		return issystem;
	}
	public void setIssystem(Integer issystem) {
		this.issystem = issystem;
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
		sql.append("(id, sender_id, receiver_id, content, issystem, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :sender_id, :receiver_id, :content, :issystem, :createtime, :isdelete) ");
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
		sql.append("select id, sender_id, receiver_id, content, issystem, createtime, isdelete ");
		sql.append("from message where 1 = 1 ");
		
		
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
		if(message.getIssystem()!=null){
			sql.append(",issystem = :issystem");
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
