package com.sys.dao;

import java.util.List;

import com.sys.model.site;

public interface SiteDao {

    public List<site> getSites(site site);

    public String addSite(site site);

    public String deleteSite(site site);

    public String updateSite(site site);
}