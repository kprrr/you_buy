package com.sys.dao.imp;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.JdbcDao;
import com.sys.dao.SiteDao;
import com.sys.model.site;

@Component("sitesDao")
@Scope("prototype")
public class SitesDaoImp extends JdbcDao implements SiteDao {
    public List<site> getSites(site site) {
        String sql = "select * from sites where 1=1 ";
        return selectSql(sql, site);
    }

    public String addSite(site site) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        String id = createKey();
        site.setId(id);
        site.setIsdetele(1);
        if (!this.executeSql(site, site.sqlInsert())) {
            mess = this.codeMess(eCode, "添加失败!");
        }
        return mess;
    }

    public String deleteSite(site site) {
        // TODO Auto-generated method stub

        String mess = this.codeMess(sCode, sMess);

        this.executeSql(site,site.sqlDelete());
        return mess;
    }

    public String updateSite(site site) {
        // TODO Auto-generated method stub
        String mess = this.codeMess(sCode, sMess);
        if (!this.executeSql(site, site.sqlUpdate(site))) {
            mess = this.codeMess(eCode, "修改失败!");
        }
        return mess;
    }
}