package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.pojo.Algorithm;
import com.ss.service.AlgorithmService;

/*
* @Description:    UserController
* @Author:         wangcm
* @CreateDate:     2018\6\16 0016 15:53
* @UpdateUser:     wangcm
* @UpdateDate:     2018\6\16 0016 15:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@RestController
public class UserController {
	@Autowired
	AlgorithmService algorithmService;
	@RequestMapping("/hello")
	@ResponseBody
	public Algorithm selectByPrimaryKey(@RequestParam("id") Integer id) {
		return algorithmService.getByPrimaryKey(id);

	}

}
