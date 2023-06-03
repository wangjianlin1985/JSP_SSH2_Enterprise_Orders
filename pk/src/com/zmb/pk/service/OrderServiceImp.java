package com.zmb.pk.service;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zmb.pk.model.Car;
import com.zmb.pk.model.Employee;
import com.zmb.pk.model.Order;

public class OrderServiceImp extends HibernateDaoSupport implements OrderService {

	public void addOrUpdate(Order order) throws Exception {
		this.getHibernateTemplate().saveOrUpdate(order);
	}

	public Order beforeUpdate(Order order) throws Exception {
		return  (Order) this.getHibernateTemplate().get(Order.class, order.getOrderId());
	}

	public void delete(Order order) throws Exception {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Order.class, order.getOrderId()));
	}

	public Order detail(Order order) throws Exception {
		return  (Order) this.getHibernateTemplate().get(Order.class, order.getOrderId());
	}

	public List<Order> list(Order order, int currentpage, int pagesize)
			throws Exception {
		Criteria criteria = this.getSession().createCriteria(Order.class);
		if(order!=null) {
			if(StringUtils.isNotBlank(order.getOrderId())) {

				criteria.add(Restrictions.like("orderId", order.getOrderId()));
	         
			}
			if(StringUtils.isNotBlank(order.getCustomer())) {

				criteria.add(Restrictions.like("customer", order.getCustomer()));
	         
			}
			if(StringUtils.isNotBlank(order.getAcceptTime())) {

				criteria.add(Restrictions.eq("acceptTime",order.getAcceptTime()));
	         
			}
			if(StringUtils.isNotBlank(order.getStatus())) {

				criteria.add(Restrictions.eq("status",order.getStatus()));
	         
			}
			if(StringUtils.isNotBlank(order.getReceiveTime())) {

				criteria.add(Restrictions.eq("receiveTime",order.getReceiveTime()));
	         
			}
		}

		criteria.setFirstResult((currentpage-1)*pagesize);
		criteria.setMaxResults(pagesize);
		List<Order> list = criteria.list();
		
		return list;
	}

	public int recordCount() throws Exception {
		StringBuffer sql = new StringBuffer("select count(*) from orders where 1=1");
		SQLQuery query = this.getSession().createSQLQuery(sql.toString());
		List list = query.list();
		this.getSession().flush();
		int rscount = Integer.parseInt(list.get(0).toString());
		return rscount;
	}
	
	public int getMaxSequence() throws Exception {
		int max=0;
		String sql="select max(seq_num) from orders";
		SQLQuery query = this.getSession().createSQLQuery(sql);
		System.out.println("service中");
		Integer maxSeq=(Integer)query.uniqueResult();
		if(null!=maxSeq){
	     max=maxSeq.intValue();
		}
		System.out.println("service中"+max);
		return max;
	}
	
	public List feeList() throws Exception{
		Query query = this.getSession().createQuery("from Fee");
//		query.setParameter("pid",4);
		List list = query.list();
		return list;
	}
	
	public List carList() throws Exception{
		Query query = this.getSession().createQuery("from Car c where c.carState='空闲'");
		List list = query.list();
		return list;
	}
	//更改车状态：空闲--》运输途中
	public void changeCar(String carCard) throws Exception {
		Query query = this.getSession().createQuery(" update Car c set c.carState=:carState where c.carCard=:carCard  ");
		query.setParameter("carState", "运输途中");
		query.setParameter("carCard", carCard);
		query.executeUpdate();
	}
	//更改车状态：运输途中--》空闲
	public void changeCar2(String carCard) throws Exception {
		Query query = this.getSession().createQuery(" update Car c set c.carState=:carState where c.carCard=:carCard  ");
		query.setParameter("carState", "空闲");
		query.setParameter("carCard", carCard);
		query.executeUpdate();
	}
	public void update(Order order) throws Exception {
		Query query = this.getSession().createQuery(" update Order o set o.status4=:status4 , o.status=:status, o.time4=:time4 where o.orderId=:orderId  ");
		query.setParameter("status4", order.getStatus4());
		query.setParameter("time4", order.getTime4());
		query.setParameter("status", order.getStatus());
		query.setParameter("orderId", order.getOrderId());
		query.executeUpdate();
	}
	public void updateover(Order order) throws Exception {
		Query query = this.getSession().createQuery(" update Order o set o.status5=:status5 ,o.status=:status, o.time5=:time5 where o.orderId=:orderId  ");
		query.setParameter("status5", order.getStatus5());
		query.setParameter("time5", order.getTime5());
		query.setParameter("status", order.getStatus());
		query.setParameter("orderId", order.getOrderId());
		query.executeUpdate();
	}

	public void comfirm(Order order) throws Exception {
		Query query = this.getSession().createQuery(" update Order o set o.receiveTime=:receiveTime ,o.status=:status where o.orderId=:orderId  ");
		query.setParameter("receiveTime", order.getReceiveTime());
		query.setParameter("status", order.getStatus());
		query.setParameter("orderId", order.getOrderId());
		query.executeUpdate();
	}

	public List driverList() throws Exception {
		Query query = this.getSession().createQuery("from Employee e where e.type='驾驶员'and e.status='空闲'");
//		query.setParameter("pid",4);
		List list = query.list();
		
		return list;
	}


     //司机：空闲--->忙
	public void changeDriver(String empId) throws Exception {
		Query query = this.getSession().createQuery(" update Employee e set e.status=:status where e.empId=:empId  ");
		query.setParameter("status", "忙中");
		query.setParameter("empId", empId);
		query.executeUpdate();
	}
	//司机：忙--->空闲
	public void changeDriver2(String empId) throws Exception {
		Query query = this.getSession().createQuery(" update Employee e set e.status=:status where e.empId=:empId  ");
		query.setParameter("status", "空闲");
		query.setParameter("empId", empId);
		query.executeUpdate();
	}
}
