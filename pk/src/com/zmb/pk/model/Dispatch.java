package com.zmb.pk.model;

public class Dispatch {
	
	 private int id;//主键
//	 private String orderId;//订单编号
//	 private String CarId;//车辆编号
//	 private String CardNum;//车牌
	 private String date;//调度日期
	 private Order order;//订单
	 private Car car;//车辆
	 private String remarks;//描述
	 
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
