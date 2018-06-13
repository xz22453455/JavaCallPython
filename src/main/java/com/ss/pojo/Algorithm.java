package com.ss.pojo;

public class Algorithm {
	// id
	private Integer id;
	// 算法
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
