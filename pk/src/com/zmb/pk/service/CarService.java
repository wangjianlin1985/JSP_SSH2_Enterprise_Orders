package com.zmb.pk.service;

import java.util.List;

import com.zmb.pk.model.Car;


public interface CarService {

	public void addOrUpdate(Car car)throws Exception;
	public void delete(Car car)throws Exception;
	public Car detail(Car car)throws Exception;
	public Car beforeUpdate(Car car)throws Exception;
	//查询人员列表
	public List<Car> list(Car car,int currentpage, int pagesize)throws Exception;
	public List<Car> excelList()throws Exception;
	//总记录数
	public int recordCount() throws Exception;
	
	public List  carSelected() throws Exception;
	public int getMaxSequence()throws Exception;
}
