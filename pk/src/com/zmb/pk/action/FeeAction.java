package com.zmb.pk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.zmb.pk.model.Fee;
import com.zmb.pk.service.FeeService;
import com.zmb.pk.util.Constants;
import com.zmb.pk.util.Page;

public class FeeAction {
	private Fee bean;
	private Page page;//分页
	private FeeService feeService ;//spring 注入
	
	Logger log=Logger.getLogger(FeeAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	//1)查询员工列表
	public String list() throws Exception{
		log.info("=======查询费用列表========");
		

    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(feeService.recordCount());
			page.setList(feeService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
			bean=null;//防止表单回填
		return  "list";
	}
	
	//2)添加费用，然后跳转到费用列表页面
	public String addOrUpdate() throws Exception{
		log.info("=======添加费用========");
		
		feeService.addOrUpdate(bean);
		bean=null;//防止表单回填
		return "add";
	}
	
	//3)修改前，获取到的费用信息
	public String beforeUpdate() throws Exception{
		log.info("=======修改前，获取到的费用信息========");
		bean=feeService.beforeUpdate(bean);
		return "update";
	}
	
	//4)修改费用
	public String update() throws Exception{
		log.info("=======修改费用========");
		
		return list();
	}
	//5)费用明细
	public String detail() throws Exception{
		log.info("=======费用明细========");
		bean=feeService.detail(bean);
		return "detail";
	}
	
	//删除费用
	public String delete() throws Exception{
		log.info("=======删除费用========");
		
		feeService.delete(bean);
		return "del";
	}
	//=================setter()/getter()===================

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}



	public FeeService getFeeService() {
		return feeService;
	}

	public void setFeeService(FeeService feeService) {
		this.feeService = feeService;
	}

	public Fee getBean() {
		return bean;
	}

	public void setBean(Fee bean) {
		this.bean = bean;
	}


	

}
