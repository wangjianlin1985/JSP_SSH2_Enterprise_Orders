<%@ page language="java" import="java.util.*" errorPage="/error.jsp" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/pageTag.tld"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <link rel="stylesheet" type="text/css" media="screen" href="<%=path%>/css/list.css" />
	<script src="<%=path%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=path%>/js/jquery.validate.js" type="text/javascript"></script>
	<script src="<%=path%>/js/function.js"  type="text/javascript"></script>
	<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
<script id="demo" type="text/javascript"> 
$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
		rules: {
			'bean.carCard': "required",
			'bean.carState': "required",
			
			password: {
				required: true,
				minlength: 5
			},
		
			dateformat: "required",
			terms: "required"
		},
		messages: {
			'bean.carCard': "必填项",
			'bean.carState': "必填项",
			
			
			
			dateformat: "Choose your preferred dateformat",
			terms: " "
		},
		// the errorPlacement has to take the table layout into account
		errorPlacement: function(error, element) {
			if ( element.is(":radio") )
				error.appendTo( element.parent().next().next() );
			else if ( element.is(":checkbox") )
				error.appendTo ( element.next() );
			else
				error.appendTo( element.parent() );
		},
		// specifying a submitHandler prevents the default submit, good for the demo
		submitHandler: function() {
    	var form=document.getElementById("signupform");
	       form.submit();
			},
		// set this class to error-labels to indicate valid fields
		success: function(label) {
			// set &nbsp; as text for IE
			label.html("&nbsp;").addClass("checked");
		}
	});
	
	// propose username by combining first- and lastname
	$("#username").focus(function() {
		var firstname = $("#firstname").val();
		var lastname = $("#lastname").val();
		if(firstname && lastname && !this.value) {
			this.value = firstname + "." + lastname;
		}
	});
 
});
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：用户信息</td>
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
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
        	<tr>
			<td class="td_label" >员工编号：</td>
			<td class="td_display" colspan="3"><s:property value="bean.empId"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">员工类别：</td>
			<td class="td_display" ><s:property value="bean.type"/>&nbsp;</td>
			<td class="td_label">姓名：</td>
			<td class="td_display"><s:property value="bean.name"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">密码：</td>
			<td class="td_display" ><s:property value="bean.passwd"/>&nbsp;</td>
			<td class="td_label">联系电话：</td>
			<td class="td_display"><s:property value="bean.telephone"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">是否在职：</td>
			<td class="td_display" ><s:property value="bean.ifDuty"/>&nbsp;</td>
			<td class="td_label">出生日期：</td>
			<td class="td_display"><s:property value="bean.birthday"/>&nbsp;</td>
		</tr>
			<tr>
			<td class="td_label">账号状态：</td>
			<td class="td_display" ><s:property value="bean.status"/>&nbsp;</td>
			<td class="td_label">员工角色：</td>
			<td class="td_display"><s:property value="bean.role"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">性别：</td>
			<td class="td_display" ><s:property value="bean.sex"/>&nbsp;</td>
			<td class="td_label">家庭地址：</td>
			<td class="td_display"><s:property value="bean.address"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">入职年月：</td>
			<td class="td_display" ><s:property value="bean.empDate"/>&nbsp;</td>
			<td class="td_label">文化程度：</td>
			<td class="td_display"><s:property value="bean.education"/>&nbsp;</td>
		</tr>
		<tr>
			<td class="td_label">最后修改时间：</td>
			<td class="td_display" ><s:property value="bean.lastModify"/>&nbsp;</td>
			<td class="td_label">备注：</td>
			<td class="td_display"><s:property value="bean.remarks"/>&nbsp;</td>
		</tr>
        </table></td>
        <td width="8" background="<%=path%>/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
   </tr>
  <tr>
   <td height="35" background="<%=path %>/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=path %>/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;</td>
            <td></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=path %>/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
</table>
</td>
</tr>
</table>

</body>
</html>
