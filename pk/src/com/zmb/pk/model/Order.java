package com.zmb.pk.model;

public class Order {

	private String orderId;// 订单号主键
	private String customer;// 客户名
	private String customerTel;// 客户电话
	private String acceptAddr;// 接货地址
	private String acceptTime;// 接货时间
	private String sendAddr;// 送货地址
	private String sendTime;//送货时间
	private String receiveTime;//订单完成时间
	private String goods;// 货物
	private String weight;// 重量
	private String volume;// 体积
	private String feeType;// 计费类型
	private String feeStandard;// 计费单价
	private String preKilometer;// 预计公里数
	private String preCost;// 预计运费 运费=重量或体积数量*单位金额*预计公里数，但运费项也可手动修改
	private String relKilometer;// 实际公里数
	private String relCost;// 实际运费
	private String status;// 状态：审核通过、审核未通过、配送完成
	private String num;//总件数
	private int totalItems;// 数量
	private String remarks;// 备注
	private String operator;// 操作员
	private String carCard;//车辆牌号
	private String operateTime;// 操作日期
	private int seqNum;// 获取记录的最大序列号
	private String driver;//司机
	//额外添加 2011-12-28
	private String status1;//状态值：订单定制成功
	private String status2;//状态值：审核通过、未审核通过
	private String status3;//状态值：配送完成
	private String status4;//状态值：运输途中
	private String status5;////状态值：完成
	private String time1;//定制时间
	private String time2;//审核时间
	private String time3;//配送时间
	private String time4;//运输时间
	private String time5;//完成时间
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getAcceptAddr() {
		return acceptAddr;
	}
	public void setAcceptAddr(String acceptAddr) {
		this.acceptAddr = acceptAddr;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getSendAddr() {
		return sendAddr;
	}
	public void setSendAddr(String sendAddr) {
		this.sendAddr = sendAddr;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
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
	public String getPreKilometer() {
		return preKilometer;
	}
	public void setPreKilometer(String preKilometer) {
		this.preKilometer = preKilometer;
	}
	public String getPreCost() {
		return preCost;
	}
	public void setPreCost(String preCost) {
		this.preCost = preCost;
	}
	public String getRelKilometer() {
		return relKilometer;
	}
	public void setRelKilometer(String relKilometer) {
		this.relKilometer = relKilometer;
	}
	public String getRelCost() {
		return relCost;
	}
	public void setRelCost(String relCost) {
		this.relCost = relCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCarCard() {
		return carCard;
	}
	public void setCarCard(String carCard) {
		this.carCard = carCard;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public String getStatus3() {
		return status3;
	}
	public void setStatus3(String status3) {
		this.status3 = status3;
	}
	public String getStatus4() {
		return status4;
	}
	public void setStatus4(String status4) {
		this.status4 = status4;
	}
	public String getStatus5() {
		return status5;
	}
	public void setStatus5(String status5) {
		this.status5 = status5;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTime3() {
		return time3;
	}
	public void setTime3(String time3) {
		this.time3 = time3;
	}
	public String getTime4() {
		return time4;
	}
	public void setTime4(String time4) {
		this.time4 = time4;
	}
	public String getTime5() {
		return time5;
	}
	public void setTime5(String time5) {
		this.time5 = time5;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}

	
}
