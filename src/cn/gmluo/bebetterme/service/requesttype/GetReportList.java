package cn.gmluo.bebetterme.service.requesttype;

import java.util.Date;

/**
 * 每日报告查询条件格式
 * Created by gmluo on 2018/4/19.
 */
public class GetReportList {
    private String date;
    private Integer pageIndex;
    private Integer pageSize;

    @Override
    public String toString() {
        return "GetReportList{" +
                "date='" + date + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
