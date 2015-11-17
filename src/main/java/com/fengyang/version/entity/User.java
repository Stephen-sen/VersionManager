package com.fengyang.version.entity;

import com.fengyang.base.entity.BaseEntity;

public class User extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String sex;
	private String passWord;
	private String phoneNum;
	private String status;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	
	 * @return status
	
	 */
	public String getStatus() {
		return status;
	}
	/**
	
	 * @param status status
	
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
