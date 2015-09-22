package com.front.dao;

import java.util.List;

import com.front.model.activity;

public interface WxuserDao {
	public List<activity> getActivitys(activity activity);

    public String addActivity(activity activity);

    public String deleteActivity(activity activity);

    public String updateActivity(activity activity);
}
