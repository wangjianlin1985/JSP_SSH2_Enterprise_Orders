package com.zmb.pk.model;

public class Car {
	private String carId;//车辆编号
	private String carCard;//车牌号
	private String carVIN;//车架号码,类似车的身份证
	private String buyDate;//
	private String color;//
	private String tonnage;//吨位
	private String remarks;//备注
	private String carState;//状态：空闲、忙中、报废
	private int seqNum;//为每条记录生成一个序列号
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarCard() {
		return carCard;
	}
	public void setCarCard(String carCard) {
		this.carCard = carCard;
	}
	public String getCarVIN() {
		return carVIN;
	}
	public void setCarVIN(String carVIN) {
		this.carVIN = carVIN;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTonnage() {
		return tonnage;
	}
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	public String getCarState() {
		return carState;
	}
	public void setCarState(String carState) {
		this.carState = carState;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

}
