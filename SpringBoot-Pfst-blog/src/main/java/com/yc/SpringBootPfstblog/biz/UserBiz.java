package com.yc.SpringBootPfstblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.SpringBootPfstblog.bean.User;
import com.yc.SpringBootPfstblog.dao.UserMapper;

@Service
public class UserBiz {
	
	@Resource
	private UserMapper umapper;
	
	//注册
	public void register(User user) throws BizException {
		//同名验证
		if((umapper.countByAccount(user.getAccount()))>0) {
			throw new BizException("该用户已存在");
		}
		umapper.register(user);
	}
	//登录
	public User login(User user) throws BizException {
		User dbuser=umapper.login(user);
		if(dbuser==null) {
			throw new BizException("用户名或密码错误");
		}
		return dbuser;
	}
	
	

}
