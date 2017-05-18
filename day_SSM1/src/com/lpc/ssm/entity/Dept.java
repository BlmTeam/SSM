package com.lpc.ssm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 部门实体类 -- 一方(one方)
 * @author lpclpc
 *
 */
public class Dept {
	private Long id;
	private String dept_name;
	private Date create_time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", dept_name=" + dept_name + "]\n"
				      + "成立时间:" + (null!=create_time ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(create_time)
				    		       														: "无");
	}
	
	
}
