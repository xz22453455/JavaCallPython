package com.ss.dao;

import org.apache.ibatis.annotations.Param;

import com.ss.pojo.Algorithm;

/**
 * 
 * @ClassName: FormulaMapper
 * @Description: 查询算法
 * @author wangcm
 * @date 2018年6月8日 上午9:56:46
 */
public interface AlgorithmMapper {
	Algorithm getByPrimaryKey(@Param("id") Integer id);
}
