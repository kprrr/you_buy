package com.sys.dao;

import java.util.List;

import com.sys.model.region;

public interface RegionDao {
	
	/**
	 * 获取region列表
	 * @param region
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List<region> getRegion(region region);
	
	/**
	 * 添加region
	 * @param region
	 * @return
	 */
	public String addRegion(region region);
	
	/**
	 * 修改region
	 * @param region
	 * @return
	 */
	public String updateRegion(region region);
	
	/**
	 * 删除region
	 * @param region
	 * @return
	 */
	public String deleteRegion(region region);
	
}
