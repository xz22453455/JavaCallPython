package com.ss.service;

import com.ss.pojo.Algorithm;

/*
* @Description:    AlgorithmService
* @Author:         wangcm
* @CreateDate:     2018\6\16 0016 15:54
* @UpdateUser:     wangcm
* @UpdateDate:     2018\6\16 0016 15:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface AlgorithmService {
    Algorithm getByPrimaryKey(Integer reportId);
}
