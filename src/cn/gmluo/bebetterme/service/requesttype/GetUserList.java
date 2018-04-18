package cn.gmluo.bebetterme.service.requesttype;

/**
 * Created by gmluo on 2018/4/18.
 */
public class GetUserList {
    private String userName;
    private Integer pageIndex;
    private Integer pageSize;

    @Override
    public String toString() {
        return "GetUserList{" +
                "userName='" + userName + '\'' +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
