package com.user.dao;

import com.base.PageList;
import com.user.model.gang_arti_ship;

public interface GangArtiShipDao {
	
	/**
	 * 获取gang_arti_ship列表
	 * @param gang_arti_ship
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getGangArtiShip(gang_arti_ship gangArtiShip,String pageSize,String pageNo);
	
	/**
	 * 添加gang_arti_ship
	 * @param gang_arti_ship
	 * @return
	 */
	public String addGangArtiShip(gang_arti_ship gangArtiShip);
	
	/**
	 * 修改gang_arti_ship
	 * @param gang_arti_ship
	 * @return
	 */
	public String updateGangArtiShip(gang_arti_ship gangArtiShip);
	
	/**
	 * 删除gang_arti_ship
	 * @param gang_arti_ship
	 * @return
	 */
	public String deleteGangArtiShip(gang_arti_ship gangArtiShip);
	
}
