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
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
*{font:9pt ���� #000;padding:0px;margin:0;}
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
	menuList=$("menuList");//��õ�����
	relist(menuList);//Ϊ���в˵���ʼ��
	showList=getCookie("showList").split("|");//����ϴα��������
	if(showList.length>0)reShowList(menuList);//չ���ϴα���Ĳ˵�
	
}
//����ÿ��Ԫ��,��Ϊÿ��Ԫ������һ������menuID
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

//����ÿ��Ԫ�ز�����չ�����
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

//չ��ĳID
function showToList(mID){
	if(mID){
		for(var i=0;i<showList.length;i++){
			if(showList[i]==mID)return null;
		}
		showList[i]=mID;
	}
}
//�ر�ĳID
function hiddenToList(mID){
	if(mID){
		for(var i=0;i<showList.length;i++){
			if(showList[i]==mID)showList[i]="";
		}
	}
}

//�˳�����˵�����
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
                <td width="42%"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">����˵�</font></td>
                <td width="18%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#e5f4fd"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td valign="top">
                <div align="center" id="menuList" style="text-align:left;height:100%;width:168px;overflow:auto;padding-left:5px;">
					
					<s:if test="'����Ա'==#session.role||'��ͨ�û�'==#session.role">
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">��������</div>
						<div class="itemChilds">
								<div class="itemNode">&gt;&gt;<a href="order_init.action" target="contentFrame">��������</a></div>
							<div class="itemNode">&gt;&gt;<a href="order_list.action" target="contentFrame">�������</a></div>
							
						</div>
					</div></s:if>
					<s:if test="'����Ա'==#session.role||'��ͨ�û�'==#session.role">
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">���͹���</div>
						<div class="itemChilds">
							<div class="itemNode">&gt;&gt;<a href="order_dispatchList.action" target="contentFrame">���͵���</a></div>
							<div class="itemNode">&gt;&gt;<a href="order_over.action" target="contentFrame">�������ٲ�ѯ</a></div>
						</div>
					</div>
					</s:if>
				
				<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">��������</div>
						<div class="itemChilds">
						<s:if test="'����Ա'==#session.role">
							<div class="itemNode">&gt;&gt;<a href="car_init.action" target="contentFrame">��ӳ���</a></div>
						</s:if>
							<div class="itemNode">&gt;&gt;<a href="car_list.action" target="contentFrame">�����б�</a></div>
						</div>
					</div>
						
					<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">�Ʒѹ���</div>
						<div class="itemChilds">
							
							<div class="itemNode">&gt;&gt;<a href="fee_list.action" target="contentFrame">�Ʒ��б�</a></div>
						</div>
					</div>
					
					<s:if test="'����Ա'==#session.role">
				<div class="item">
						<div class="itemTitle" onmousedown="titleOnmouseDown(this)">Ա������</div>
						<div class="itemChilds">
							<div class="itemNode">&gt;&gt;<a href="emp_init.action" target="contentFrame">���Ա��</a></div>
							<div class="itemNode">&gt;&gt;<a href="emp_list.action" target="contentFrame">Ա���б�</a></div>
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
