package com.zmb.pk.service;

import java.util.List;

import com.zmb.pk.model.Employee;

public interface EmployeeService {
	
	public void addOrUpdate(Employee emp)throws Exception;
	public void delete(Employee emp)throws Exception;
	public Employee detail(Employee emp)throws Exception;
	public Employee beforeUpdate(Employee emp)throws Exception;
	//查询人员列表
	public List<Employee> list(Employee emp,int currentpage, int pagesize)throws Exception;
	//总记录数
	public int recordCount() throws Exception;
	public int getMaxSequence() throws Exception;
	public void modifyPasswd(Employee emp)throws Exception;

}
