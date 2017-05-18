package com.lpc.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lpc.ssm.entity.Dept;
import com.lpc.ssm.entity.User;
import com.lpc.ssm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-beans.xml")
public class SpringTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test_login() throws Exception {
		User login = userService.login("张三丰", "qwE");
		
		if (null != login) {
			System.out.println("账号是:"+login.getName()+",密码是:"+login.getPwd()+",部门是:"+login.getDept());
		} else {
			System.out.println("登录失败");
		}
	}
	
	@Test
	public void test_getAllUser() throws Exception {
		List<User> allUser = userService.getAllUser();
		for (User user : allUser) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test_addUser() throws Exception {
		User user = new User();
		user.setName("^_^111");
		user.setPwd("xxxxxx");
		Long addUser = userService.addUser(user,3L);
		if (addUser > 0) {
			System.out.println("添加成功,自动生成的id是:"+user.getId());
		} else {
			System.out.println("添加失败");
		}
	}
	
	@Test
	public void test_updateUser() throws Exception {
		User user = userService.login("火贪一刀", "qweR");
		user.setPwd("666");
		Long dept_id = 2L;
		if (userService.updateUser(dept_id,user) > 0) {
			System.out.println("修改用户信息成功,用户信息如下:" + user);
		} else {
			System.out.println("修改失败");
		}
	}
	
	@Test
	public void test_deleteUser() throws Exception {
		Long id = 15L;
		if (userService.deleteUser(id) > 0) {
			System.out.println("删除用户成功!");
		} else {
			System.out.println("删除不成功");
		}
	}
	
	@Test
	public void test_getAllDept() throws Exception {
		List<Dept> allDept = userService.getAllDept();
		for (Dept dept : allDept) {
			System.out.println(dept);
		}
	}
	
	@Test
	public void test_getDept() throws Exception {
		Dept dept = userService.getDept(3L);
		System.out.println(dept);
	}
}
