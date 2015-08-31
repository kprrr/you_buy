package com.user.dao;

import com.base.PageList;
import com.user.model.gang_arti;

public interface GangArtiDao {
	
	/**
	 * 获取gang_arti列表
	 * @param gang_arti
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangArti(gang_arti gangArti,String pageSize,String pageNo);
	
	/**
	 * 添加gang_arti
	 * @param gang_arti
	 * @return
	 */
	public String addGangArti(gang_arti gangArti);
	
	/**
	 * 修改gang_arti
	 * @param gang_arti
	 * @return
	 */
	public String updateGangArti(gang_arti gangArti);
	
	/**
	 * 删除gang_arti
	 * @param gang_arti
	 * @return
	 */
	public String deleteGangArti(gang_arti gangArti);
	
}
