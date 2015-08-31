package com.user.dao;

import com.base.PageList;
import com.user.model.gang_war_info;

public interface GangWarInfoDao {
	
	/**
	 * 获取gang_war_info列表
	 * @param gang_war_info
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangWarInfo(gang_war_info gangWarInfo,String pageSize,String pageNo);
	
	/**
	 * 添加gang_war_info
	 * @param gang_war_info
	 * @return
	 */
	public String addGangWarInfo(gang_war_info gangWarInfo);
	
	/**
	 * 修改gang_war_info
	 * @param gang_war_info
	 * @return
	 */
	public String updateGangWarInfo(gang_war_info gangWarInfo);
	
	/**
	 * 删除gang_war_info
	 * @param gang_war_info
	 * @return
	 */
	public String deleteGangWarInfo(gang_war_info gangWarInfo);
	
}
