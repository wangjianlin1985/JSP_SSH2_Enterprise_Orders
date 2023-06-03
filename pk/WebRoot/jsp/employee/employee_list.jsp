<%@ page language="java" import="java.util.*" errorPage="/error.jsp" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/pageTag.tld"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <link rel="stylesheet" type="text/css" media="screen" href="<%=path%>/css/list.css" />
  	<script src="<%=path%>/js/function.js" type="text/javascript"></script>
  <script src="<%=path%>/js/change_color.js" type="text/javascript"></script>
<title>员工列表</title>
<style type="text/css">

</style>

<script>

</script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=path%>/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=path%>/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="<%=path%>/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：员工管理-员工列表</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="td_btn">全选</td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="td_btn"><img src="<%=path%>/images/22.gif" width="14" height="14" /></td>
                    <td class="td_btn">新增</td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="td_btn"><img src="<%=path%>/images/33.gif" width="14" height="14" /></td>
                    <td class="td_btn">修改</td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="td_btn"><img src="<%=path%>/images/11.gif" width="14" height="14" /></td>
                    <td class="td_btn">删除</td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=path%>/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=path%>/images/tab_12.gif">&nbsp;</td>
        <td>
         <s:form action="emp_list.action" method="post">
         <table width="75%" border="0" style="padding-left:20px;">
           <tr>
              <td class="td_label" >查询条件：</td>
			      <td class="td_label" >员工编号：</td><td class="td_input" ><s:textfield name="bean.empId" size="15" /></td>
			      <td class="td_label">姓名：</td><td class="td_input" ><s:textfield name="bean.name" size="15" /></td>
			       <td class="td_label" >类别：</td><td class="td_input" ><s:select name="bean.type" list="{'操作员','驾驶员'}"  headerKey="" headerValue="-请选择-"/></td>
			      <td class="td_label"> 是否在职：</td><td class="td_input" ><s:select name="bean.ifDuty" list="{'是','否'}"  headerKey="" headerValue="-请选择-"/></td>
			       <td  style=""><s:submit value="查询" class="td_input" /> </td>
          
          </tr>
         </table></s:form>
        <% 
             int i=1;
         %>
        
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" />
            </div></td>
            <td width="3%" class="td_title">序号</td>
             <td width="12%"class="td_title">员工编号</td>
            <td width="12%"class="td_title">姓名</td>
            <td width="14%" class="td_title">员工类别</td>
            <td width="18%" class="td_title">联系电话</td>
            <td width="11%" class="td_title">是否在职</td>
             <td width="12%" class="td_title">当前状态</td>
            <td width="15%" class="td_title">基本操作</td>
          </tr>
            	<s:if test="page.list!=null">
					<s:iterator value="page.list" id="pageList">
						<tr >
						    <td class="td_field"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
				            <td  class="td_field"><%=i++%></td>
							 <td class="td_field" ><s:property value="empId"/></td>
						    <td class="td_field"><s:property value="name"/></td>
						    <td class="td_field"><s:property value="type"/></td>
						    <td class="td_field"><s:property value="telephone"/></td>
						    <td class="td_field"><s:property value="ifDuty"/></td>       
						    <td class="td_field"><s:property value="status"/></td>  
						    <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
						     <img src="<%=path%>/images/detail.gif" width="16" height="16" />  <span style="cursor:hand;color:#880088" onClick="openwindow('emp_detail.action?bean.empId=<s:property value="empId"/>','',800,350)">详细</span>&nbsp; &nbsp;
							    <img src="<%=path%>/images/edt.gif" width="16" height="16" />  <a href="emp_beforeUpdate.action?bean.empId=<s:property value="empId"/>">编辑</a>&nbsp; &nbsp;
							     <img src="<%=path%>/images/del.gif" width="16" height="16" />
							       <a href="#" onclick="javascript:if(confirm('是否确认删除？')){location.href='emp_delete.action?bean.empId=<s:property value="empId"/>'}">删除</a>
							</span>
						    </div>
						    </td> 
    
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<td colspan="7" style="color: red;font-size: 16px;">查无数据</td>
				</s:else>
        </table></td>
        <td width="8" background="<%=path%>/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=path%>/images/tab_19.gif">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=path%>/images/tab_18.gif" width="12" height="35" /></td>
        <td><span id="pagerr" >	<page:page currentpage="${page.currentpage}" rscount="${page.rscount}" action="/emp_list.action" className="text" /></span>
        </td>
        <td width="16"><img src="<%=path%>/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
