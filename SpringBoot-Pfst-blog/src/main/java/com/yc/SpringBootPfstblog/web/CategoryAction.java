package com.yc.SpringBootPfstblog.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.SpringBootPfstblog.bean.Category;
import com.yc.SpringBootPfstblog.biz.CategoryBiz;

@RestController
public class CategoryAction {

	@Resource
	private CategoryBiz cbiz;
	
	@GetMapping("category")   //category.html中类别文章
	public ModelAndView clist(int categoryid,ModelAndView m) {
		 
		m.addObject("clist", cbiz.catelist(categoryid)) ;
		m.setViewName("category");
		return m;
	}	
	
}
