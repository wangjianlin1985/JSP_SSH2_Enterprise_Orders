package com.zmb.pk.util;

import java.util.List;


public class Page {
	
	private int currentpage;
	
	private int pagesize;
	
	private int rscount;
	
	private List list;

	public Page() {
		super();
	}
	
	public Page(int currentpage, int pagesize) {
		super();
		this.currentpage = currentpage;
		this.pagesize = pagesize;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return Constants.PAGESIZE;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getRscount() {
		return rscount;
	}

	public void setRscount(int rscount) {
		this.rscount = rscount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
