package com.lpc.ssm.service;

import java.util.List;

import com.lpc.ssm.entity.Dept;
import com.lpc.ssm.entity.User;

/**
 * 用户业务接口
 * @author Administrator
 *
 */
public interface UserService {

	
	/**
	 * 用户登录
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	
	public User login(String name,String pwd) throws Exception;
	
	/**
	 * 根据name查询用户
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public User getUser(Long id) throws Exception;
	
	/**
	 * 查询所有用户
	 * @return
	 * @throws Exception
	 */
	public List<User> getAllUser() throws Exception;
	
	/**
	 * 查询部门
	 * @return
	 * @throws Exception
	 */
	public Dept getDept(Long dept_id) throws Exception;
	
	/**
	 * 查询所有部门
	 * @return
	 * @throws Exception
	 */
	public List<Dept> getAllDept() throws Exception;
	
	/**
	 * 添加用户
	 * @param user
	 * @param dept_id -- 根据部门ID查出具体的部门对象,然后将其绑定给新增的用户对象
	 * @return
	 * @throws Exception
	 */
	public Long addUser(User user , Long dept_id) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param dept_id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Long updateUser(Long dept_id,User user) throws Exception;
	
	/**
	 * 根据name删除用户
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Long id) throws Exception;
	
}
