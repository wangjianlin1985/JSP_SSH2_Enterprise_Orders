function CalendarDlg(ctrlobj)
{
retval = window.showModalDialog("../inc/Calendar.htm", "", "dialogWidth:254px; dialogHeight:261px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );		
	if( retval != null ){
		ctrlobj.value = retval;
	}
}
function RoomDlg(ctrlobj,vtype)
{
	retval = window.showModalDialog("../main/selRoom.asp?vtype="+vtype, "", "dialogWidth:300px; dialogHeight:500px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );
	if( retval != null ){
		ctrlobj.value = retval;
	}
}
function openDlg(ctrlobj,width,height)
{
	window.showModalDialog(ctrlobj, "", "dialogWidth:"+width+"px; dialogHeight:"+height+"px; status:no; directories:yes;scrollbars:no;Resizable=no; "  );		
}


function openwindow(url,winName,width,height) 
{
xposition=0; yposition=0;
if ((parseInt(navigator.appVersion) >= 4 ))
{
xposition = (screen.width - width) / 2;
yposition = (screen.height - height) / 2;
}
theproperty= "width=" + width + "," 
+ "height=" + height + "," 
+ "location=0," 
+ "menubar=0,"
+ "resizable=1,"
+ "scrollbars=1,"
+ "status=0," 
+ "titlebar=0,"
+ "toolbar=0,"
+ "hotkeys=0,"
+ "screenx=" + xposition + "," 
+ "screeny=" + yposition + "," 
+ "left=" + xposition + "," 
+ "top=" + yposition; 
window.open( url,winName,theproperty );
}
