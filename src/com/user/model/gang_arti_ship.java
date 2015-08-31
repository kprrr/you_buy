package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * 帮户建筑关系
 * 
 * @author 张宏
 * 
 */
public class gang_arti_ship extends BaseModel implements Serializable {

	private Integer id;//
	private Integer gangid;//
	private Integer arti_id;// 建筑id

	private String name;// 帮会建筑名
	private String icon;// 建筑logo
	private String content;// 建筑说明
	private Float price;// 价格
	private String state;// 建筑状态

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGangid() {
		return gangid;
	}

	public void setGangid(Integer gangid) {
		this.gangid = gangid;
	}

	public Integer getArti_id() {
		return arti_id;
	}

	public void setArti_id(Integer arti_id) {
		this.arti_id = arti_id;
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
		sql.append("insert into gang_arti_ship ");
		sql.append("(id, gangid, arti_id) ");
		sql.append("values ");
		sql.append("(:id, :gangid, :arti_id) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang_arti_ship ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(gang_arti_ship gangArtiShip) {
		StringBuffer sql = new StringBuffer();
		sql.append("select gas.id, gas.gangid, gas.arti_id ,ga.* ");
		//sql.append("ga.name , ga.icon,ga.content,ga.price,ga.state ");
		sql.append("from gang_arti_ship gas ");
		sql.append("left join gang a on gas.gangid = a.id ");
		sql.append("left join gang_arti ga on gas.arti_id = ga.id ");
		
		sql.append("where 1 = 1 ");

		if (gangArtiShip.getId() != null) {
			sql.append("and gas.id = :id ");
		}
		if (gangArtiShip.getGangid() != null) {
			sql.append("and gas.gangid = :gangid ");
		}
		if (gangArtiShip.getArti_id() != null) {
			sql.append("and gas.arti_id = :arti_id ");
		}
		if(isNotNull(gangArtiShip.getName())){
			sql.append("and ");
		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(gang_arti_ship gangArtiShip) {
		StringBuffer sql = new StringBuffer();
		sql.append("update gang_arti_ship ");

		sql.append("set id = :id");
		if (gangArtiShip.getGangid() != null) {
			sql.append(",gangid = :gangid");
		}
		if (gangArtiShip.getArti_id() != null) {
			sql.append(",arti_id = :arti_id");
		}

		sql.append(" where id = :id ");
		sql.append("and gangid = :gangid ");

		return sql.toString();
	}

}
