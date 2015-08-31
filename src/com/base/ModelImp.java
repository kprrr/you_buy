package com.base;

/**
 * 实体类基类操作接口
 * 
 * @author 张宏
 * 
 */
public interface ModelImp {
	
	/**
	 * 查询sql
	 * @param o
	 * @return
	 */
	public String sqlSelect(ModelImp o);
}
