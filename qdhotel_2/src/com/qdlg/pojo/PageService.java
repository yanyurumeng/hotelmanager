package com.qdlg.pojo;

public class PageService {  // 分页 
	
	private int pagesize=5; // 页面记录数 
	private int pageCount=0; // 总共多少页   
	private int total = 0; // 记录总数  
	private int nowPage = 1; // 当前页码
	private int offset; // 每页的第一条记录在 总记录数中，它是第几条 (下标)
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		
		if(pagesize!=0){
			pageCount = total/pagesize; // 12/5   3页
			if(total%pagesize!=0){
				pageCount++;
			}
		}
		this.total = total;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		offset = (nowPage-1)*getPagesize();
		if(nowPage<=1){
			this.nowPage = 1;
		}
		this.nowPage = nowPage;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
