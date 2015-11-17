package com.fengyang.base.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{

	/**
	 * 公用实体类属性
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String creatDate;
	private String updateDate;
	private String flag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	
	 * @return updateDate
	
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	
	 * @param updateDate updateDate
	
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
