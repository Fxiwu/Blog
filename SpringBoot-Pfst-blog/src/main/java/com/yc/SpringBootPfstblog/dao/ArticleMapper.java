package com.yc.SpringBootPfstblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yc.SpringBootPfstblog.bean.Article;

public interface ArticleMapper {
 
	//查询所有帖子
	@Select("select * from article order by createtime desc")
		public List<Article> selectByNew();
	
	//查询帖子详情
	@Select("select * from article where id=#{id}")
	public  Article  selectById(int id);
	
	//新增帖子
	@Insert("insert into article values(#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs}, "
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	public int addArticle(Article article);
		
	
}
