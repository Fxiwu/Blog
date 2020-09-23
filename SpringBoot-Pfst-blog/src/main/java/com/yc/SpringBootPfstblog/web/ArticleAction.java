package com.yc.SpringBootPfstblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yc.SpringBootPfstblog.bean.Article;
import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.biz.ArticleBiz;
import com.yc.SpringBootPfstblog.dao.ArticleMapper;
import com.yc.SpringBootPfstblog.util.Utils;
@RestController//@RestController下使用ModelAddView 返回跳转页面
public class ArticleAction {
    
	@Resource
	private ArticleBiz abiz;
	@Resource
	private ArticleMapper amapper;
	
	@GetMapping("article")
	public ModelAndView article(int id,ModelAndView mav) {
		 
		mav.addObject("article", amapper.selectById(id));
		mav.setViewName("article");
		return mav;
	}	
	
   @GetMapping("toAddArticle")
 	public ModelAndView toAddArticle(ModelAndView mav) {
		mav.setViewName("addArticle");
	   return mav;
	}
   
   @PostMapping("addArticle.do")
	public ModelAndView addArticle(@Valid Article article,
			Errors errors,ModelAndView mav,@SessionAttribute("loginedUser") User user) {
		   if(errors.hasErrors()) { 
			mav.addObject("errors",Utils.asMap(errors));
			mav.addObject("article", article);
			System.out.println("========================");
			System.out.println(Utils.asMap(errors));
			 mav.setViewName("addArticle");
			 //界面展现错误未写
			 
		}else {
			 article.setAuthor(user.getName());
			 abiz.addArticle(article);
			 mav.setViewName("redirect:article?id="+article.getId());//通过响应重定向来传参
		}
	   return mav;
	}
}
