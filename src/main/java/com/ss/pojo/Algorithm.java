package com.ss.pojo;

/*
* @Description:    算法pojo
* @Author:         wangcm
* @CreateDate:     2018\6\16 0016 15:53
* @UpdateUser:     wangcm
* @UpdateDate:     2018\6\16 0016 15:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Algorithm {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 算法
	 */
	private String algorithm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setFormula(String formula) {
		this.algorithm = formula;
	}

	@Override
	public String toString() {
		return "Formulas_m [id=" + id + ", formula=" + algorithm + "]";
	}
	

}
