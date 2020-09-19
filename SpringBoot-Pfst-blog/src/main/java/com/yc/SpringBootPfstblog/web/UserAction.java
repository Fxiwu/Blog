package com.yc.SpringBootPfstblog.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sun.el.parser.AstMapData;
import com.yc.SpringBootPfstblog.bean.Result;
import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.biz.BizException;
import com.yc.SpringBootPfstblog.biz.UserBiz;

@Controller
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	
	//注册  表单提交,页面跳转
	@PostMapping("reg.do")
	  public String regist(@Valid User user,Errors errors ,Model m) {
		  
		if(errors.hasErrors()) {
			m.addAttribute("errors", asMap(errors));
			m.addAttribute("user",user);
			return "reg";
		}
		  try {
			ubiz.register(user);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errors.rejectValue("account","account", e.getMessage());
			m.addAttribute("errors",asMap(errors));
			m.addAttribute("user",user);
		  return "reg";
		}
		  //index 请求转发跳转到index没有数据
		  //响应重定向方式跳转
		  return "redirect:/";
	  }
	
	//index页面中我要注册链接
		 @GetMapping("toreg")
		 public String toreg() {
			 return "reg";
		 }
	  //将所有的字段验证写入到一个map
	private Map<String,String> asMap(Errors errors) {
		 if(errors.hasErrors()) {
			 Map<String,String> ret=new HashMap<String,String> ();
             for(FieldError fe : errors.getFieldErrors()) {
            	 ret.put(fe.getField(),fe.getDefaultMessage());
             }
            return ret;
		 }else {
			 return null;
		 }
		
	}


	//登录  Ajax实现 ，使用vue
	@GetMapping("login.do")
	  public Result login(User user,HttpSession session) {
		  try {
	        
			User dbuser=ubiz.login(user);
			session.setAttribute("LoginUser",dbuser);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(e.getMessage());
		}
		  
		  return new Result(1,"登录成功");
	  }

	 
}
