package com.yc.SpringBootPfstblog.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yc.SpringBootPfstblog.bean.Article;
import com.yc.SpringBootPfstblog.bean.Category;
import com.yc.SpringBootPfstblog.dao.CategoryMapper;

@Service
public class CategoryBiz {
    
	@Resource
	private CategoryMapper cmapper;
	
	public List<Article> catelist(@Param("categoryid") int categoryid){
		return cmapper.selectByCId(categoryid);
		
	}
	
}
