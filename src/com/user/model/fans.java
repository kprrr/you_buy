package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * fans
 * 
 * @author 张宏
 * 
 */
public class fans extends BaseModel implements Serializable {

	private Integer id;//
	private Integer uid;// 用户id
	private String u_name;//
	private String u_password;//
	private String u_male;//
	private String u_age;//
	private String u_mobile;//
	private String u_score;//
	private String u_icon;//
	private String u_addtime;//

	private Integer fan;// 粉丝用户id

	private String fan_name;//
	private String fan_password;//
	private String fan_male;//
	private String fan_age;//
	private String fan_mobile;//
	private Float fan_score;//
	private String fan_icon;//
	private String fan_addtime;//

	private Integer type;// 类型 1一级粉丝 2二级粉丝

	// 生成查询语句
	public String sqlSelect(fans fans) {
		StringBuffer sql = new StringBuffer();
		sql.append("select fs.id, fs.uid, fs.fan ");
		sql.append(",u.name as u_name, u.icon as u_icon ");
		sql
				.append(",fan.name as fan_name,fan.icon as fan_icon ,fan.male as fan_male ,fan.age as fan_age,"
						+ "fan.mobile as fan_mobile, fan.score as fan_score ");
		sql.append("from fans fs ");
		sql.append("left join user u on fs.uid = u.id ");
		sql.append("left join user fan on fs.fan = fan.id ");
		sql.append(" where 1 = 1 ");

		if(fans.getType()!=null&&fans.getType()==2){//二级粉丝
			if (fans.getUid() != null) {
			
				sql.append("and fs.uid in (select fan f from fans f where f.uid = :uid ) ");
			
			}
		}else{
			
			if (fans.getUid() != null) {
				sql.append("and fs.uid = :uid ");
			}
		}
		
		if (fans.getId() != null) {
			sql.append("and fs.id = :id ");
		}
		
		

		
		return sql.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getFan() {
		return fan;
	}

	public void setFan(Integer fan) {
		this.fan = fan;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String uName) {
		u_name = uName;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String uPassword) {
		u_password = uPassword;
	}

	public String getU_male() {
		return u_male;
	}

	public void setU_male(String uMale) {
		u_male = uMale;
	}

	public String getU_age() {
		return u_age;
	}

	public void setU_age(String uAge) {
		u_age = uAge;
	}

	public String getU_mobile() {
		return u_mobile;
	}

	public void setU_mobile(String uMobile) {
		u_mobile = uMobile;
	}

	public String getU_score() {
		return u_score;
	}

	public void setU_score(String uScore) {
		u_score = uScore;
	}

	public String getU_icon() {
		return u_icon;
	}

	public void setU_icon(String uIcon) {
		u_icon = uIcon;
	}

	public String getU_addtime() {
		return u_addtime;
	}

	public void setU_addtime(String uAddtime) {
		u_addtime = uAddtime;
	}

	public String getFan_name() {
		return fan_name;
	}

	public void setFan_name(String fanName) {
		fan_name = fanName;
	}

	public String getFan_password() {
		return fan_password;
	}

	public void setFan_password(String fanPassword) {
		fan_password = fanPassword;
	}

	public String getFan_male() {
		return fan_male;
	}

	public void setFan_male(String fanMale) {
		fan_male = fanMale;
	}

	public String getFan_age() {
		return fan_age;
	}

	public void setFan_age(String fanAge) {
		fan_age = fanAge;
	}

	public String getFan_mobile() {
		return fan_mobile;
	}

	public void setFan_mobile(String fanMobile) {
		fan_mobile = fanMobile;
	}

	public Float getFan_score() {
		return fan_score;
	}

	public void setFan_score(Float fanScore) {
		fan_score = fanScore;
	}

	public String getFan_icon() {
		return fan_icon;
	}

	public void setFan_icon(String fanIcon) {
		fan_icon = fanIcon;
	}

	public String getFan_addtime() {
		return fan_addtime;
	}

	public void setFan_addtime(String fanAddtime) {
		fan_addtime = fanAddtime;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into fans ");
		sql.append("(id, uid, fan) ");
		sql.append("values ");
		sql.append("(:id, :uid, :fan) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from fans ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(fans fans) {
		StringBuffer sql = new StringBuffer();
		sql.append("update fans ");

		sql.append("set id = :id");
		if (fans.getUid() != null) {
			sql.append(",uid = :uid");
		}
		if (fans.getFan() != null) {
			sql.append(",fan = :fan");
		}

		sql.append(" where id = :id ");

		return sql.toString();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
