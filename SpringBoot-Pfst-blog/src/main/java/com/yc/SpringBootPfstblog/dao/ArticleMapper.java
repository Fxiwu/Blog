package com.yc.SpringBootPfstblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.One;

import com.yc.SpringBootPfstblog.bean.Article;

public interface ArticleMapper {
 
	//查询所有文章
	@Select("select * from article order by createtime desc")
	@Results(id="rmAm",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="categoryid",property="categoryid"),
			@Result(column="categoryid",property="category",
			        one=@One(select="com.yc.SpringBootPfstblog.dao.CategoryMapper.selectById"))
	})
		public List<Article> selectByNew();
	
	
	//查询热门文章
		@Select("select * from article order by readCnt desc limit  5")
	 public List<Article> selectByHot();
		
		
	//查询文章详情
	@Select("select * from article where id=#{id}")
	@ResultMap("rmAm")
	public  Article  selectById(int id);
	
	//新增文章
	@Insert("insert into article values(#{id},#{author},#{title},#{content},"
			+ "#{keywords},#{description},#{categoryid},#{label},#{titleimgs}, "
			+ "#{status},now(),#{readcnt},#{agreecnt})")
	@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
	public int addArticle(Article article);
		
	//关键字搜索
	@Select("select * from article where title like concat('%',#{title},'%')")
	@ResultMap("rmAm")
	public List<Article> selectByKey(@Param(value = "title")  String title);
}
