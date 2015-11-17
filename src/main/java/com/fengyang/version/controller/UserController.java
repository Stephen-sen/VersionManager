package com.fengyang.version.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fengyang.base.controller.BaseController;
import com.fengyang.base.entity.Page;
import com.fengyang.util.CommenUtil;
import com.fengyang.version.entity.User;
import com.fengyang.version.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController{
	Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@RequestMapping("/userList")
	public ModelAndView userList(Integer pageNo,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		try {
			pageNo = pageNo==null?1:pageNo;
			int pageSize=this.getCookiesPageSize(request);
			Page pagedDate = userService.getUserList(pageNo, pageSize);
//			List<User> list = userService.getUserList();
			view.addObject("pagedDate", pagedDate);
			view.setViewName("user/userList");
		} catch (Exception e) {
			logger.error(CommenUtil.getTrace(e));
		}
		return view;
	}
	
	@RequestMapping("/userPageList")
	public void userPageList(HttpServletRequest request,HttpServletResponse response){
			Page pageDate = userService.getUserList(0, 5);
			try {
				response.getWriter().print(JSON.toJSON(pageDate));
			} catch (IOException e) {
				logger.error(CommenUtil.getTrace(e));
			}
	}
	
	@RequestMapping("/view")
	public ModelAndView view(HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		view.setViewName("user/addUser");
		return view;
	}
	
	@RequestMapping("saveUser")
	public ModelAndView saveUser(Integer pageNo,User user,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			logger.error(CommenUtil.getTrace(e));
		}
		view=userList(pageNo,request,response);
		return view;
	}
	
	@RequestMapping("find")
	public ModelAndView find(String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		try {
			User user = userService.findUserById(id);
			view.addObject("userInfo", user);
			view.setViewName("user/editUser");
		} catch (Exception e) {
			logger.error(CommenUtil.getTrace(e));
		}
		return view;
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(Integer pageNo,User user,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		try {
			User userInfo = userService.findUserById(user.getId());
			userInfo.setPhoneNum(user.getPhoneNum());
			userInfo.setSex(user.getSex());
			userInfo.setUserName(user.getUserName());
			userService.updateUser(userInfo);
			view=userList(pageNo,request,response);
		} catch (Exception e) {
			logger.error(CommenUtil.getTrace(e));
		}
		return view;
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(Integer pageNo,String id,HttpServletRequest request,HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		try {
			userService.deleteUser(id);
			view=userList(pageNo,request,response);
		} catch (Exception e) {
			logger.error(CommenUtil.getTrace(e));
		}
		return view;
	}
}
