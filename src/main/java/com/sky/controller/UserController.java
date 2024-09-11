package com.sky.controller;


import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sky.datascoure.UserDataScoure;
import com.sky.pojo.Result;
import com.sky.pojo.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "用户层接口")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/getUsers")
    @Operation(summary = "用户查询")
	public Result getUsers() {
		List<User> uesrsList = UserDataScoure.getUsers();
		logger.info("users:\n{}",uesrsList);
		return Result.success("查询成功", uesrsList);
	}
	
	@GetMapping("/getUsers/{id}")
	@Operation(summary = "根据id查询用户")
	public Result getUserById(@PathVariable Integer id) {
		User user = UserDataScoure.getUserById(id);
		if(Objects.isNull(user))
			return Result.fail("查询失败");
		else {
			return Result.success("查询成功", user);
		}
	}
}
