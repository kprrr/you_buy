package com.user.dao;

import com.base.PageList;
import com.user.model.downloads;

public interface DownloadsDao {
	
	/**
	 * 获取downloads列表
	 * @param downloads
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageList getDownloads(downloads downloads,String pageSize,String pageNo);
	
	/**
	 * 添加downloads
	 * @param downloads
	 * @return
	 */
	public String addDownloads(downloads downloads);
	
	/**
	 * 修改downloads
	 * @param downloads
	 * @return
	 */
	public String updateDownloads(downloads downloads);
	
	/**
	 * 删除downloads
	 * @param downloads
	 * @return
	 */
	public String deleteDownloads(downloads downloads);
	
}
