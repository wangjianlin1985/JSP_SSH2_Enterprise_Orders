package com.zmb.pk.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zmb.pk.model.Car;
import com.zmb.pk.model.Employee;

public class CarServiceImp extends HibernateDaoSupport implements CarService {

	public void addOrUpdate(Car car) throws Exception {
		this.getHibernateTemplate().saveOrUpdate(car);
	}

	public Car beforeUpdate(Car car) throws Exception {
		return  (Car) this.getHibernateTemplate().get(Car.class, car.getCarId());
	}

	public void delete(Car car) throws Exception {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Car.class, car.getCarId()));
	}

	public Car detail(Car car) throws Exception {
		return  (Car) this.getHibernateTemplate().get(Car.class, car.getCarId());
	}

	public List<Car> list(Car car, int currentpage, int pagesize)
			throws Exception {
		Criteria criteria = this.getSession().createCriteria(Car.class);
		if(car!=null) {
			if(StringUtils.isNotBlank(car.getCarId())) {

				criteria.add(Restrictions.like("carId", car.getCarId()));
	         
			}
			if(StringUtils.isNotBlank(car.getCarVIN())) {

				criteria.add(Restrictions.like("carVIN", car.getCarVIN()));
	         
			}
			if(StringUtils.isNotBlank(car.getCarCard())) {

				criteria.add(Restrictions.eq("carCard",car.getCarCard()));
	         
			}
			if(StringUtils.isNotBlank(car.getCarState())) {

				criteria.add(Restrictions.eq("carState",car.getCarState()));
	         
			}
		}

		criteria.setFirstResult((currentpage-1)*pagesize);
		criteria.setMaxResults(pagesize);
		List<Car> list = criteria.list();
		
		return list;
	}

	public int recordCount() throws Exception {
		StringBuffer sql = new StringBuffer("select count(car_id) from car where 1=1");
		SQLQuery query = this.getSession().createSQLQuery(sql.toString());
		List list = query.list();
		this.getSession().flush();
		int rscount = Integer.parseInt(list.get(0).toString());
		return rscount;
	}

	public List carSelected() throws Exception {
		Query query = this.getSession().createQuery(
		"from Car c where c.carState='空闲'");
		return query.list();
	}

	//获取最大序列号
	public int getMaxSequence() throws Exception {
		int max=0;
		String sql="select max(seq_num) from car";
		SQLQuery query = this.getSession().createSQLQuery(sql);
		System.out.println("service中");
		Integer maxSeq=(Integer)query.uniqueResult();
		if(null!=maxSeq){
	     max=maxSeq.intValue();
		}
		System.out.println("service中"+max);
		return max;
	}

	public List<Car> excelList() throws Exception {
		Criteria criteria = this.getSession().createCriteria(Car.class);
		
		return criteria.list();
	}

}
