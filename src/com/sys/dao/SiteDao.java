package com.sys.dao;

import java.util.List;

import com.sys.model.site;

public abstract interface SiteDao {

    List<site> getSites(site site);

    String addSite(site site);

    String deleteSite(site site);

    String updateSite(site site);
}