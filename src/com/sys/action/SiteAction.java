package com.sys.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.dao.RegionDao;
import com.sys.dao.SiteDao;
import com.sys.model.region;
import com.sys.model.site;

@Component("siteAction")
@Scope("prototype")
public class SiteAction extends BaseAction implements ModelDriven<site> {

    @Autowired
    @Resource
    public SiteDao siteDao;
    
    @Autowired
    @Resource
    public RegionDao regionDao;
    
    
    site site = new site();

    //site-test
    public void test() {
    	System.out.println("元文兄的第一次:"+getRequest().getParameter("GsonTest"));
    	outJson("success");
    }
    
    
    //site-get
    public void get() {
            List list = this.siteDao.getSites(site);
            outJson(list);
        }

    //site-getSingleSite
    public void getSingleSite() {
    	List list = this.siteDao.getSites(site);
    	if(list != null && list.size() == 1) {
    		outJson(list.get(0));
    	}
    }
    
    //site-add
    public void add() {
            String mess = siteDao.addSite(site);
            this.outJson(mess);
    }

    //site-remove
    public void remove() {
            String mess = siteDao.deleteSite(site);
            this.outJson(mess);
    }

    //site-update
    public void update() {
            String mess = siteDao.updateSite(site);
            this.outJson(mess);
    }

    //site-getRegion
    public void getRegion() {
            List list = this.regionDao.getRegion(new region());
            outJson(list);
        }
    
    
    
    public site getModel() {
        return this.site;
    }
}
