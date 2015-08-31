package com.sys.model;

import java.io.Serializable;

/**
 * region
 * @author lxj
 *
 */
public class region implements Serializable{

	private Integer super_region_id;//
	private Integer region_id;//
	private String region_name;//
	private Integer isdelete;//

	public Integer getSuper_region_id() {
		return super_region_id;
	}
	public void setSuper_region_id(Integer super_region_id) {
		this.super_region_id = super_region_id;
	}
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
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
		sql.append("insert into region ");
		sql.append("(super_region_id, region_id, region_name, isdelete) ");
		sql.append("values ");
		sql.append("(:super_region_id, :region_id, :region_name, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from region ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(region region){
		StringBuffer sql = new StringBuffer();
		sql.append("select super_region_id, region_id, region_name, isdelete ");
		sql.append("from region where 1 = 1 ");
		
		
		return sql.toString();
	}
	
	//生成修改语句
	public String sqlUpdate(region region){
		StringBuffer sql = new StringBuffer();
		sql.append("update region ");
		
		sql.append("set super_region_id = :super_region_id");
		if(region.getRegion_id()!=null){
			sql.append(",region_id = :region_id");
		}
		if(region.getRegion_name()!=null&&region.getRegion_name().length()>0){
			sql.append(",region_name = :region_name");
		}
		if(region.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		
		
		return sql.toString();
	}

}
