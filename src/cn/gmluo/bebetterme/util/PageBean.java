package cn.gmluo.bebetterme.util;

import java.util.List;

/**
 * 封装分页的参数
 * Created by gmluo on 2018/4/9.
 */
public class PageBean<T> {
    private int currentPage=1;    	//当前页，默认显示第一页的数据
    private int pageCount=10;		//设置每页数据显示的
    private int totalCount;			//总结果数
    private int totalPage;			//总页数
    private List<T> pageData;		//得到每页的数据封装至List<T>中

    //计算总页数
    public int getTotalPage() {
        if (totalCount%pageCount==0) {
            totalPage=totalCount/pageCount;
        }else {
            totalPage=(totalCount/pageCount)+1;
        }
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
