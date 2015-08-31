package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * 帮会游戏
 * @author 张宏
 *
 */
public class gang_game extends BaseModel implements Serializable{

	private Integer id;//
	private String name;//游戏名
	private String icon;//头像
	private String content;//说明
	private Float price;//价格
	private String state;//状态 “buy”:购买 "change":兑换
	private String url;//游戏地址

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into gang_game ");
		sql.append("(id, name, icon, content, price, state, url) ");
		sql.append("values ");
		sql.append("(:id, :name, :icon, :content, :price, :state, :url) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang_game ");
		sql.append("where id = :id ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(gang_game gangGame){
		StringBuffer sql = new StringBuffer();
		sql.append("select * ");
		sql.append("from gang_game where 1 = 1 ");
		
		if(gangGame.getId()!=null){
			sql.append("and id = :id ");
		}
        if(gangGame.getName()!=null){
            gangGame.setName("%" + gangGame.getName() + "%");
            sql.append("and name like :name ");
        }
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(gang_game gangGame){
		StringBuffer sql = new StringBuffer();
		sql.append("update gang_game ");
		
		sql.append("set id = :id");
		if(gangGame.getName()!=null&&gangGame.getName().length()>0){
			sql.append(",name = :name");
		}
		if(gangGame.getIcon()!=null&&gangGame.getIcon().length()>0){
			sql.append(",icon = :icon");
		}
		if(gangGame.getContent()!=null&&gangGame.getContent().length()>0){
			sql.append(",content = :content");
		}
		if(gangGame.getPrice()!=null){
			sql.append(",price = :price");
		}
		if(gangGame.getState()!=null&&gangGame.getState().length()>0){
			sql.append(",state = :state");
		}
		if(gangGame.getUrl()!=null&&gangGame.getUrl().length()>0){
			sql.append(",url = :url");
		}
		
		sql.append(" where id = :id ");
		
		return sql.toString();
	}

}
