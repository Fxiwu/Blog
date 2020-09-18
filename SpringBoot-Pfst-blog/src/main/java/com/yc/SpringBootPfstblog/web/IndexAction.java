package com.yc.SpringBootPfstblog.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.yc.SpringBootPfstblog.dao.ArticleMapper;

@Controller
public class IndexAction {
	
	 
	@Resource
	private ArticleMapper amapper;

	@GetMapping("/")
	public String index(Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 5);
		m.addAttribute("alist", amapper.selectByNew());
	 
		return "index";
	}
	 
	
}
