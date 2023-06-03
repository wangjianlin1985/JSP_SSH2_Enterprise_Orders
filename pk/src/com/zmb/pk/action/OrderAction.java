package com.zmb.pk.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.zmb.pk.model.Car;
import com.zmb.pk.model.Employee;
import com.zmb.pk.model.Fee;
import com.zmb.pk.model.Order;
import com.zmb.pk.service.OrderService;
import com.zmb.pk.util.Constants;
import com.zmb.pk.util.Page;

public class OrderAction {

	private Order bean;
	private Page page;//分页
	private OrderService orderService ;//spring 注入
	private String strTime;//生成操作时间
	private List<Order> orderList;//调度可供选择车辆
	private String pkSeq;//生成的主键好
	private String name;//生成操作员
	private List<Fee> feeList;
	private List<Car> carList;
	private List<Employee> driverList;
	private int maxSeq;//每条记录的序列号
	private String fsize;//计费值
	
	Logger log=Logger.getLogger(CarAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response= ServletActionContext.getResponse();
	//进入添加订单页面
	public String init() throws Exception {
		StringBuffer id= new StringBuffer("00000");
		 int i = orderService.getMaxSequence()+1;
		   log.info("最大的序列号："+i);
		   String num=String.valueOf(i);
		   id.setLength(id.length()-num.length());
		   id.append(num);
		   StringBuffer seq= new StringBuffer("order_");
		    seq.append(id);
	    log.info("拼接后的序列号："+seq.toString());
        this.setPkSeq(seq.toString());	  
        this.setMaxSeq(i);
        //生成操作时间
		Date now = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance();
		strTime=dt.format(now);
		this.setStrTime(strTime);
		//生成操作员
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String name=(String)session.getAttribute("name");
		this.setName(name);
		//生成fee
		feeList=orderService.feeList();
		System.out.println("fee="+feeList.size());
		
		return "add";
	}
	//Ajax 计算预计费用
	public String ajax1() throws IOException{
		//返回 json
		System.out.println("接收到的"+bean.getFeeStandard());
		System.out.println("接收到的"+bean.getTotalItems());

		int fee=Integer.parseInt(bean.getFeeStandard());
		float total=fee*bean.getTotalItems();
		System.out.println(total);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{total:"+total+"}");
		
		return null;
	}
	//1)查询订单列表
	public String list() throws Exception{
		log.info("=======查询订单列表========");
		

    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(orderService.recordCount());
			page.setList(orderService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
        bean=null;//防止表单回填
		return  "checkList";
	}
	
	//2)添加订单，然后跳转到订单列表页面
	public String addOrUpdate() throws Exception{
		log.info("=======添加订单========");
		System.out.println("=====seqnu======="+bean.getSeqNum());
		System.out.println("预计公里数："+bean.getPreKilometer());
		if("1".equals(bean.getFeeStandard())){
			bean.setWeight(fsize);
		}
		if("2".equals(bean.getFeeStandard())){
			bean.setVolume(fsize);
		}				
		if(null!=bean.getStatus2()&&bean.getStatus3()==null&&bean.getStatus4()==null&&bean.getStatus5()==null){
			 bean.setStatus(bean.getStatus2());
		}
	
		orderService.addOrUpdate(bean);
		bean=null;//防止表单回填
		return "toList";
	}
	
	//1)查询订单列表2----用于调度操作
	public String dispatchList() throws Exception{
		log.info("=======查询审核通过的单子，进行调度========");
		//生成操作时间
		Date now = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance();
		strTime=dt.format(now);
		this.setStrTime(strTime);
    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(orderService.recordCount());
			page.setList(orderService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
			
			bean=null;//防止表单回填
		return  "dispatch";
	}
	//订单调度
	public String dispatch() throws Exception{
		log.info("=======订单调度========");
		System.out.println("=====seqnu======="+bean.getSeqNum());
		System.out.println("=====seqnu======="+bean.getGoods());
	    System.out.println("carCard:"+bean.getCarCard());
		orderService.changeCar(bean.getCarCard());
		orderService.changeDriver(bean.getDriver());
		orderService.addOrUpdate(bean);
		bean=null;//防止表单回填
		return  "dispatchList";
	}
	
	//订单调度
	public String dispatchStatus() throws Exception{
		log.info("=======更改状态========");
		//<a href="order_dispatchStatus.action?bean.status4='运输途中'&bean.time4='%{strTime}'&bean.orderId=<s:property value="orderId"/>
		System.out.println("=====getOrderId:"+bean.getOrderId());
		System.out.println("=====getStatus4:"+bean.getStatus4());
		System.out.println("=====gettime4:"+bean.getTime4());
		if(bean.getStatus4().equals("4")){
			bean.setStatus4("运输途中");
			 System.out.println(bean.getStatus());
			bean.setStatus("运输途中");
		}
		bean.setTime4(bean.getTime4());
		orderService.update(bean);
		bean=null;//防止表单回填
		return  "dispatchList";
	}
	
	public String dispatchStatus5() throws Exception{
		log.info("=======更改状态========");
		//<a href="order_dispatchStatus.action?bean.status4='运输途中'&bean.time4='%{strTime}'&bean.orderId=<s:property value="orderId"/>
		System.out.println("=====getOrderId:"+bean.getOrderId());
		System.out.println("=====getStatus5:"+bean.getStatus5());
		System.out.println("=====gettime5:"+bean.getTime5());
		if(bean.getStatus5().equals("5")){
			bean.setStatus5("等待确认");
			bean.setStatus("等待确认");
		}
		bean.setTime5(bean.getTime5());
		orderService.updateover(bean);
		bean=null;//防止表单回填
		return  "dispatchList";
	}
	//订单完成列表
	public String over() throws Exception{
		log.info("=======查询订单列表========");
		

    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(orderService.recordCount());
			page.setList(orderService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
        bean=null;//防止表单回填
		return  "overs";
	}
	
	


	
	//3)修改前，获取到的订单信息
	public String beforeUpdate() throws Exception{
		log.info("=======修改前，获取到的订单信息========");
		bean=orderService.beforeUpdate(bean);
		feeList=orderService.feeList();
		return "update";
	}
	
	//3)订单配送前，获取到的订单信息
/*	public String beforeDispatch() throws Exception{
		log.info("=======修改前，获取到的订单信息========");
		bean=orderService.beforeUpdate(bean);

		orderList=orderService.orderSelected();
		log.info("车辆列表"+orderList.size());
		return "beforeDispatch";
	}*/
	
	//5)订单审核页
	public String check() throws Exception{
		log.info("=======订单审核========");
		bean=orderService.detail(bean);
        //生成操作时间
		Date now = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance();
		strTime=dt.format(now);
		this.setStrTime(strTime);
		return "check";
	}
	
	//选派车辆
	public String dispatchCar() throws Exception{
		log.info("=======选派车辆========");
		//生成操作时间
		Date now = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance();
		strTime=dt.format(now);
		this.setStrTime(strTime);
		carList = orderService.carList();
		driverList=orderService.driverList();
	
		bean=orderService.detail(bean);
		return "dispatchcar";
	}
	//6删除订单
	public String detail() throws Exception{
		log.info("=======订单明细========");
		bean=orderService.detail(bean);
		return "detail";
	}
	//4)客户确认订单
	public String comfirm() throws Exception{
		log.info("=======客户确认订单========");
		if("0".equals(bean.getStatus())){
			bean.setStatus("已确认");
		}
		
		 //生成操作时间
		Date now = new Date();
		DateFormat dt = DateFormat.getDateTimeInstance();
		strTime=dt.format(now);
		bean.setReceiveTime(strTime);
		System.out.println("id:"+bean.getOrderId());
		System.out.println(bean.getStatus());

		String CarCard = new String((bean.getCarCard()).getBytes("iso-8859-1"),"utf-8");
		System.out.println("确认操作的carcard:"+CarCard);

		orderService.comfirm(bean);
		orderService.changeCar2(CarCard);
		orderService.changeDriver2(bean.getDriver());
		return detail();
	}
	//6删除订单
	public String delete() throws Exception{
		log.info("=======删除订单========");
		orderService.delete(bean);
		return "del";
	}
	//=================setter()/getter()===================



	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	public Order getBean() {
		return bean;
	}


	public void setBean(Order bean) {
		this.bean = bean;
	}


	public String getStrTime() {
		return strTime;
	}


	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public String getPkSeq() {
		return pkSeq;
	}

	public void setPkSeq(String pkSeq) {
		this.pkSeq = pkSeq;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(int maxSeq) {
		this.maxSeq = maxSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Fee> getFeeList() {
		return feeList;
	}

	public void setFeeList(List<Fee> feeList) {
		this.feeList = feeList;
	}

	

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	public String getFsize() {
		return fsize;
	}
	public void setFsize(String fsize) {
		this.fsize = fsize;
	}
	public List<Employee> getDriverList() {
		return driverList;
	}
	public void setDriverList(List<Employee> driverList) {
		this.driverList = driverList;
	}

}
