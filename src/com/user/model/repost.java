package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * repost
 * @author 张宏
 *
 */
public class repost extends BaseModel implements Serializable{

	private Integer id;//
	private Integer postid;//主贴id
	private String title;//
	private Integer author;//
	private String content;//内容
	private String time;//回帖时间

    private String attach_name;//

    public String getAttach_name() {
        return attach_name;
    }

    public void setAttach_name(String attach_name) {
        this.attach_name = attach_name;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into repost ");
		sql.append("(id, postid, title, author, content, time) ");
		sql.append("values ");
		sql.append("(:id, :postid, :title, :author, :content, :time) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from repost ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(repost repost){
		StringBuffer sql = new StringBuffer();
		sql.append("select r.* ");
		sql.append(",u.name as attach_name ");
        sql.append("from repost r ");

        sql.append("left join user u on r.author = u.id ");

        sql.append("where 1 = 1 ");
		if(repost.getId()!=null){
			sql.append("and id = :id ");
		}
		if(repost.getPostid()!=null){
			sql.append("and postid = :postid ");
		}
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(repost repost){
		StringBuffer sql = new StringBuffer();
		sql.append("update repost ");
		
		sql.append("set id = :id");
		if(repost.getPostid()!=null){
			sql.append(",postid = :postid");
		}
		if(repost.getTitle()!=null&&repost.getTitle().length()>0){
			sql.append(",title = :title");
		}
		if(repost.getAuthor()!=null){
			sql.append(",author = :author");
		}
		if(repost.getContent()!=null&&repost.getContent().length()>0){
			sql.append(",content = :content");
		}
		if(repost.getTime()!=null&&repost.getTime().length()>0){
			sql.append(",time = :time");
		}
		
		
		return sql.toString();
	}

}
