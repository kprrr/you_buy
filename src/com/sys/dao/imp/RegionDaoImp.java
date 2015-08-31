package com.sys.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.sys.dao.RegionDao;
import com.sys.model.region;



@Component("regionDao")
@Scope("prototype")
public class RegionDaoImp extends JdbcDao implements RegionDao {

	@Override
	public List<region> getRegion(region region) {
		// TODO Auto-generated method stub
		String sql = "select * from sites where 1=1 ";
        return selectSql(region.sqlSelect(region), region);
	}

	@Override
	public String addRegion(region region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateRegion(region region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRegion(region region) {
		// TODO Auto-generated method stub
		return null;
	}

}
