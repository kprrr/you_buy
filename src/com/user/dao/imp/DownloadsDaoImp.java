package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.DownloadsDao;
import com.user.model.downloads;

@Component("downloadsDao")
@Scope("prototype")
public class DownloadsDaoImp extends JdbcDao implements DownloadsDao{

	public PageList getDownloads(downloads downloads, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = downloads.sqlSelect(downloads);
		int counts = this.getCount(sql, downloads);
		pl.setTotal(counts);
		
		List<downloads> list;
		if(pageSize!=null){
			list = this.selectSql(sql, downloads, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, downloads);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addDownloads(downloads downloads) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(downloads, downloads.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteDownloads(downloads downloads) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(downloads, downloads.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateDownloads(downloads downloads) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(downloads, downloads.sqlUpdate(downloads))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}
