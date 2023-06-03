package com.zmb.pk.service;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zmb.pk.model.Car;
import com.zmb.pk.model.Fee;

public class FeeServiceImp extends HibernateDaoSupport implements FeeService {

	public void addOrUpdate(Fee fee) throws Exception {
		this.getHibernateTemplate().saveOrUpdate(fee);
	}

	public Fee beforeUpdate(Fee fee) throws Exception {
		return  (Fee) this.getHibernateTemplate().get(Fee.class,fee.getFeeId());
	}

	public void delete(Fee fee) throws Exception {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Fee.class, fee.getFeeId()));
	}

	public Fee detail(Fee fee) throws Exception {
		return  (Fee) this.getHibernateTemplate().get(Fee.class, fee.getFeeId());
	}

	public List<Fee> list(Fee fee, int currentpage, int pagesize)
			throws Exception {
		Criteria criteria = this.getSession().createCriteria(Fee.class);
		if(fee!=null) {
			if(StringUtils.isNotBlank(fee.getFeeType())) {

				criteria.add(Restrictions.like("feeType", fee.getFeeType()));
	         
			}
			
		}

		criteria.setFirstResult((currentpage-1)*pagesize);
		criteria.setMaxResults(pagesize);
		List<Fee> list = criteria.list();
		
		return list;
	}

	public int recordCount() throws Exception {
		StringBuffer sql = new StringBuffer("select count(id) from fee where 1=1");
		SQLQuery query = this.getSession().createSQLQuery(sql.toString());
		List list = query.list();
		this.getSession().flush();
		int rscount = Integer.parseInt(list.get(0).toString());
		return rscount;
	}

}
