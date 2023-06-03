<%@ page language="java" import="java.util.*" errorPage="/error.jsp" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/pageTag.tld"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>订单定制</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <link rel="stylesheet" type="text/css" media="screen" href="<%=path%>/css/list.css" />
	<script src="<%=path%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=path%>/js/jquery.validate.js" type="text/javascript"></script>
	<script src="<%=path%>/js/order_ajax.js"  type="text/javascript"></script>
	<script src="<%=path%>/js/common.js"  type="text/javascript"></script>
	<script src="<%=path%>/js/My97DatePicker/WdatePicker.js"  type="text/javascript"></script>
<script id="demo" type="text/javascript"> 
$(document).ready(function() {
	var validator = $("#signupform").validate({
	
		submitHandler: function() {
    	var form=document.getElementById("signupform");
	       form.submit();
			},
		success: function(label) {
			label.html("&nbsp;").addClass("checked");
		}
	});
});
function close_win()
{
 parent.window.close();

}
</script>
</head>

<body>
<s:form action="emp_update.action" method="post" id="signupform">
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：修改密码</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
              
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
			<td style="background-color: #fff;font-size: 13px;font-weight: bold;text-align: right;" width="40%">旧密码：</td>
			<td class="td_display" ><s:password  name="oldpasswd" size="30" id="oldpasswd"></s:password>
			<font color="#FF0000">&nbsp;*</font></td>
		</tr>
		<tr>
			<td class="td_label">请输入新密码：</td>
			<td class="td_display" ><s:password  name="bean.passwd" size="30" id="passwd"/><font color="#FF0000">&nbsp;*</font></td>
			
		</tr>
		<tr>
			<td class="td_label">请重复新密码：</td>
			<td class="td_display" ><s:password  name="repasswd" size="30"  id="repasswd"/><font color="#FF0000">&nbsp;*</font>&nbsp;&nbsp;&nbsp;
			 <s:property value="#request.msg"/>
			 </td>
		</tr>
		  <tr><td colspan="4" height="40" rowspan="4" style="background-color:#fff;border-style: none;text-align: center;"><s:submit value="修改"/>     <s:reset value="清除" />    </td></tr>
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


</s:form>
</body>
</html>
