package com.lpc.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lpc.ssm.entity.User;

/**
 * Mybatis操作t_user表(User实体类)的CRUD业务 -- DAO
 * @author Administrator
 *
 */
@Repository("userMapper")
public interface UserDao {
	
	/**
	 * 用户登录(传统MyBatis操作,会在自定义的UserDao实现类login方法重写中,自己制作<String,Object>,
	 * 			将name和pwd作为Map的键,其参数值作为Map的值,然后再讲Map给SqlSession的查询方法传参)
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
//	public User login(String name,String pwd) throws Exception;
	
	/**
	 * 用户登录(SSM做法,由于要使用自动生成UserDao的动态代理实现类,所以该方法的参数应与实际的mapper配置文件中的select)
	 * @param loginParam
	 * @return
	 * @throws Exception
	 */
	public User login(Map<String, Object> loginParam) throws Exception;
	
	/**
	 * 查询用户
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
	 * 添加用户
	 * @return
	 * @throws Exception
	 */
	public int addUser(User user) throws Exception;
	
	/**
	 * 修改用户信息
	 * @param pwd
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int updateUser(User user) throws Exception;
	
	/**
	 * 根据name删除用户
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Long id) throws Exception;
	
}
