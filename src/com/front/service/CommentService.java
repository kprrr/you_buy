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
import com.front.model.activity;
import com.front.model.collects;
import com.front.model.signup;
import com.front.model.wxuser;
import com.sys.model.site;
import com.util.Distance;
import com.util.TimeUtil;

public class CommentService extends BaseService{
	
	@Autowired
	@Resource
	public ServiceDao serviceDao;
	
}
