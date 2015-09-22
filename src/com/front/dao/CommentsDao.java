package com.front.dao;

import java.util.List;

import com.front.model.comments;

public interface CommentsDao {
	public List<comments> getList(comments comments);

    public String add(comments comments);

    public String delete(comments comments);

    public String update(comments comments);
}
