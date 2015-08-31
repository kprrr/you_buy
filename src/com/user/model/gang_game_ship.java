package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * 帮会游戏拥有关系
 * 
 * @author 张宏
 * 
 */
public class gang_game_ship extends BaseModel implements Serializable {

	private Integer id;//
	private Integer gangid;//
	private Integer game_id;//

	private String name;// 游戏名
	private String icon;// 头像
	private String content;// 说明
	private Float price;// 价格
	private String state;// 状态 “buy”:购买 "change":兑换
	private String url;// 游戏地址

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

	public Integer getGame_id() {
		return game_id;
	}

	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into gang_game_ship ");
		sql.append("(id, gangid, game_id) ");
		sql.append("values ");
		sql.append("(:id, :gangid, :game_id) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang_game_ship ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(gang_game_ship gangGameShip) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ggs.id, ggs.gangid, ggs.game_id ,gg.* ");
		sql.append("from gang_game_ship ggs ");
		sql.append("left join gang g on ggs.gangid = g.id ");
		sql.append("left join gang_game gg on ggs.game_id = gg.id ");
		
		sql.append("where 1 = 1 ");
		if (gangGameShip.getId() != null) {
			sql.append("and ggs.id = :id ");
		}
		if (gangGameShip.getGangid() != null) {
			sql.append("and ggs.gangid = :gangid ");
		}
		if (gangGameShip.getGame_id() != null) {
			sql.append("and ggs.game_id = :game_id ");
		}
		if(isNotNull(gangGameShip.getName())){
			gangGameShip.setName("%"+ gangGameShip.getName() +"%");
			sql.append("and gg.name like :name ");
		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(gang_game_ship gangGameShip) {
		StringBuffer sql = new StringBuffer();
		sql.append("update gang_game_ship ");

		sql.append("set id = :id");
		if (gangGameShip.getGangid() != null) {
			sql.append(",gangid = :gangid");
		}
		if (gangGameShip.getGame_id() != null) {
			sql.append(",game_id = :game_id");
		}

		return sql.toString();
	}

}
