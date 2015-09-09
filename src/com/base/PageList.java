package com.base;


import java.util.List;
/**
 * 公用实体类
 * @author 张宏
 *
 */
public class PageList {
	
	public int pageCount;				//总页数
	public Integer counts;		
	public Integer pageNum;				//总数
	public List list;					//结果集
	public String[] removes;			//需要剔除的字段
	public int getPageCount() {
		return pageCount;
	}
	
	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String[] getRemoves() {
		return removes;
	}
	public void setRemoves(String[] removes) {
		this.removes = removes;
	}
	
	
}
