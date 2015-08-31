package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * 帮会建筑
 * 
 * @author 张宏
 */
public class gang_arti extends BaseModel implements Serializable {

	private Integer id;//
	private String name;// 帮会建筑名
	private String icon;// 建筑logo
	private String content;// 建筑说明
	private Float price;// 价格
	private String state;// 建筑状态

	private String info;// 介绍

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

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

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into gang_arti ");
		sql.append("(id, name, icon, content, price, state , info) ");
		sql.append("values ");
		sql.append("(:id, :name, :icon, :content, :price, :state,:info) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang_arti ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(gang_arti gangArti) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * ");
		sql.append("from gang_arti where 1 = 1 ");

		if (gangArti.getId() != null) {
			sql.append("and id = :id ");
		}
		if (gangArti.getName() != null) {
			gangArti.setName("%" + gangArti.getName() + "%");
			sql.append("and name like :name ");
		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(gang_arti gangArti) {
		StringBuffer sql = new StringBuffer();
		sql.append("update gang_arti ");

		sql.append("set id = :id");
		if (gangArti.getName() != null && gangArti.getName().length() > 0) {
			sql.append(",name = :name");
		}
		if (gangArti.getIcon() != null && gangArti.getIcon().length() > 0) {
			sql.append(",icon = :icon");
		}
		if (gangArti.getContent() != null && gangArti.getContent().length() > 0) {
			sql.append(",content = :content");
		}
		if (gangArti.getPrice() != null) {
			sql.append(",price = :price");
		}
		if (gangArti.getState() != null && gangArti.getState().length() > 0) {
			sql.append(",state = :state");
		}
		if (gangArti.getInfo() != null && gangArti.getInfo().length() > 0) {
			sql.append(",info = :info ");
		}

		sql.append(" where id = :id ");

		return sql.toString();
	}

}
