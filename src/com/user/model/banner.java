package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * 广告
 * @author 张宏
 *
 */
public class banner extends BaseModel implements Serializable{

	private Integer id;//
	private Integer type;//
	private String titile;//
	private String content;//
	private String pic_url;//
	private String pic_url2;//
	private String info_url;//
	private Integer valid;//是否有效, 1有效 0无效
	private String pos;//广告位位置
	private String timestamp;//

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getPic_url2() {
		return pic_url2;
	}
	public void setPic_url2(String pic_url2) {
		this.pic_url2 = pic_url2;
	}
	public String getInfo_url() {
		return info_url;
	}
	public void setInfo_url(String info_url) {
		this.info_url = info_url;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into banner ");
		sql.append("(id, type, titile, content, pic_url, pic_url2, info_url, valid, pos) ");
		sql.append("values ");
		sql.append("(:id, :type, :titile, :content, :pic_url, :pic_url2, :info_url, :valid, :pos) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from banner ");
		sql.append("where id = :id ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(banner banner){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, type, titile, content, pic_url, pic_url2, info_url, valid, pos, timestamp ");
		sql.append("from banner where 1 = 1 ");
		
		if(isNotNull(banner.getId())){
			sql.append("and id = :id ");
		}
		if(isNotNull(banner.getTitile())){
			banner.setTitile("%"+ banner.getTitile() +"%");
			sql.append("and titile like :titile ");
		}
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(banner banner){
		StringBuffer sql = new StringBuffer();
		sql.append("update banner ");
		
		sql.append("set id = :id");
		if(isNotNull(banner.getType())){
			sql.append(",type = :type");
		}
		if(isNotNull(banner.getTitile())){
			sql.append(",titile = :titile");
		}
		if(isNotNull(banner.getContent())){
			sql.append(",content = :content");
		}
		if(isNotNull(banner.getPic_url())){
			sql.append(",pic_url = :pic_url");
		}
		if(isNotNull(banner.getPic_url2())){
			sql.append(",pic_url2 = :pic_url2");
		}
		if(isNotNull(banner.getInfo_url())){
			sql.append(",info_url = :info_url");
		}
		if(isNotNull(banner.getValid())){
			sql.append(",valid = :valid");
		}
		if(isNotNull(banner.getPos())){
			sql.append(",pos = :pos");
		}
		if(isNotNull(banner.getTimestamp())){
			sql.append(",timestamp = :timestamp");
		}
		
		sql.append(" where id = :id ");
		
		return sql.toString();
	}

}
