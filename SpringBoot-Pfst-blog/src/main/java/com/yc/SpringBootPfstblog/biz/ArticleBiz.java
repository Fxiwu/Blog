package com.yc.SpringBootPfstblog.biz;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.yc.SpringBootPfstblog.bean.Article;
import com.yc.SpringBootPfstblog.dao.ArticleMapper;

@Service
public class ArticleBiz {
	
	@Resource
	private ArticleMapper amapper;
	
	//添加文章
	public int addArticle(Article article) {
		 
		return amapper.addArticle(article);
	}
	
	//显示热门文章
		public List<Article> hotArticle() {
			 
			return amapper.selectByHot();
		}

}
