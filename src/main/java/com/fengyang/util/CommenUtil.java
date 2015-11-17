package com.fengyang.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

public class CommenUtil {


	/**
	 * @Description: 非空校验
	 * @param @param list
	 * @param @return   
	 * @return boolean  
	 * @author zhaosen
	 * @date 2015年7月24日
	 */
	public static boolean isEmpty(List<String> list){
		boolean flag = false;
		for (String string : list) {
			if(null == string || "" == string){
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * @Description: 字符串加密
	 * @param @param beginNum
	 * @param @param endNum
	 * @param @param str   
	 * @return void  
	 * @author zhaosen
	 * @date 2015年7月24日
	 */
	public static String characterCovert(int beginNum,int endNum,String str){
		int num=str.length();
		String begin=str.substring(0, beginNum);
		String end=str.substring(num-endNum, str.length());
		StringBuffer buff = new StringBuffer();
		for(int i = 0;i<num-(beginNum+endNum);i++){
			buff.append("*");
		}
		System.out.println(begin+buff.toString()+end);
		String result = begin+buff.toString()+end;
		return result;
	}
	
	/**
	 * @Description: 获取指定长度的随机数字符串
	 * @param @param length
	 * @param @return   
	 * @return String  
	 * @author zhaosen
	 * @date 2015年7月24日
	 */
	public static String getRandomNum(int length){
		StringBuffer buff = new StringBuffer();
		for(int i=0;i<length;i++){
			buff.append((int)(Math.random()*10));
		}
		return buff.toString();
	}
	
	public static String getBankStandName(String bankNameStr){
		String[] array =bankNameStr.split("\\.");
		String bankName = array[0];
		System.out.println(bankName);
		return bankName;
	}
	
	public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }

}
