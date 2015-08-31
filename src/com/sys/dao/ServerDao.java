package com.sys.dao;

import com.base.JdbcDao;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用数据处理接口
 * 
 * @author 张宏 on 14-8-8
 */
public interface ServerDao {

	/**
	 * 操作类型
	 * 
	 * @author 张宏 on 14-8-8
	 */
	public enum sqlType {
		insert, select, delete, update
	}

	/**
	 * model基类
	 * 
	 * @author 张宏 on 14-8-8
	 */
	public abstract class ServerModel {

		private Integer isdelete;
		private String createtime;
		private String createuser;

		private Integer rows; // 每页显示个数

		private Integer page; // 页数

		private List<String> removeItem = new ArrayList<String>();

		public ServerModel() {
			removeItem.add("rows");
			removeItem.add("page");
			removeItem.add("removeItem");
		}

		public Integer getIsdelete() {
			return isdelete;
		}

		public void setIsdelete(Integer isdelete) {
			this.isdelete = isdelete;
		}

		public String getCreatetime() {
			return createtime;
		}

		public void setCreatetime(String createtime) {
			this.createtime = createtime;
		}

		public String getCreateuser() {
			return createuser;
		}

		public void setCreateuser(String createuser) {
			this.createuser = createuser;
		}

		public List<String> getRemoveItem() {
			return removeItem;
		}

		public void setRemoveItem(List<String> removeItem) {
			this.removeItem = removeItem;
		}

		public Integer getRows() {
			return rows;
		}

		public void setRows(Integer rows) {
			this.rows = rows;
		}

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public boolean isNull(String str) {
			return str != null && str.length() > 0;
		}

		public boolean isNull(Integer str) {
			return str != null;
		}

		public boolean isNull(Float str) {
			return str != null;
		}

		/**
		 * 查询接口
		 * 
		 * @return
		 */
		public String sqlSelect(ServerModel model) {
			return null;
		}

		;

		/**
		 * 添加接口
		 * 
		 * @return
		 */
		public String sqlInsert() {
			return null;
		}

		;

		/**
		 * 删除
		 * 
		 * @return
		 */
		public String sqlDelete() {
			return null;
		}

		;

		/**
		 * 修改
		 * 
		 * @return
		 */
		public String sqlUpdate(ServerModel model) {
			return null;
		}

		;
	}

	/**
	 * sql 基本操作
	 * 
	 * @param model
	 * @return
	 */
	public Object executeSql(ServerModel model, sqlType type);

}
