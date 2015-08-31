package com.user.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.base.PageList;
import com.user.dao.BannerDao;
import com.user.model.banner;

@Component("bannerDao")
@Scope("prototype")
public class BannerDaoImp extends JdbcDao implements BannerDao{

	public PageList getBanner(banner banner, String pageSize,
			String pageNo) {
		// TODO Auto-generated method stub
		PageList pl = new PageList();
		String sql = banner.sqlSelect(banner);
		int counts = this.getCount(sql, banner);
		pl.setTotal(counts);
		
		List<banner> list;
		if(pageSize!=null){
			list = this.selectSql(sql, banner, pageSize, pageNo);
			int pageCount = this.getPageCount(counts, pageSize);
			pl.setPageCount(pageCount);
		}else{
			list = this.selectSql(sql, banner);
		}
		pl.setRows(list);
		return pl;
	}
	
	public String addBanner(banner banner) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(banner, banner.sqlInsert())){
			outMess = this.codeMess(eCode, "添加失败!");
		}
		return outMess;
	}

	public String deleteBanner(banner banner) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(banner, banner.sqlDelete())){
			outMess = this.codeMess(eCode, "删除失败!");
		}
		return outMess;
	}

	public String updateBanner(banner banner) {
		// TODO Auto-generated method stub
		String outMess = this.codeMess(sCode, sMess);
		if(!this.executeSql(banner, banner.sqlUpdate(banner))){
			outMess = this.codeMess(eCode, "修改失败!");
		}
		return outMess;
	}

}
