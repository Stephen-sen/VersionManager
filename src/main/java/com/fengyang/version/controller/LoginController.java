/**  
 * @Title: LoginController.java
 * @author zhaosen
 * @date 2015-11-5
 */
package com.fengyang.version.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: LoginController 
 * @Description: TODO
 * @author zhaosen
 * @date 2015-11-5
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
}
