package com.ss.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.AlgorithmMapper;
import com.ss.pojo.Algorithm;
import com.ss.service.AlgorithmService;

/*
* @Description:    AlgorithmServiceImpl
* @Author:         wangcm
* @CreateDate:     2018\6\16 0016 15:54
* @UpdateUser:     wangcm
* @UpdateDate:     2018\6\16 0016 15:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class AlgorithmServiceImpl implements AlgorithmService {
	@Autowired
	AlgorithmMapper algorithmmapper;

	/**
	* 方法实现说明
	* @author      wangcm
	* @param null
	* @return      
	* @exception   
	* @date        2018\6\16 0016 15:39
	*/
	@Override
	public Algorithm getByPrimaryKey(Integer reportId) {
		return algorithmmapper.getByPrimaryKey(reportId);
	}

}
