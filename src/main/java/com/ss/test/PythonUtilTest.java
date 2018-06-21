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

/*
 * @Description:    PythonUtilTest
 * @Author:         wangcm
 * @CreateDate:     2018\6\16 0016 15:52
 * @UpdateUser:     wangcm
 * @UpdateDate:     2018\6\16 0016 15:52
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
@RestController
public class PythonUtilTest {
    @Autowired
    AlgorithmService algorithmService;

    @RequestMapping("/ss")
    @ResponseBody
    public String getResule(@RequestParam("id") Integer id) throws Exception {
        /*
         * getResule
         * @author      wangcm
         * @param id
         * @return      java.lang.String
         * @exception
         * @date        2018\6\16 0016 15:52
         */
        Algorithm data = algorithmService.getByPrimaryKey(id);
        String algorithm = data.getAlgorithm();
        List<Map> list = new ArrayList<Map>();
        // 给定参数
        Map<String, String> map = new HashMap<String, String>(5);
        map.put("x", "10");
        map.put("y", "20");
        map.put("z", "30");
        map.put("k", "40");
        map.put("l", "50");
        list.add(map);
        return PythonUtil.getInstance().callPythonScript(algorithm, list);
    }

}