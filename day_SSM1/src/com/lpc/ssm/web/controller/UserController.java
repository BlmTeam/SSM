package com.lpc.ssm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lpc.ssm.entity.User;
import com.lpc.ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/to_main")
	public ModelAndView to_main(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		try {
			modelAndView.addObject("allDept", userService.getAllDept());
			modelAndView.addObject("allUser", userService.getAllUser());
		} catch (Exception e) {
			modelAndView.addObject("error_message", "后台错误,请检查!");
		} 
		return modelAndView;
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam Long id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		try {
			if (userService.deleteUser(id) > 0) {
				modelAndView.setViewName("index");
			} else {
				modelAndView.addObject("error_message", "删除失败!");
			}
		} catch (Exception e) {
			modelAndView.addObject("error_message", "后台错误,请检查!");
		} 
		return modelAndView;
	}
	
	@RequestMapping("/updateUser")
	public ModelAndView updateUser(Long id,String name,String pwd,@RequestParam Long dept_id){
//	public ModelAndView updateUser(@RequestParam User user,@RequestParam Long dept_id){
//		System.out.println(user.getName()+","+user.getPwd());
		System.out.println(id+","+name+","+pwd);
		System.out.println(dept_id);
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPwd(pwd);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		try {
			if (userService.updateUser(dept_id, user) > 0) {
				modelAndView.setViewName("index");
			} else {
				modelAndView.addObject("error_message", "修改失败!");
			}
		} catch (Exception e) {
			modelAndView.addObject("error_message", "后台错误,请检查!");
		} 
		return modelAndView;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(String name,String pwd,@RequestParam Long dept_id){
		System.out.println(name+","+pwd);
		System.out.println(dept_id);
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		try {
			if (userService.addUser(user, dept_id) > 0) {
				modelAndView.setViewName("index");
			} else {
				modelAndView.addObject("error_message", "添加失败!");
			}
		} catch (Exception e) {
			modelAndView.addObject("error_message", "后台错误,请检查!");
		} 
		return modelAndView;
	}
	
}
