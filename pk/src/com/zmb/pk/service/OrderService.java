package com.zmb.pk.service;

import java.util.List;

import com.zmb.pk.model.Car;
import com.zmb.pk.model.Employee;
import com.zmb.pk.model.Order;


public interface OrderService {

	public void addOrUpdate(Order order)throws Exception;
	public void delete(Order order)throws Exception;
	public Order detail(Order order)throws Exception;
	public Order beforeUpdate(Order order)throws Exception;
	//查询订单列表
	public List<Order> list(Order order,int currentpage, int pagesize)throws Exception;

	//总记录数
	public int recordCount() throws Exception;
	public int getMaxSequence() throws Exception;
	public List feeList() throws Exception;
	public List carList() throws Exception;
	public void changeCar(String carCard)throws Exception;
	public void changeCar2(String carCard)throws Exception;
	public List driverList() throws Exception;
	public void changeDriver(String empId)throws Exception;
	public void changeDriver2(String empId)throws Exception;
	public void updateover(Order order) throws Exception;
	public void update(Order order)throws Exception;
	public void comfirm(Order order)throws Exception;
}
