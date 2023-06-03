package com.zmb.pk.model;

public class Fee {
	
	
	private int feeId;//计费编号
	private String feeType;//费用类型:重量(吨)、体积(立方米)
	private String feeStandard;//单位金额:每公里重量或体积的运费
	

	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeStandard() {
		return feeStandard;
	}
	public void setFeeStandard(String feeStandard) {
		this.feeStandard = feeStandard;
	}
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}



}
