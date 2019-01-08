package com.zqq.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfo<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3451543425903380562L;

	 //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    
    
    
	public int getPageNum() {
		return pageNum;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



	public long getTotal() {
		return total;
	}



	public void setTotal(long total) {
		this.total = total;
	}



	public int getPages() {
		return pages;
	}



	public void setPages(int pages) {
		this.pages = pages;
	}



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
	}



	public boolean isFirstPage() {
		return isFirstPage;
	}



	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}



	public boolean isLastPage() {
		return isLastPage;
	}



	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}



	public PageInfo(List<T> list) {
		if (list instanceof Page) {
			Page page=(Page)list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPages();
			this.total = page.getTotal();
			this.pages = page.getPages();
			this.list = page;
		}else if(list instanceof Collection){
			this.pageNum=1;
			this.pageSize=list.size();
			this.pages=1;
			this.list=list;
			this.total=list.size();
		}
		if (list instanceof Collection) {
			//判断页面边界
			judgePageBoudary();
		}

	}
    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }


	public PageInfo() {
		
	}

	  @Override
	    public String toString() {
	        final StringBuffer sb = new StringBuffer("PageInfo{");
	        sb.append("pageNum=").append(pageNum);
	        sb.append(", pageSize=").append(pageSize);
	        sb.append(", total=").append(total);
	        sb.append(", pages=").append(pages);
	        sb.append(", list=").append(list);
	        sb.append(", isFirstPage=").append(isFirstPage);
	        sb.append(", isLastPage=").append(isLastPage);
	        sb.append(", navigatepageNums=");
	        sb.append('}');
	        return sb.toString();
	    }

    
}
