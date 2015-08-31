package com.user.model;

import java.io.Serializable;

import com.base.BaseModel;

/**
 * post
 * 
 * @author 张宏
 */
public class post extends BaseModel implements Serializable {

	private Integer id;//
	private String title;// 标题
	private Integer author;//
	private String content;//
	private Integer category;// 分类 默认为2表示默认分类 1表示玩赚攻略秘籍
	private String time;//
	private String attach;//
	private Integer is_top;// 是否置顶

	private String attach_name;// 用户昵称

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attachName) {
		attach_name = attachName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public Integer getIs_top() {
		return is_top;
	}

	public void setIs_top(Integer isTop) {
		is_top = isTop;
	}

	// 生成添加语句
	public String sqlInsert() {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into post ");
		sql.append("(id, title, author, content, category, attach , is_top) ");
		sql.append("values ");
		sql.append("(:id, :title, :author, :content, :category, :attach , 0) ");
		return sql.toString();
	}

	// 生成删除语句
	public String sqlDelete() {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from post ");
		sql.append("where id = :id ");
		return sql.toString();
	}

	// 生成查询语句
	public String sqlSelect(post post) {
		StringBuffer sql = new StringBuffer();
		sql
				.append("select p.id, p.title, p.author, p.content, p.category, p.time, p.attach ");
		sql.append(",u.name as attach_name ");
		sql.append("from post as p ");
		sql.append("left join user u on p.author = u.id ");
		sql.append("where 1 = 1 ");
		if (post.getId() != null) {
			sql.append("and p.id = :id ");
		}
		if (post.getTitle() != null && post.getTitle().length() > 0) {
			post.setTitle("%" + post.getTitle() + "%");
			sql.append("and p.title like :title ");
		}
		if (post.getCategory() != null) {
			sql.append("and category = :category ");
		}
		sql.append(" order by p.is_top desc,lastupdate desc ,p.time desc ");
		return sql.toString();
	}

	// 生成修改语句
	public String sqlUpdate(post post) {
		StringBuffer sql = new StringBuffer();
		sql.append("update post ");

		sql.append("set id = :id");
		if (post.getTitle() != null && post.getTitle().length() > 0) {
			sql.append(",title = :title");
		}
		if (post.getAuthor() != null) {
			sql.append(",author = :author");
		}
		if (post.getContent() != null && post.getContent().length() > 0) {
			sql.append(",content = :content");
		}
		if (post.getCategory() != null) {
			sql.append(",category = :category");
		}
		if (post.getTime() != null && post.getTime().length() > 0) {
			sql.append(",time = :time");
		}
		if (post.getAttach() != null && post.getAttach().length() > 0) {
			sql.append(",attach = :attach");
		}
		if (post.getIs_top() != null) {
			sql.append(",is_top = :is_top ");
			sql.append(",lastupdate = NOW()");
		}
		sql.append(" where id = :id ");

		return sql.toString();
	}

}
