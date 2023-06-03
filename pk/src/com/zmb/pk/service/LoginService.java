package com.zmb.pk.service;

import com.zmb.pk.model.Employee;


public interface LoginService {
	
	public Employee  login( Employee bean) throws Exception;
 
	public Employee queryEmpInfo(String empId) throws Exception;

}
