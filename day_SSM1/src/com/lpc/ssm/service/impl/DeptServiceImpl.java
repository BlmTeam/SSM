package com.lpc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lpc.ssm.entity.Dept;
import com.lpc.ssm.mapper.DeptDao;
import com.lpc.ssm.service.DeptService;

@Transactional(propagation=Propagation.REQUIRED)
@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
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

}
