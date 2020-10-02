package com.yc.SpringBootPfstblog.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.yc.SpringBootPfstblog.bean.Article;
import com.yc.SpringBootPfstblog.bean.Category;

public interface CategoryMapper {

	//通过id查询
	@Select("select * from category where id=#{id}")
	public Category selectById(int id);
	
	//通过categoryid查询分类
		@Select("select * from article where categoryId=#{categoryid}")
		@Results(id="rmCm",value= {
				 
				@Result(column="categoryid",property="category",
				        one=@One(select="com.yc.SpringBootPfstblog.dao.CategoryMapper.selectById"))
		})
		public List<Article> selectByCId(int categoryid);
	 
}
