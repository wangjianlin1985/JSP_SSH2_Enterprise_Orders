package com.zmb.pk.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 分页标签的可执行程序
 * 
 * @author jn0906c
 * 
 */
public class PageTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private int rscount;// 总记录数

	private int currentpage;// 当前页

	private String action;// 提交action

	private String className = BBSTEXT;// 样式

	private int pagesize = Constants.PAGESIZE;// 每页记录

	private int pagecount;// 总页数

	/** **************样式常量******************** */
	public static final String TEXT = "text";

	public static final String IMAGE = "image";

	public static final String BBSTEXT = "bbstext";

	public static final String BBSIMAGE = "bbsimage";

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getRscount() {
		return rscount;
	}

	public void setRscount(int rscount) {
		this.rscount = rscount;
		try {
			this.pagecount = ((this.rscount - 1) / this.pagesize) + 1;
		} catch (Exception ex) {
			this.pagecount = 0;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO 自动生成方法存根
		String pagetool = pagetool(className);
		JspWriter out = pageContext.getOut();
		try {
			out.write(pagetool);
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	/**
	 * 分页工具条
	 * 
	 * @param fileName
	 *            String
	 * @return String
	 */
	public String pagetool(String flag) {
		StringBuffer str = new StringBuffer();
		String url = this.getParamUrl();
		int ProPage = this.currentpage - 1;
		int Nextpage = this.currentpage + 1;
		// 文字的分页
		if (flag.equals(TEXT)) {
			str.append("<form method='post' name='pageform' action=''>");
			str
					.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' class='pgToolbar'>");
			str.append("<tr>");
			str.append("<td height='20px'>");
			str.append("共有记录" + this.rscount + "条&nbsp;&nbsp;&nbsp;");
			str.append("共" + this.pagecount + "页&nbsp;&nbsp;&nbsp;");
			str.append("每页" + this.pagesize + "记录&nbsp;&nbsp;&nbsp;");
			str.append("现在" + this.currentpage + "/" + this.pagecount + "页");
			str.append("</td><td style='text-align: right;'>");
			if (this.currentpage > 1) {
				str.append("<a href='" + url + "&page.currentpage=1'>首页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
				str.append("<a href='" + url + "&page.currentpage=" + ProPage
						+ "'>上一页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
			} else {
				str.append("首页");
				str.append("&nbsp;&nbsp;&nbsp;");
				str.append("上一页");
				str.append("&nbsp;&nbsp;&nbsp;");
			}
			if (this.currentpage < this.pagecount) {
				str.append("<a href='" + url + "&page.currentpage=" + Nextpage
						+ "'>下一页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
			} else {
				str.append("下一页");
				str.append("&nbsp;&nbsp;&nbsp;");
			}
			if (this.pagecount > 1 && this.currentpage != this.pagecount) {
				str.append("<a href='" + url + "&page.currentpage=" + pagecount
						+ "'>尾页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
			} else {
				str.append("尾页");
				str.append("&nbsp;&nbsp;&nbsp;");
			}
			str.append("转到");
			str
					.append("<select name='page.currentpage' onchange='javascript:ChangePage(this.value);'>");
			for (int j = 1; j <= pagecount; j++) {
				str.append("<option value='" + j + "'");
				if (currentpage == j) {
					str.append("selected");
				}
				str.append(">");
				str.append("" + j + "");
				str.append("</option>");
			}
			str.append("</select>页");
			str.append("</td><td width='3%'>&nbsp;</td></tr></table>");
			str.append("<script language='javascript'>");
			str.append("function ChangePage(testpage){");
			str.append("document.pageform.action='" + url
					+ "&page.currentpage='+testpage+'';");
			str.append("window.location=document.pageform.action;");
			str.append("}");
			str.append("</script>");
			str.append("</form>");
		} else if (flag.equals(IMAGE)) {
			/**
			 * 图片的分页
			 */

		} else if (flag.equals(BBSTEXT)) {
			/**
			 * 论坛形式的分页[直接以数字方式体现]
			 */
			str
					.append("<table width='100%' border='0' cellspacing='0' cellpadding='0' style='font-size: 13px;'>");
			str.append("<tr>");
			str.append("<td height='12'>");
			str.append("记录" + this.rscount + "条&nbsp;&nbsp;");
			str.append("共" + this.pagecount + "页&nbsp;&nbsp;");
			str.append("每页" + this.pagesize + "记录&nbsp;&nbsp;");
			str.append("现在" + this.currentpage + "/" + this.pagecount + "页");
			str.append("</td><td>");
			// 设定是否有首页的链接
			if (this.currentpage > 1) {
				str.append("<a href='" + url + "&page.currentpage=1'>首页</a>");
				str.append("&nbsp;&nbsp;");
			}
			// 设定是否有上一页的链接
			if (this.currentpage > 1) {
				str.append("<a href='" + url + "&page.currentpage=" + ProPage
						+ "'>上一页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
			}
			// 如果总页数只有10的话
			if (this.pagecount <= 10) {
				for (int i = 1; i <= this.pagecount; i++) {
					if (this.currentpage == i) {
						str.append("<font color=red>[" + i
								+ "]</font>&nbsp;&nbsp;");
					} else {
						str.append("<a href='" + url + "&page.currentpage=" + i
								+ "'>" + i + "</a>&nbsp;&nbsp;");
					}
				}
			} else {
				// 说明总数有超过10页
				// 制定特环的开始页和结束页

				int endPage = this.currentpage + 4;
				if (endPage > this.pagecount) {
					endPage = this.pagecount;
				}
				int startPage = 0;
				if (this.pagecount >= 8 && this.currentpage >= 8) {
					startPage = this.currentpage - 5;
				} else {
					// 表示从第一页开始算
					startPage = 1;
				}
				System.out.println(startPage);
				System.out.println(endPage);
				for (int i = startPage; i <= endPage; i++) {
					if (this.currentpage == i) {
						str.append("<font color=red>[" + i
								+ "]</font>&nbsp;&nbsp;");
					} else {
						str.append("<a href='" + url + "&page.currentpage=" + i
								+ "'>" + i + "</a>&nbsp;&nbsp;");
					}
				}
			}
			// 设定是否有下一页的链接
			if (this.currentpage < this.pagecount) {
				str.append("<a href='" + url + "&page.currentpage=" + Nextpage
						+ "'>下一页</a>");
				str.append("&nbsp;&nbsp;");
			}
			// 设定是否有尾页的链接
			if (this.pagecount > 1 && this.currentpage != this.pagecount) {
				str.append("<a href='" + url + "&page.currentpage=" + pagecount
						+ "'>尾页</a>");
				str.append("&nbsp;&nbsp;");
			}

			str.append("</td><td width='3%'>&nbsp;</td></tr></table>");
		} else if (flag.equals(BBSIMAGE)) {
			/**
			 * 论坛形式的分页[以图片的方式体现]
			 */
			// 设定分页显示的CSS
			str.append("<style>");
			str
					.append("BODY {FONT-SIZE: 12px;FONT-FAMILY:宋体;WIDTH: 60%; PADDING-LEFT: 25px;}");
			str
					.append("DIV.meneame {PADDING-RIGHT: 3px; PADDING-LEFT: 3px; FONT-SIZE: 80%; PADDING-BOTTOM: 3px; MARGIN: 3px; COLOR: #ff6500; PADDING-TOP: 3px; TEXT-ALIGN: center}");
			str
					.append("DIV.meneame A {BORDER-RIGHT: #ff9600 1px solid; PADDING-RIGHT: 7px; BACKGROUND-POSITION: 50% bottom; BORDER-TOP: #ff9600 1px solid; PADDING-LEFT: 7px; BACKGROUND-IMAGE: url('"
							+ ((HttpServletRequest) this.pageContext
									.getRequest()).getContextPath()
							+ "/meneame.jpg'); PADDING-BOTTOM: 5px; BORDER-LEFT: #ff9600 1px solid; COLOR: #ff6500; MARGIN-RIGHT: 3px; PADDING-TOP: 5px; BORDER-BOTTOM: #ff9600 1px solid; TEXT-DECORATION: none}");
			str
					.append("DIV.meneame A:hover {BORDER-RIGHT: #ff9600 1px solid; BORDER-TOP: #ff9600 1px solid; BACKGROUND-IMAGE: none; BORDER-LEFT: #ff9600 1px solid; COLOR: #ff6500; BORDER-BOTTOM: #ff9600 1px solid; BACKGROUND-COLOR: #ffc794}");
			str
					.append("DIV.meneame SPAN.current {BORDER-RIGHT: #ff6500 1px solid; PADDING-RIGHT: 7px; BORDER-TOP: #ff6500 1px solid; PADDING-LEFT: 7px; FONT-WEIGHT: bold; PADDING-BOTTOM: 5px; BORDER-LEFT: #ff6500 1px solid; COLOR: #ff6500; MARGIN-RIGHT: 3px; PADDING-TOP: 5px; BORDER-BOTTOM: #ff6500 1px solid; BACKGROUND-COLOR: #ffbe94}");
			str
					.append("DIV.meneame SPAN.disabled {BORDER-RIGHT: #ffe3c6 1px solid; PADDING-RIGHT: 7px; BORDER-TOP: #ffe3c6 1px solid; PADDING-LEFT: 7px; PADDING-BOTTOM: 5px; BORDER-LEFT: #ffe3c6 1px solid; COLOR: #ffe3c6; MARGIN-RIGHT: 3px; PADDING-TOP: 5px; BORDER-BOTTOM: #ffe3c6 1px solid}");
			str.append("</style>");
			str.append("<div class=\"meneame\">");
			// 判定是否有上一页
			if (this.currentpage > 1) {
				str.append("<a href='" + url
						+ "&page.currentpage=1' hidefocus=\"true\">首页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
				str.append("<a href='" + url + "&page.currentpage=" + ProPage
						+ "' hidefocus=\"true\">上一页</a>");
				str.append("&nbsp;&nbsp;&nbsp;");
			} else {
				str.append("<span class=\"disabled\">首页</span>");
				str.append("&nbsp;&nbsp;");
				str.append("<span class=\"disabled\">上一页</span>");
				str.append("&nbsp;&nbsp;");
			}
			// 显示中间的图片
			if (this.pagecount <= 10) {
				for (int i = 1; i <= this.pagecount; i++) {
					if (this.currentpage == i) {
						str.append("<span class=\"current\">" + i + "</span>");
					} else {
						str.append("<a href='" + url + "&page.currentpage=" + i
								+ "' hidefocus=\"true\">" + i
								+ "</a>&nbsp;&nbsp;");
					}
				}
			} else {
				// 说明总数有超过10页
				// 制定特环的开始页和结束页
				int endPage = this.currentpage + 4;
				if (endPage > this.pagecount) {
					endPage = this.pagecount;
				}
				int startPage = 0;
				if (this.pagecount >= 8 && this.currentpage >= 8) {
					startPage = this.currentpage - 5;
				} else {
					// 表示从第一页开始算
					startPage = 1;
				}
				System.out.println(startPage);
				System.out.println(endPage);
				for (int i = startPage; i <= endPage; i++) {
					if (this.currentpage == i) {
						str.append("<span class=\"current\">" + i + "</span>");
					} else {
						str.append("<a href='" + url + "&page.currentpage=" + i
								+ "' hidefocus=\"true\">" + i
								+ "</a>&nbsp;&nbsp;");
					}
				}
			}

			// 判断下一页和尾页
			if (this.currentpage < this.pagecount) {
				if (this.currentpage < this.pagecount - 10) {
					str.append("...");
					str.append("<a href='" + url + "&page.currentpage="
							+ (this.pagecount - 1) + "' hidefocus=\"true\">"
							+ (this.pagecount - 1) + "</a>&nbsp;&nbsp;");
					str.append("<a href='" + url + "&page.currentpage="
							+ this.pagecount + "' hidefocus=\"true\">"
							+ this.pagecount + "</a>&nbsp;&nbsp;");
				}

				str.append("<a href='" + url + "&page.currentpage=" + Nextpage
						+ "' hidefocus=\"true\">下一页</a>");
				str.append("&nbsp;&nbsp;");
			} else {
				str.append("<span class=\"disabled\">下一页</span>");
				str.append("&nbsp;&nbsp;");
			}
			if (this.pagecount > 1 && this.currentpage != this.pagecount) {
				str.append("<a href='" + url + "&page.currentpage=" + pagecount
						+ "' hidefocus=\"true\">尾页</a>");
				str.append("&nbsp;&nbsp;");
			} else {
				str.append("<span class=\"disabled\">尾页</span>");
				str.append("&nbsp;&nbsp;");
			}
			str.append("</div>");
		}
		return str.toString();
	}

	public String getParamUrl() {
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String url = request.getContextPath() + action;
		if (url.indexOf("?") == -1) {
			url = url + "?";
		}
		String totalParams = "";
		Enumeration params = request.getParameterNames();// 得到所有参数名
		while (params.hasMoreElements()) {
			String tempName = params.nextElement().toString();
			String tempValue = request.getParameter(tempName);
			if (tempValue != null && !tempValue.equals("")
					&& !tempName.equals("page.currentpage")) {
				if (totalParams.equals("")) {

					totalParams = totalParams + tempName + "=" + tempValue;
				} else {
					totalParams = totalParams + "&" + tempName + "="
							+ tempValue;
				}
			}
		}
		String totalUrl = url + totalParams;
		return totalUrl;
	}

}