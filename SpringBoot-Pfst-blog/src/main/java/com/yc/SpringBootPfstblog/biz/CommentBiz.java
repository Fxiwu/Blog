package com.yc.SpringBootPfstblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.SpringBootPfstblog.bean.Comment;
import com.yc.SpringBootPfstblog.dao.CommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private CommentMapper cmapper;
	
	public Comment create(Comment comm) {
		cmapper.insert(comm);
		return comm;
	}

}
