package com.zmb.pk.service;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zmb.pk.model.Employee;

public class LoginServiceImp  extends HibernateDaoSupport implements LoginService {

	Logger log = Logger.getLogger(LoginServiceImp.class);
	
	//登录
	public Employee login(Employee bean) {
		 log.info("login验证中......"); 
		 log.info("login验证中......"+bean.getEmpId());
		Query query = this.getSession().createQuery("from Employee r where r.empId=:id");
		query.setParameter("id", bean.getEmpId());
	 	Employee emp=(Employee) query.uniqueResult();
		 if(null!=emp&&emp.getPasswd().equals(bean.getPasswd())){
			 log.info("身份验证通过......"); 
			return emp;
			 
		 }else{
			 emp=null;
			 return emp;
		 }
			
	}

	//获取Unit信息
	public Employee queryEmpInfo(String empId) throws Exception {
		
		
		return null;
	}

}
