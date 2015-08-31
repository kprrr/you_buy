package com.sys.dao.imp;

import com.base.JdbcDao;
import com.base.PageList;
import com.sys.dao.ServerDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接口实现
 * 
 * @author 张宏 on 14-8-8
 */
@Component("serverDao")
@Scope("prototype")
public class ServerDaoImp extends JdbcDao implements ServerDao {

	public Object executeSql(ServerDao.ServerModel model, sqlType type) {
		Object reuslt = null;
		switch (type) {
		case select: // 查询语句
			PageList pl = new PageList();
			String sql = model.sqlSelect(model);
			int counts = this.getCount(sql, model);
			pl.setTotal(counts);
			List<ServerModel> list;
			if (model.getRows() != null && model.getPage() != null) {
				list = this.selectSql(sql, model, model.getRows().toString(),
						model.getPage().toString());
				int pageCount = this.getPageCount(counts, model.getRows()
						.toString());
				pl.setPageCount(pageCount);
			} else {
				list = this.selectSql(sql, model);
			}
			pl.setRows(list);
			pl.setRemoves(model.getRemoveItem());
			reuslt = pl;
			break;
		case insert:
			reuslt = codeMess(eCode, "插入失败!");
			if (this.executeSql(model, model.sqlInsert())) {
				reuslt = this.codeMess(sCode, sMess);
			}
			break;
		case update:
			reuslt = codeMess(eCode, "修改失败!");
			if (this.executeSql(model, model.sqlUpdate(model))) {
				reuslt = this.codeMess(sCode, sMess);
			}
			break;
		case delete:
			reuslt = codeMess(eCode, "删除失败!");
			if (this.executeSql(model, model.sqlDelete())) {
				reuslt = this.codeMess(sCode, sMess);
			}
			break;
		}
		return reuslt;
	}

}
