package com.lpc.ssm.service;

import java.util.List;

import com.lpc.ssm.entity.Dept;

public interface DeptService {
	/**
	 * 根据部门id查询部门
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept getDept(Long id) throws Exception;
	
	/**
	 * 查询所有部门
	 * @return
	 * @throws Exception
	 */
	public List<Dept> getAllDept() throws Exception;
}
