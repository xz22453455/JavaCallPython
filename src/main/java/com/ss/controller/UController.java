package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.pojo.Algorithm;
import com.ss.service.AlgorithmService;

@RestController
public class UController {
	@Autowired
	AlgorithmService algorithmService;

	@RequestMapping("/hello")
	@ResponseBody
	public Algorithm selectByPrimaryKey(@RequestParam("id") Integer id) {
		return algorithmService.getByPrimaryKey(id);

	}

}
