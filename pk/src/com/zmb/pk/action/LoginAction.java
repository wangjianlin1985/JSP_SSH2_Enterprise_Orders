package com.zmb.pk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zmb.pk.model.Employee;
import com.zmb.pk.service.LoginService;

public class LoginAction extends ActionSupport  {
	
	private Employee bean;
	private LoginService loginService;
	Logger  log=Logger.getLogger(LoginAction.class);
	HttpServletRequest request = ServletActionContext.getRequest();
	//登录
	public String login() throws Exception{
		log.info("===========登录===========");
//		log.info("userName:"+bean.getEmpId());
//		log.info("userPwd:"+bean.getPasswd());
		Employee emp = loginService.login(bean);
		if (emp == null) {
			log.info("======用户名不存在======");
			request.setAttribute("errorMsg", "密码不正确！");
			return "login";
		} else {
			request.getSession().setAttribute("id",emp.getEmpId());
			request.getSession().setAttribute("name",emp.getName());
			request.getSession().setAttribute("role",emp.getRole());
			request.getSession().setAttribute("passwd",emp.getPasswd());
		
			return "index";
		}
		
	}
	
	//登出
	public String logout()throws Exception{
		request.getSession().removeAttribute("id");
		request.getSession().removeAttribute("name");
		
		return "login";
		
	}
	
	//================setter/getter=============
	public Employee getBean() {
		return bean;
	}

	public void setBean(Employee bean) {
		this.bean = bean;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}




}
