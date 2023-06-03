package com.zmb.pk.service;

import java.util.List;

import com.zmb.pk.model.Dispatch;

public interface DispatchService {
	
	public void addOrUpdate(Dispatch dis)throws Exception;
	public void delete(Dispatch dis)throws Exception;
	public Dispatch detail(Dispatch dis)throws Exception;
	public Dispatch beforeUpdate(Dispatch dis)throws Exception;
	//查询人员列表
	public List<Dispatch> list(Dispatch dis,int currentpage, int pagesize)throws Exception;
	//总记录数
	public int recordCount() throws Exception;
	
}
