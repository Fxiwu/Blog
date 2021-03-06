package com.yc.SpringBootPfstblog.bean;

import java.sql.Timestamp;

/*
 * 评论
 */
public class Comment implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer id;
	 private Integer articleid;
	 private String content;
	 private Integer createby;
	 private Timestamp createtime;
	 
	 private Article article;//关联文章  一对一管理
	 private User user;//发表人，关联User 一对一管理
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCreateby() {
		return createby;
	}
	public void setCreateby(Integer createby) {
		this.createby = createby;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	 
}
