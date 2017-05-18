package com.lpc.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lpc.ssm.entity.Dept;

/**
 * 部门Dao
 * @author Administrator
 *
 */
@Repository("deptDao")
public interface DeptDao {
	/**
	 * 根据部门id查询部门
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept getDeptId(Long id) throws Exception;
	
	/**
	 * 查询所有部门
	 * @return
	 * @throws Exception
	 */
	public List<Dept> getAllDept() throws Exception;
}
