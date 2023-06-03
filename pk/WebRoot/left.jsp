<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%

     String contextPath = request.getContextPath();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
*{font:9pt 宋体 #000;padding:0px;margin:0;}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.item{
	width:100%;
	background:url('images/treeLine.gif') repeat-y;
}
.itemTitle{
	word-break:keep-all;
	white-space:nowrap;
	width:0px;
	padding:4px 0px 0px 35px;
	cursor:hand;
	background:url('images/title1.gif') no-repeat;
}
.itemTitleShow{
	word-break:keep-all;
	white-space:nowrap;
	width:0px;
	padding:4px 0px 0px 35px;
	cursor:hand;
	background:url('images/title2.gif') no-repeat;
}
.itemChilds{
	width:100%;
	padding:0px 0px 10px 15px;
	display:none;
}
.itemNode{
	width:100%;
	padding:4px 0px 2px 35px;
	background:url('images/item.gif') no-repeat;
}

-->
</style>
<script language="javascript" src="images/cookie.js"></script>
<script language="javascript">
function $(s){return document.getElementById(s);}
var ttonload=window.onload,menuList,showList;

window.onload=function(){
	if(ttonload)ttonload();
	menuList=$("menuList");//获得导航层
	relist(menuList);//为所有菜单初始化
	showList=getCookie("showList").split("|");//获得上次保存的数据
	if(showList.length>0)reShowList(menuList);//展开上次保存的菜单
	
}
//遍历每个元素,并为每个元素新增一个属性menuID
var mmi=0;
function relist(l){
	var e;
	for(var n=0;n<l.childNodes.length;n++){
		e=l.childNodes[n];
		if(e.childNodes.length>1)relist(e);
		e.menuID="menu"+mmi;
		mmi++;
	}
}

//遍历每个元素并设置展开与否
function reShowList(l){
	var e;
	for(var n=0;n<l.childNodes.length;n++){
		e=l.childNodes[n];
		if(e.childNodes.length>1)reShowList(e);
		for(var i=0;i<showList.length;i++){
			if(showList[i]&&showList[i]==e.menuID)titleOnmouseDown(e);
		}
	}
}
function titleOnmouseDown(obj){
	//var childs=obj.parentElement.childNodes[1]; 
	var childs = obj.nextSibling.nextSibling;
	if(childs.style.display=="block"){
		childs.style.display="none";
		obj.className="itemTitle";
		hiddenToList(obj.menuID);
	}
	else{
		childs.style.display="block";
		obj.className="itemTitleShow";
		showToList(obj.menuID);
	}
}

//展开某ID
function showToList(mID){
	if(mID){
		for(var i=0;i<showList.length;i++){
			if(showList[i]==mID)return null;
		}
		showList[i]=mID;
	}
}
//关闭某ID
function hiddenToList(mID){
	if(mID){
		for(var i=0;i<showList.length;i++){
			if(showList[i]==mID)showList[i]="";
		}
	}
}

//退出保存菜单数据
window.onbeforeunload=function(){
	var temArr=new Array();
	for(var i=0;i<showList.length;i++){
		if(showList[i]!="")temArr[temArr.length]=showList[i];
	}
	setCookie("showList",temArr.join("|"));
}

</script>
</head>

<body>
<table width="171" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"  style="table-layout:fixed;">
      <tr>
        <td style="width:3px; background:#0a5c8e;">&nbsp;</td>
        <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
          <tr>
            <td height="5" style="line-height:5px; background:#0a5c8e;">&nbsp;</td>
          </tr>
          <tr>
            <td height="23" background="images/main_29.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="40%">&nbsp;</td>
                <td width="42%"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">管理菜单</font></td>
                <td width="18%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#e5f4fd"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td valign="top">
                <div align="center" id="menuList" style="text-align:left;height:100%;width:168px;overflow:auto;padding-left:5px;">
					
					<s:if test="'管理员'==#session.role||'普通用户'==#session.role">
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">订单管理</div>
						<div class="itemChilds">
								<div class="itemNode">&gt;&gt;<a href="order_init.action" target="contentFrame">创建订单</a></div>
							<div class="itemNode">&gt;&gt;<a href="order_list.action" target="contentFrame">订单审核</a></div>
							
						</div>
					</div></s:if>
					<s:if test="'管理员'==#session.role||'普通用户'==#session.role">
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">配送管理</div>
						<div class="itemChilds">
							<div class="itemNode">&gt;&gt;<a href="order_dispatchList.action" target="contentFrame">配送调度</a></div>
							<div class="itemNode">&gt;&gt;<a href="order_over.action" target="contentFrame">订单跟踪查询</a></div>
						</div>
					</div>
					</s:if>
				
				<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">车辆管理</div>
						<div class="itemChilds">
						<s:if test="'管理员'==#session.role">
							<div class="itemNode">&gt;&gt;<a href="car_init.action" target="contentFrame">添加车辆</a></div>
						</s:if>
							<div class="itemNode">&gt;&gt;<a href="car_list.action" target="contentFrame">车辆列表</a></div>
						</div>
					</div>
						
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">计费管理</div>
						<div class="itemChilds">
							
							<div class="itemNode">&gt;&gt;<a href="fee_list.action" target="contentFrame">计费列表</a></div>
						</div>
					</div>
					
					<s:if test="'管理员'==#session.role">
				<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">员工管理</div>
						<div class="itemChilds">
							<div class="itemNode">&gt;&gt;<a href="emp_init.action" target="contentFrame">添加员工</a></div>
							<div class="itemNode">&gt;&gt;<a href="emp_list.action" target="contentFrame">员工列表</a></div>
						</div>
					</div>
					</s:if>
					
					
					
					
						</div>
                </td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="23" background="images/main_45.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="64%"><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)"> </font></div></td>
                <td width="18%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="9" style="line-height:9px; background:#0a5c8e;">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
