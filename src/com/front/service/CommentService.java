package com.front.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.BaseService;
import com.base.Constant;
import com.base.JdbcDao;
import com.base.PageList;
import com.base.ServiceDao;
import com.front.dao.CommentsDao;
import com.front.model.activity;
import com.front.model.collects;
import com.front.model.comments;
import com.front.model.signup;
import com.front.model.wxuser;
import com.sys.model.site;
import com.util.Distance;
import com.util.TimeUtil;

import freemarker.core.Comment;

public class CommentService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;

	public String addComment(comments comment, wxuser wxuser) {
		// TODO Auto-generated method stub
		comment.setId(JdbcDao.createKey());
		comment.setIsdelete(1);
		if(comment.getIsreply() == comments.IS_REPLY) {
			comment.setCommentator_id(wxuser.getId());
			comment.setCommentator_name(wxuser.getNickname());
			comment.setCommentator_photo(wxuser.getPhoto());
			
		}else if(comment.getIsreply() == comments.IS_NOT_REPLY){
			comment.setCommentator_id(wxuser.getId());
			comment.setCommentator_name(wxuser.getNickname());
			comment.setCommentator_photo(wxuser.getPhoto());
			
		}
		String mess = "";
		try {
			mess = serviceDao.addObject(comment, sqlInsertName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mess;
	}

	public List<comments> queryComments(comments comment, wxuser wxuser) {
		// TODO Auto-generated method stub
		List<comments> list = serviceDao.getList(comment, comment.sqlSelect(comment));
		return list;
	}
	
}
