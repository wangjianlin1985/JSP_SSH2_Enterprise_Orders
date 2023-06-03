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
  		<script src="<%=path%>/js/jquery.js" type="text/javascript"></script>
	<script src="<%=path%>/js/jquery.validate.js" type="text/javascript"></script>
  <script src="<%=path%>/js/change_color.js" type="text/javascript"></script>
<title>无标题文档</title>
<style type="text/css">

</style>

<script id="demo" type="text/javascript"> 
$(document).ready(function() {
	// validate signup form on keyup and submit
	var validator = $("#signupform").validate({
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
		 
});


</script>
  <script type="text/javascript"> 
     $(function(){
   	   $(":input").bind('focusin',function(){
   		   $(this).addClass("mousedown");
       	   });
   	  $(":input").bind('focusout',function(){
  		   $(this).removeClass("mousedown");
      	   });
          })
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
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：计费管理-计费标准列表</td>
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
        <td>
        	<s:if test="'管理员'==#session.role">
        <s:form action="fee_addOrUpdate.action" method="post"  id="signupform">
         <table width="90%" border="0" style="padding-left:220px;">
           <tr>
            
          <td  class="td_label">计费类型:</td><td class="td_input" ><s:textfield name="bean.feeType" size="30" cssClass="required" /><font color="#FF0000">&nbsp;*</font></td>
        
          <td  class="td_label">单位金额:</td><td class="td_input"><s:textfield name="bean.feeStandard" size="30" cssClass="required"/><font color="#FF0000">&nbsp;*</font></td>
          <td  style=""><s:submit value="保存"/> </td>
          
          </tr>
         </table></s:form>
         </s:if>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
         
        
          
          <tr>
            <td width="3%" height="22" background="<%=path%>/images/bg.gif" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" />
            </div></td>
            <td width="3%" class="td_title">序号</td>
             <td width="12%"class="td_title">编号</td>
            <td width="12%"class="td_title">计费类型</td>
            <td width="14%" class="td_title">单位金额</td>
            <td width="15%" class="td_title">基本操作</td>
          </tr> 				<% int i=1; %>
            	<s:if test="page.list!=null">
					<s:iterator value="page.list" id="pageList">
						<tr >
						    <td class="td_field"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
				            <td  class="td_field"><%=i++ %></td>
							 <td class="td_field" ><s:property value="feeId"/></td>
						    <td class="td_field"><s:property value="feeType"/></td>
						    <td class="td_field"><s:property value="feeStandard"/></td>
						       <s:if test="'管理员'==#session.role">
						    <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
						 
							    <img src="<%=path%>/images/edt.gif" width="16" height="16" />  <a href="fee_beforeUpdate.action?bean.feeId=<s:property value="feeId"/>">编辑</a>&nbsp; &nbsp;
							     <img src="<%=path%>/images/del.gif" width="16" height="16" /><a href="fee_delete.action?bean.feeId=<s:property value="feeId"/>">删除</a></span>
						     
						     </div>
						    </td> 
  								 </s:if>
						      <s:else>
						        <td bgcolor="#FFFFFF"><div align="center"><span class="STYLE4">
						      <font color="green">权限不足！！！</font></span> </div>
						      </td>
						      </s:else>
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
        <td><span id="pagerr" >	<page:page currentpage="${page.currentpage}" rscount="${page.rscount}" action="/fee_list.action" className="text" /></span>
        </td>
        <td width="16"><img src="<%=path%>/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
