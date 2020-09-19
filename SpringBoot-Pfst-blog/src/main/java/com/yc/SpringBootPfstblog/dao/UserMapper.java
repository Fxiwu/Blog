package com.yc.SpringBootPfstblog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.yc.SpringBootPfstblog.bean.User;

public interface UserMapper {
	
	//注册
	@Insert("insert into user values(null,#{name},"
			+ "#{account},#{pwd},#{phone},"
			+ "#{email},#{head},now(),#{status},#{type})")
	public void register(User user);

     //登录
	@Select("select * from user where account=#{account} and pwd=#{pwd}")
	public User login(User user);
	
	//账户同名验证
	@Select("select count(*) from user where account=#{account}")
	public int countByAccount(String account);
	
	
	
}
