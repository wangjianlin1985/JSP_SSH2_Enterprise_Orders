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
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function fresh(){
window.parent.frames['mainFrame'].location.reload();
}
function logout(){
 window.parent.location.href="<%=path%>/user_logout.action";	
}
//-->
</script>
</head>
<% 
   String id=(String)session.getAttribute("id");
   String name=(String)session.getAttribute("name");
   String role=(String)session.getAttribute("role");
         %>
<body onload="MM_preloadImages('images/main_07_1.gif','images/main_08_1.gif','images/main_10_1.gif','images/main_11_1.gif','images/main_12_1.gif','images/main_13_1.gif','images/main_14_1.gif')">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="57" background="images/main_02.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="110" height="57" background="images/main_01.gif">&nbsp;</td>
        <td><table width="743" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="28" background="images/main_03.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="61" height="29" background="images/main_06.gif">&nbsp;</td>
                <td width="72"><a href="<%=path%>/jsp/user/modify_passwd.jsp" target="contentFrame"><img src="images/main_07.gif" name="Image1" width="72" height="29" border="0" id="Image1" onmouseover="MM_swapImage('Image1','','images/main_07_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="72"><a href="emp_userDetail.action?bean.empId=<%=id%>" target="contentFrame"><img src="images/main_08.gif" name="Image2" width="72" height="29" border="0" id="Image2" onmouseover="MM_swapImage('Image2','','images/main_08_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="292" background="images/main_09.jpg">&nbsp;</td>
                <td width="40"><a href="#"><img src="images/main_10.gif" name="Image3" width="40" height="29" border="0" id="Image3" onmouseover="MM_swapImage('Image3','','images/main_10_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="#" onclick="history(-1);"><img src="images/main_11.gif" name="Image4" width="44" height="29" border="0" id="Image4" onmouseover="MM_swapImage('Image4','','images/main_11_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="43"><a href="#"  onclick="history(1);"><img src="images/main_12.gif" name="Image5" width="43" height="29" border="0" id="Image5" onmouseover="MM_swapImage('Image5','','images/main_12_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="44"><a href="#" onclick="fresh()"><img src="images/main_13.gif" name="Image6" width="44" height="29" border="0" id="Image6" onmouseover="MM_swapImage('Image6','','images/main_13_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="39"><a href="#" onclick="logout()"><img src="images/main_14.gif" name="Image7" width="39" height="29" border="0" id="Image7" onmouseover="MM_swapImage('Image7','','images/main_14_1.gif',1)" onmouseout="MM_swapImgRestore()" /></a></td>
                <td width="36"><img src="images/main_15.gif" width="36" height="29" /></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="102" background="images/main_05.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="26" background="images/main_18.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" height="26" background="images/main_16.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="76" height="23" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" style="background:url(images/topbg.gif); border:solid 1px #a6d0e7; font-size:12px; color:#2b7dbb;"><div align="center"><img src="images/001.gif" width="10" height="10" />系统管理</div></td>
              </tr>
            </table></td>
            <td width="76" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" style="background:url(images/topbg.gif); border:solid 1px #a6d0e7;font-size:12px; color:#2b7dbb;"><div align="center"><img src="images/002.gif" width="10" height="10" />方法管理</div></td>
              </tr>
            </table></td>
            <td width="76" valign="bottom"><table width="74" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="18" style="background:url(images/topbg.gif); border:solid 1px #a6d0e7;font-size:12px; color:#2b7dbb;"><div align="center"><img src="images/003.gif" width="10" height="10" />用户管理</div></td>
              </tr>
            </table></td>
            <td valign="bottom">&nbsp;</td>
          </tr>
        </table></td>
        <td width="200"><img src="images/user.gif" width="10" height="10" /> <span class="STYLE1">欢迎您:&nbsp;&nbsp;<b> <%=name%> </b> &nbsp;&nbsp;  角色:&nbsp; <%=role%></span></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
