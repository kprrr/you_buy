package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * gang
 * 
 * @author 张宏
 * 
 */
public class gang extends BaseModel implements Serializable {

	private Integer id;//
	private Integer owner;// 帮主id
	private String name;// 帮派名
	private Integer scores;// 帮会积分
	private String icon;// 帮会logo

	private String owner_name;// 帮主名称

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String ownerName) {
		owner_name = ownerName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScores() {
		return scores;
	}

	public void setScores(Integer scores) {
		this.scores = scores;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into gang ");
		sql.append("(id, owner, name, scores, icon) ");
		sql.append("values ");
		sql.append("(:id, :owner, :name, :scores, :icon) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(gang gang) {
		StringBuffer sql = new StringBuffer();
		sql.append("select g.id, g.owner, g.name, g.scores, g.icon ");
		sql.append(",u.name as owner_name ");
		sql.append("from gang g ");
		
		sql.append("left join user u on u.id = g.owner ");
		
		sql.append("where 1 = 1 ");
		
		if (gang.getId() != null) {
			sql.append("and g.id = :id ");
		}
        if(gang.getName()!=null){
            gang.setName("%"+ gang.getName() +"%");
            sql.append("and g.name like :name ");
        }
		if (gang.getOwner() != null) {
			sql.append("and g.owner = :owner ");
		}

		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(gang gang) {
		StringBuffer sql = new StringBuffer();
		sql.append("update gang ");

		sql.append("set id = :id");
		if (gang.getOwner() != null) {
			sql.append(",owner = :owner");
		}
		if (gang.getName() != null && gang.getName().length() > 0) {
			sql.append(",name = :name");
		}
		if (gang.getScores() != null) {
			sql.append(",scores = :scores");
		}
		if (gang.getIcon() != null && gang.getIcon().length() > 0) {
			sql.append(",icon = :icon");
		}

		sql.append(" where id = :id ");

		return sql.toString();
	}

}
