package com.yc.SpringBootPfstblog.dao;

import org.apache.ibatis.annotations.Select;

import com.yc.SpringBootPfstblog.bean.Category;

public interface CategoryMapper {

	@Select("select * from Category where id=#{id}")
	public Category selectById(int id);
	
}
