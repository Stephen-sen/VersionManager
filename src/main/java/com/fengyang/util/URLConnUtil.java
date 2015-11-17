/**  
 * @Title: URLConnUtil.java
 * @author zhaosen
 * @date 2015年7月7日
 */
package com.fengyang.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * ClassName: URLConnUtil 
 * @Description: TODO
 * @author zhaosen
 * @date 2015年7月7日
 */
public class URLConnUtil{
	
	public static final String UrlHead = "http://localhost:8080/VersionManager";
//	public static final String UrlHead = "http://localhost:8080/jifen_use_demo";
//	public static final String UrlHead = "http://172.16.0.209:8090/jifen";
//	public static final String UrlHead = "https://172.16.1.44:8443/jifen";
//	public static final String UrlHead = "https://172.16.0.209:8444/jifen";
//	public static final String UrlHead = "https://127.0.0.1:8443/jifen";
	
	public String getRemoteData(String urlStr,HttpServletRequest request) throws Exception{
		StringBuffer messStr = new StringBuffer();
		String access_token = (String) request.getSession().getAttribute("access_token");
		URL url = new URL(UrlHead+urlStr+"&access_token="+access_token);
		HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
		urlCon.setConnectTimeout(36000);
		urlCon.setReadTimeout(36000);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			messStr.append(URLDecoder.decode(line, "UTF-8"));
		}
		reader.close();
		String jsonStr = messStr.toString();
		return jsonStr;
	}
	
	public String postGetRemoteData(String urlStr,HttpServletRequest request) throws Exception{
		String access_token = (String) request.getSession().getAttribute("access_token");
		
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(UrlHead+urlStr+"&access_token="+access_token);
		
		CloseableHttpResponse response=httpclient.execute(httpPost);
		
		String jsonStr=EntityUtils.toString(response.getEntity(),"UTF-8");
		response.close();
		httpclient.close();
		return jsonStr;
	}
	
	public String getRemoteData(String urlStr) throws Exception{
		StringBuffer messStr = new StringBuffer();
		URL url = new URL(UrlHead+urlStr);
		System.out.println(url);
		HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
		urlCon.setConnectTimeout(36000);
		urlCon.setReadTimeout(36000);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			messStr.append(URLDecoder.decode(line, "UTF-8"));
		}
		reader.close();
		String jsonStr = messStr.toString();
		return jsonStr;
	}
	
	public String postGetRemoteData(String urlStr) throws Exception{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(UrlHead+urlStr);
		System.out.println(UrlHead+urlStr);
		CloseableHttpResponse response=httpclient.execute(httpPost);
		String jsonStr=EntityUtils.toString(response.getEntity(),"UTF-8");
		response.close();
		httpclient.close();
		
		return jsonStr;
	}
	
	public String postGetRemoteData1(String urlStr) throws Exception{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(urlStr);
		CloseableHttpResponse response=httpclient.execute(httpPost);
		String jsonStr=EntityUtils.toString(response.getEntity(),"UTF-8");
		response.close();
		httpclient.close();
		
		return jsonStr;
	}
	
}
