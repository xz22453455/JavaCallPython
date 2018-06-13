package com.ss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.AlgorithmMapper;
import com.ss.pojo.Algorithm;
import com.ss.service.AlgorithmService;

/**
 * 
 * @ClassName: FormulaService
 * @Description: 查询算法
 * @author wangcm
 * @date 2018年6月8日 上午10:05:25
 */
@Service
public class AlgorithmServiceImpl implements AlgorithmService{
	@Autowired
	AlgorithmMapper algorithmmapper;
	@Override
	public Algorithm getByPrimaryKey(Integer reportId) {
		return algorithmmapper.getByPrimaryKey(reportId);
	}

}
