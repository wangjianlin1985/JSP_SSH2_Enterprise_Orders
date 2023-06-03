package com.zmb.pk.service;

import java.util.List;

import com.zmb.pk.model.Fee;

public interface FeeService {

	public void addOrUpdate(Fee fee)throws Exception;
	public void delete(Fee fee)throws Exception;
	public Fee detail(Fee fee)throws Exception;
	public Fee beforeUpdate(Fee fee)throws Exception;
	//查询人员列表
	public List<Fee> list(Fee fee,int currentpage, int pagesize)throws Exception;
	//总记录数
	public int recordCount() throws Exception;
}
