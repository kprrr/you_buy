package com.sys.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.BaseAction;
import com.base.ServiceDao;
import com.front.model.wxuser;
import com.opensymphony.xwork2.ModelDriven;
import com.sys.dao.RegionDao;
import com.sys.dao.SiteDao;
import com.sys.model.region;
import com.sys.model.site;
import com.util.Distance;

@Component("siteAction")
@Scope("prototype")
public class SiteAction extends BaseAction implements ModelDriven<site> {

    @Autowired
    @Resource
    public SiteDao siteDao;
    
    @Autowired
    @Resource
    public RegionDao regionDao;
    
    @Autowired
	@Resource
	public ServiceDao serviceDao;
    
    
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
    
    
  //site-queryAll
    public void queryAll() {
    	try {
//			PageList pageList = serviceDao.getList(site, sqlSelectName, "10",site.getPageNum()==null?"1":String.valueOf(site.getPageNum()));
//			List<site> list = pageList.getList();
    		wxuser wxuser = (com.front.model.wxuser) session.get("wxuser");
			List<site> list = serviceDao.getList(site, sqlSelectName);
			for(int i=0;i<list.size();i++) {
				site s = list.get(i);
				s.setDistance(Distance.GetDistance(Double.valueOf(wxuser.getWxuser_longitude()), 
						Double.valueOf(wxuser.getWxuser_latitude()),
						Double.valueOf(s.getLongitude()),
						Double.valueOf(s.getLatitude())));
			}
			outJson(list);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public site getModel() {
        return this.site;
    }
}
