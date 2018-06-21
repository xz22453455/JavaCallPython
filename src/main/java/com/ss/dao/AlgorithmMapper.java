package com.ss.dao;

import org.apache.ibatis.annotations.Param;

import com.ss.pojo.Algorithm;

/*
* @Description:    AlgorithmMapper
* @Author:         wangcm
* @CreateDate:     2018\6\16 0016 15:53
* @UpdateUser:     wangcm
* @UpdateDate:     2018\6\16 0016 15:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface AlgorithmMapper {
	Algorithm getByPrimaryKey(@Param("id") Integer id);
}
