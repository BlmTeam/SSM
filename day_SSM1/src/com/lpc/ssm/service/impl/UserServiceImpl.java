package com.lpc.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lpc.ssm.entity.Dept;
import com.lpc.ssm.entity.User;
import com.lpc.ssm.mapper.DeptDao;
import com.lpc.ssm.mapper.UserDao;
import com.lpc.ssm.service.UserService;

@Transactional(propagation=Propagation.REQUIRED)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public User login(String name, String pwd) throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("pwd", pwd);
		
		return userDao.login(map);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public User getUser(Long id) throws Exception {
		return userDao.getUser(id);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public List<User> getAllUser() throws Exception {
		return userDao.getAllUser();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public Dept getDept(Long dept_id) throws Exception {
		return deptDao.getDeptId(dept_id);
	}

	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Override
	public List<Dept> getAllDept() throws Exception {
		return deptDao.getAllDept();
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public Long addUser(User user,Long dept_id) throws Exception {
		//在业务模型中,负责将新建用户与所在的部门实现"many-to-one绑定
		Dept dept = deptDao.getDeptId(dept_id);
		System.out.println(dept);
		user.setDept(dept);
		if (userDao.addUser(user) > 0) {
			return user.getDept().getId();
		} else {
			return -1L;
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public Long updateUser(Long dept_id, User user) throws Exception {
		Dept dept = deptDao.getDeptId(dept_id);
		if (null == dept) {
			System.out.println("部门不存在哦!");
			return -1L;
		}
		user.setDept(deptDao.getDeptId(dept_id));
		System.out.println("准备修改用户:" + user.getName() + "的信息");
		user.setDept(dept);
		if (userDao.updateUser(user) > 0) {
			return 1L;
		} else {
			return -1L;
		}
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public int deleteUser(Long id) throws Exception {
		User user = userDao.getUser(id);
		if (null == user) {
			System.out.println("用户不存在哦!");
			return -1;
		}
		System.out.println("准备删除用户:" + user.getName());
		if (userDao.deleteUser(user.getId()) > 0) {
			return 1;
		} else {
			return -1;
		}
		
	}



}
