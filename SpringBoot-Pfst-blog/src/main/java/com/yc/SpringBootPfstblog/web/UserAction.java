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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.el.parser.AstMapData;
import com.yc.SpringBootPfstblog.bean.Result;
import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.biz.BizException;
import com.yc.SpringBootPfstblog.biz.UserBiz;
import com.yc.SpringBootPfstblog.util.Utils;

import jdk.jfr.BooleanFlag;

@Controller
public class UserAction {
	
	@Resource
	private UserBiz ubiz;
	
	//注册  表单提交,页面跳转
	@PostMapping("reg.do")
	  public String regist(@Valid User user,Errors errors ,Model m) {
		  
		if(errors.hasErrors()) {
			m.addAttribute("errors", Utils.asMap(errors));
			m.addAttribute("user",user);
			return "reg";
		}
		  try {
			ubiz.register(user);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errors.rejectValue("account","account", e.getMessage());
			m.addAttribute("errors", Utils.asMap(errors));
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
	 


	//登录  Ajax实现 ，使用vue
		 @PostMapping("login.do")
			// 是在 Controller 使用 ==> 方法返回视图名 
			// @ResponseBody 表示该方法的返回值是json数据
			@ResponseBody
			public Result login(@Valid User user, Errors errors, HttpSession session) {
				try {
					if (errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
						// 将错误结果转换成 Map集合再返回
						Result res = new Result(0, "验证错误!", Utils.asMap(errors));
						return res;
					}
					User dbuser = ubiz.login(user);
					session.setAttribute("loginedUser", dbuser);
			 
					return new Result(1, "登录成功!", dbuser);
				} catch (BizException e) {
					e.printStackTrace();
					return new Result(e.getMessage());
				}
			}
 
		}


 