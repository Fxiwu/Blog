package com.yc.SpringBootPfstblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.SpringBootPfstblog.bean.Comment;

public interface CommentMapper {

	@Insert("insert into comment values(null,#{articleid},"
			+ "#{content},#{createby},now())")
	public int insert(Comment comm);
	
	@Select("select * from comment where articleid=#{articleid}")
	public List<Comment> selectByArticleId(int id);
	
	
}
