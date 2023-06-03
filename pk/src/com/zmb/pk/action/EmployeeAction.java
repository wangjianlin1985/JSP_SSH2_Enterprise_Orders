package com.zmb.pk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zmb.pk.model.Employee;
import com.zmb.pk.service.EmployeeService;
import com.zmb.pk.util.Constants;
import com.zmb.pk.util.Page;

public class EmployeeAction extends ActionSupport {
	
	private Employee bean;
	private Page page;//分页
	private EmployeeService employeeService ;//spring 注入
	private String pkSeq;//生成的主键好
	private int maxSeq;//每条记录的序列号
	private String oldpasswd;//输入旧密码
	
	Logger log=Logger.getLogger(EmployeeAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	

	//进入到添加页面
	public String init() throws Exception {
		StringBuffer id= new StringBuffer("00000");
		 int i = employeeService.getMaxSequence()+1;
		   log.info("最大的序列号："+i);
		   String num=String.valueOf(i);
		   id.setLength(id.length()-num.length());
		   id.append(num);
		   StringBuffer seq= new StringBuffer("emp_");
		    seq.append(id);
	    log.info("拼接后的序列号："+seq.toString());
	    
          this.setPkSeq(seq.toString());	  
          this.setMaxSeq(i);
		return "add";
	}
	
	//1)查询员工列表
	public String list() throws Exception{
		log.info("=======查询员工列表========");
		

    	if(page==null) {
			page = new Page(1,Constants.PAGESIZE);
		}
			page.setRscount(employeeService.recordCount());
			page.setList(employeeService.list(bean, page.getCurrentpage(), page.getPagesize()));
			System.out.println(page.getRscount()+"============");
			bean=null;//防止表单回填
		return  "list";
	}
	
	//2)添加员工，然后跳转到员工列表页面
	public String addOrUpdate() throws Exception{
		log.info("=======添加员工========");
		employeeService.addOrUpdate(bean);
		bean=null;//防止表单回填
		return "toList";
	}
	
	//3)修改前，获取到的员工信息
	public String beforeUpdate() throws Exception{
		log.info("=======修改前，获取到的员工信息========");
		bean=employeeService.beforeUpdate(bean);
		return "update";
	}
	
	//4)修改密码
	public String update() throws Exception{
		log.info("=======修改密码========");
		log.info("旧密码："+oldpasswd);
		log.info("session中的密码："+request.getSession().getAttribute("passwd"));
		
		if(oldpasswd.equals(request.getSession().getAttribute("passwd"))){
			log.info("======旧密码正确========");
			log.info("======新密码：========"+bean.getPasswd());
			String id=(String) request.getSession().getAttribute("id");
			 bean.setEmpId(id);
			 employeeService.modifyPasswd(bean);
			request.setAttribute("msg", "修改成功！");
			request.getSession().setAttribute("passwd", bean.getPasswd());
			return "modifyPasswd";
		
		}else{
			
			request.setAttribute("msg", "旧密码有误！");
			return  "modifyPasswd";
		}
		
		
		
	}
	//5)员工明细
	public String detail() throws Exception{
		log.info("=======员工明细========");
		bean=employeeService.detail(bean);
		return "detail";
	}
	//5)用户明细
	public String userDetail() throws Exception{
		log.info("=======用户明细========");
		log.info("=======用户ID======="+bean.getEmpId());
		bean=employeeService.detail(bean);
		return "userDetail";
	}
	
	
	//删除员工
	public String delete() throws Exception{
		log.info("=======删除员工========");
		employeeService.delete(bean);
		return "del";
	}

	
	//=================setter()/getter()===================
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getBean() {
		return bean;
	}

	public void setBean(Employee bean) {
		this.bean = bean;
	}

	public String getPkSeq() {
		return pkSeq;
	}

	public void setPkSeq(String pkSeq) {
		this.pkSeq = pkSeq;
	}

	public int getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(int maxSeq) {
		this.maxSeq = maxSeq;
	}

	public String getOldpasswd() {
		return oldpasswd;
	}

	public void setOldpasswd(String oldpasswd) {
		this.oldpasswd = oldpasswd;
	}

}
