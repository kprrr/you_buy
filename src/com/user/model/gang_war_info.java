package com.user.model;

import java.io.Serializable;
import com.base.BaseModel;

/**
 * gang_war_info
 * @author 张宏
 *
 */
public class gang_war_info extends BaseModel implements Serializable{

	private Integer id;//
	private String name;//
	private String icon;//
	private String start_time;//开始时间
	private String end_time;//结束时间
	private Integer interval;//周期， 每两次帮战间隔时间，单位分钟
	private Integer isOn;//是否开启，1开启，0未开启

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
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getInterval() {
		return interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public Integer getIsOn() {
		return isOn;
	}
	public void setIsOn(Integer isOn) {
		this.isOn = isOn;
	}
	
	//生成添加语句
	public String sqlInsert(){
		StringBuffer sql = new StringBuffer();
		sql.append("insert into gang_war_info ");
		sql.append("(`name`, icon, start_time, end_time, `interval`, isOn) ");
		sql.append("values ");
		sql.append("(:name, :icon, :start_time, :end_time, :interval, :isOn) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from gang_war_info ");
		sql.append("where id = :id ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(gang_war_info gangWarInfo){
		StringBuffer sql = new StringBuffer();
		sql.append("select g.* ");
		sql.append("from gang_war_info g where 1 = 1 ");
		
		if(gangWarInfo.getId()!=null){
			sql.append("and id = :id ");
		}
        if(gangWarInfo.getName()!=null&&gangWarInfo.getName().length()>0){
            gangWarInfo.setName("%"+ gangWarInfo.getName() +"%");
            sql.append("and name like :name ");
        }
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(gang_war_info gangWarInfo){
		StringBuffer sql = new StringBuffer();
		sql.append("update gang_war_info ");
		
		sql.append("set id = :id");
		if(gangWarInfo.getName()!=null&&gangWarInfo.getName().length()>0){
			sql.append(",`name` = :name");
		}
		if(gangWarInfo.getIcon()!=null&&gangWarInfo.getIcon().length()>0){
			sql.append(",icon = :icon");
		}
		if(gangWarInfo.getStart_time()!=null&&gangWarInfo.getStart_time().length()>0){
			sql.append(",start_time = :start_time");
		}
		if(gangWarInfo.getEnd_time()!=null&&gangWarInfo.getEnd_time().length()>0){
			sql.append(",end_time = :end_time");
		}
		if(gangWarInfo.getInterval()!=null){
			sql.append(",`interval` = :interval");
		}
		if(gangWarInfo.getIsOn()!=null){
			sql.append(",isOn = :isOn");
		}
		
		sql.append(" where id = :id ");
		
		return sql.toString();
	}

}
