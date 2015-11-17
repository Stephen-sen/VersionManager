/**  
 * @Title: ConnTest.java
 * @author zhaosen
 * @date 2015年10月27日
 */
package com.fengyang.test;

import org.junit.Test;

import com.fengyang.util.URLConnUtil;

/**
 * ClassName: ConnTest 
 * @Description: TODO
 * @author zhaosen
 * @date 2015年10月27日
 */
public class ConnTest {
	URLConnUtil conn = new URLConnUtil();
	
	@Test
	public void userPageList() throws Exception {
		String urlStr ="/userController/userPageList.do?";
		String jsonStr = conn.postGetRemoteData(urlStr);
		System.out.println(jsonStr);
	}
}
