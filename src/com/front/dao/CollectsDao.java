package com.front.dao;

import java.util.List;

import com.front.model.collects;

public interface CollectsDao {
	public List<collects> getCollects(collects collects);

    public String addCollects(collects collects);

    public String deleteCollects(collects collects);

    public String updateCollects(collects collects);
}
