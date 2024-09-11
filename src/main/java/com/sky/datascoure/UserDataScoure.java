package com.sky.datascoure;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sky.pojo.User;

public class UserDataScoure {
	
	private static List<User> users;
	private static Logger logger = LoggerFactory.getLogger(UserDataScoure.class);
	static {
		users = new ArrayList<User>();
		User u1 = new User();
		u1.setPassword("123456");
		users.add(u1);
		User u2 = new User();
		u2.setPassword("123456");
		users.add(u2);
		User u3 = new User();
		u3.setPassword("123456");
		users.add(u3);
	}
	
	public static List<User> getUsers() {
		return users;
	}
	
	public static User getUserById(Integer userId) {
		for(int i=0;i<users.size();i++) {
			User user = users.get(i);
			logger.info("userId:{},target userId:{}",user.getUserId(),userId);
			if(user.getUserId().equals(userId)) {
				logger.info("last user:{}",user);
				return user;
			}
		}
		return null;
	}
	
}
