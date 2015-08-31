package com.user.dao;

import com.base.PageList;
import com.user.model.banner;

public interface BannerDao {
	
	/**
	 * 获取banner列表
	 * @param banner
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getBanner(banner banner,String pageSize,String pageNo);
	
	/**
	 * 添加banner
	 * @param banner
	 * @return
	 */
	public String addBanner(banner banner);
	
	/**
	 * 修改banner
	 * @param banner
	 * @return
	 */
	public String updateBanner(banner banner);
	
	/**
	 * 删除banner
	 * @param banner
	 * @return
	 */
	public String deleteBanner(banner banner);
	
}
