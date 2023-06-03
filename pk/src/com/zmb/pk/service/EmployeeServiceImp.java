package com.zmb.pk.service;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zmb.pk.model.Employee;

public class EmployeeServiceImp extends HibernateDaoSupport implements EmployeeService {

	public void addOrUpdate(Employee emp) throws Exception {
		
		this.getHibernateTemplate().saveOrUpdate(emp);

	}
	
   //删除员工，先根据ID找到该员工，然后再删除
	public void delete(Employee emp) throws Exception {
		
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Employee.class, emp.getEmpId()));
	}

	//员工明细
	public Employee detail(Employee emp) throws Exception {
		
		return  (Employee) this.getHibernateTemplate().get(Employee.class, emp.getEmpId());
	}
	
	//修改前详细资料
	public Employee beforeUpdate(Employee emp) throws Exception {
		
		return  (Employee) this.getHibernateTemplate().get(Employee.class, emp.getEmpId());
	}
	//员工列表
	public List<Employee> list(Employee emp, int currentpage, int pagesize)
			throws Exception {
		Criteria criteria = this.getSession().createCriteria(Employee.class);
		if(emp!=null) {
			if(StringUtils.isNotBlank(emp.getEmpId())) {

				criteria.add(Restrictions.like("empId", emp.getEmpId()));
	         
			}
			if(StringUtils.isNotBlank(emp.getName())) {

				criteria.add(Restrictions.eq("name",emp.getName()));
	         
			}
			if(StringUtils.isNotBlank(emp.getType())) {

				criteria.add(Restrictions.eq("type",emp.getType()));
	         
			}
			if(StringUtils.isNotBlank(emp.getSex())) {

				criteria.add(Restrictions.eq("sex",emp.getSex()));
	         
			}
			if(StringUtils.isNotBlank(emp.getStatus())) {

				criteria.add(Restrictions.eq("status",emp.getStatus()));
	         
			}
			if(StringUtils.isNotBlank(emp.getIfDuty())) {

				criteria.add(Restrictions.eq("ifDuty",emp.getIfDuty()));
	         
			}
			
		}

		criteria.setFirstResult((currentpage-1)*pagesize);
		criteria.setMaxResults(pagesize);
		List<Employee> list = criteria.list();
		
		return list;
	}

	//员工总记录数
	public int recordCount() throws Exception {
		
		StringBuffer sql = new StringBuffer("select count(emp_id) from employee where 1=1");
		SQLQuery query = this.getSession().createSQLQuery(sql.toString());
		List list = query.list();
		this.getSession().flush();
		int rscount = Integer.parseInt(list.get(0).toString());
		return rscount;
	}
	//获取最大序列号
	public int getMaxSequence() throws Exception {
		int max=0;
		String sql="select max(seq_num) from employee";
		SQLQuery query = this.getSession().createSQLQuery(sql);
		System.out.println("service中");
		Integer maxSeq=(Integer)query.uniqueResult();
		if(null!=maxSeq){
	     max=maxSeq.intValue();
		}
		System.out.println("service中"+max);
		return max;
	}

	public void modifyPasswd(Employee emp) throws Exception {
		Query query = this.getSession().createQuery(" update Employee e set e.passwd=:passwd where e.empId=:empId  ");
		query.setParameter("passwd", emp.getPasswd());
		query.setParameter("empId",emp.getEmpId());
		query.executeUpdate();
	}
	

}
