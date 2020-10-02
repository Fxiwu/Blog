package com.yc.SpringBootPfstblog.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.yc.SpringBootPfstblog.bean.Article;
import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.dao.ArticleMapper;
import com.yc.SpringBootPfstblog.util.Utils;

@Controller
 
public class IndexAction {
	
	 
	@Resource
	private ArticleMapper amapper;

	@GetMapping("/")
	public String index(Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 5);
		m.addAttribute("alist", amapper.selectByNew());
	    System.out.println("==============="+amapper.selectByNew());
		return "index";
	}
	 
	 
	//关键字查询
	@PostMapping("index.do")
	public Model indexkey( String title,Model m,@RequestParam(defaultValue = "1")int page  ){
		PageHelper.startPage(page, 5);
		  
		if(title==null||title.isEmpty()) {
			m.addAttribute("alist", amapper.selectByNew());
			 
		}else {
			m.addAttribute("key", 1);
			m.addAttribute("keylist",  amapper.selectByKey(title));
			 
		}
		
	    
		return m;
	}
}
