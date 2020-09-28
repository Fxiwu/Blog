package com.yc.SpringBootPfstblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.SpringBootPfstblog.bean.Comment;
import com.yc.SpringBootPfstblog.bean.Result;
import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.biz.CommentBiz;
import com.yc.SpringBootPfstblog.dao.CommentMapper;


@RestController
public class CommentAction {
 
	 @Resource
	 private CommentMapper cmapper;
	 
	 @Resource
	 private CommentBiz cbiz;
	 
	 @PostMapping("comment")
		public Result comment(Comment comm, @SessionAttribute User loginedUser) {
			comm.setCreateby(loginedUser.getId());
			cbiz.create(comm);
			return new Result(1, "回复成功", comm);
		}
	 
	 @GetMapping("queryComm")
		public Result queryComm(int articleid) {
			return new Result(1, "查询回复成功", cmapper.selectByArticleId(articleid));
		}
	 
}
