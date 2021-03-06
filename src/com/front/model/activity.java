package com.front.model;

import java.io.Serializable;

import com.sys.model.site;
import com.test.Person;

/**
 * activity
 * @author lxj
 *
 */
public class activity implements Serializable,Comparable<activity>{
	
	private String id;//
	private Integer activity_type;//
	private Integer isotherpay;
	private String activity_name;//
	private String activity_longitude;//
	private String acitivity_latitude;//
	private String site_city;//
	private String site_name;//
	private String site_address;//
	private String starttime;//
	private Integer lasttime;//
	private String deadline;//
	private Integer limit_num;//
	private Integer signed_num;
	private String create_userid;//
	private Integer activity_status;//活动当前状态 0-未开始 1-进行中 2-已结束
	private Integer shared_times;//
	private String createtime;//
	private Integer isdelete;//
	
	private site site;
	private wxuser wxuser;
	private String wxuserId;
	private String nickname;//
	private String photo;//
	private Integer sex;//
	private String tel;
	private Double distance;
	private String pageNum;
	private int pageSize;
	
	
	@Override
	public int compareTo(activity arg0) {
		return this.getDistance().compareTo(arg0.getDistance());
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Double getDistance() {
		return distance;
	}


	public void setDistance(Double distance) {
		this.distance = distance;
	}


	public String getWxuserId() {
		return wxuserId;
	}
	public void setWxuserId(String wxuserId) {
		this.wxuserId = wxuserId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getIsotherpay() {
		return isotherpay;
	}
	public void setIsotherpay(Integer isotherpay) {
		this.isotherpay = isotherpay;
	}
	
	public String getPageNum() {
		return pageNum;
	}


	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getSigned_num() {
		return signed_num;
	}
	public void setSigned_num(Integer signed_num) {
		this.signed_num = signed_num;
	}
	public wxuser getWxuser() {
		return wxuser;
	}
	public void setWxuser(wxuser wxuser) {
		this.wxuser = wxuser;
	}
	public site getSite() {
		return site;
	}
	public void setSite(site site) {
		this.site = site;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(Integer activity_type) {
		this.activity_type = activity_type;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getActivity_longitude() {
		return activity_longitude;
	}
	public void setActivity_longitude(String activity_longitude) {
		this.activity_longitude = activity_longitude;
	}
	public String getAcitivity_latitude() {
		return acitivity_latitude;
	}
	public void setAcitivity_latitude(String acitivity_latitude) {
		this.acitivity_latitude = acitivity_latitude;
	}
	public String getSite_city() {
		return site_city;
	}
	public void setSite_city(String site_city) {
		this.site_city = site_city;
	}
	public String getSite_name() {
		return site_name;
	}
	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}
	public String getSite_address() {
		return site_address;
	}
	public void setSite_address(String site_address) {
		this.site_address = site_address;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public Integer getLasttime() {
		return lasttime;
	}
	public void setLasttime(Integer lasttime) {
		this.lasttime = lasttime;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Integer getLimit_num() {
		return limit_num;
	}
	public void setLimit_num(Integer limit_num) {
		this.limit_num = limit_num;
	}
	public String getCreate_userid() {
		return create_userid;
	}
	public void setCreate_userid(String create_userid) {
		this.create_userid = create_userid;
	}
	public Integer getActivity_status() {
		return activity_status;
	}
	public void setActivity_status(Integer activity_status) {
		this.activity_status = activity_status;
	}
	public Integer getShared_times() {
		return shared_times;
	}
	public void setShared_times(Integer shared_times) {
		this.shared_times = shared_times;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
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
		sql.append("insert into activity ");
		sql.append("(id, activity_type, activity_name, activity_longitude, acitivity_latitude, site_city, site_name, site_address, starttime, lasttime, deadline, limit_num, create_userid, activity_status, shared_times, createtime, isdelete) ");
		sql.append("values ");
		sql.append("(:id, :activity_type, :activity_name, :activity_longitude, :acitivity_latitude, :site_city, :site_name, :site_address, :starttime, :lasttime, :deadline, :limit_num, :create_userid, :activity_status, :shared_times, CURRENT_TIMESTAMP, :isdelete) ");
		return sql.toString();
	}
	
	//生成删除语句
	public String sqlDelete(){
		StringBuffer sql = new StringBuffer();
		sql.append("delete from activity ");
		return sql.toString();
	}
	
	//生成查询语句
	public String sqlSelect(activity activity){
		StringBuffer sql = new StringBuffer();
		sql.append("select id, activity_type, isotherpay,activity_name, activity_longitude, acitivity_latitude, site_city, site_name, site_address, starttime, lasttime, deadline,signed_num, limit_num, create_userid, activity_status, shared_times, createtime, isdelete ");
		sql.append("from activity where 1 = 1 ");
		
		if(activity.getId()!=null&&activity.getId().length()>0){
			sql.append(" and id = :id");
		}
		return sql.toString();
	}
	
	public String sqlSelectWithWxuser(activity activity) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.*,u.id as wxuserId,u.nickname,u.photo,u.sex from activity a LEFT JOIN wxuser u ON a.create_userid=u.id");
		
		
		return sql.toString();
	}
	
	
	//生成修改语句
	public String sqlUpdate(activity activity){
		StringBuffer sql = new StringBuffer();
		sql.append("update activity ");
		
		sql.append("set id = :id");
		if(activity.getActivity_type()!=null){
			sql.append(",activity_type = :activity_type");
		}
		if(activity.getActivity_name()!=null&&activity.getActivity_name().length()>0){
			sql.append(",activity_name = :activity_name");
		}
		if(activity.getActivity_longitude()!=null&&activity.getActivity_longitude().length()>0){
			sql.append(",activity_longitude = :activity_longitude");
		}
		if(activity.getAcitivity_latitude()!=null&&activity.getAcitivity_latitude().length()>0){
			sql.append(",acitivity_latitude = :acitivity_latitude");
		}
		if(activity.getSite_city()!=null&&activity.getSite_city().length()>0){
			sql.append(",site_city = :site_city");
		}
		if(activity.getSite_name()!=null&&activity.getSite_name().length()>0){
			sql.append(",site_name = :site_name");
		}
		if(activity.getSite_address()!=null&&activity.getSite_address().length()>0){
			sql.append(",site_address = :site_address");
		}
		if(activity.getStarttime()!=null&&activity.getStarttime().length()>0){
			sql.append(",starttime = :starttime");
		}
		if(activity.getLasttime()!=null){
			sql.append(",lasttime = :lasttime");
		}
		if(activity.getSigned_num()!=null){
			sql.append(",signed_num = :signed_num");
		}
		if(activity.getDeadline()!=null&&activity.getDeadline().length()>0){
			sql.append(",deadline = :deadline");
		}
		if(activity.getLimit_num()!=null){
			sql.append(",limit_num = :limit_num");
		}
		if(activity.getCreate_userid()!=null&&activity.getCreate_userid().length()>0){
			sql.append(",create_userid = :create_userid");
		}
		if(activity.getActivity_status()!=null){
			sql.append(",activity_status = :activity_status");
		}
		if(activity.getShared_times()!=null){
			sql.append(",shared_times = :shared_times");
		}
		if(activity.getCreatetime()!=null&&activity.getCreatetime().length()>0){
			sql.append(",createtime = :createtime");
		}
		if(activity.getIsdelete()!=null){
			sql.append(",isdelete = :isdelete");
		}
		sql.append(" where id=:id");
		return sql.toString();
	}
	//生成修改语句
		public String sqlUpdateWithAddShare(activity activity){
			StringBuffer sql = new StringBuffer();
			sql.append("update activity ");
			
			sql.append("set id = :id");
			if(activity.getShared_times()!=null){
				sql.append(",shared_times = :shared_times+1");
			}
			sql.append(" where id = :id");
			return sql.toString();
		}
}
