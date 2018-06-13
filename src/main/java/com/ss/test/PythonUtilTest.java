package com.ss.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.pojo.Algorithm;
import com.ss.service.AlgorithmService;
import com.ss.utils.PythonUtil;

/**
 * @ClassName: Test1
 * @Description: 测试类
 * @author wangcm
 * @date 2018年6月8日 上午10:00:15
 */
@RestController
public class PythonUtilTest {
	@Autowired
	AlgorithmService algorithmService;

	@RequestMapping("/ss")
	@ResponseBody
	public String getResule(@RequestParam("id") Integer id) throws Exception {
		Algorithm data = algorithmService.getByPrimaryKey(id);
		String algorithm = data.getAlgorithm();
		List<Map> list = new ArrayList<Map>();
		//给定参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("x", "10");
		map.put("y", "20");
		map.put("z", "30");
		map.put("k", "40");
		map.put("l", "50");
		list.add(map);
		return PythonUtil.getInstance().callPythonScript(algorithm, list);
	}

}