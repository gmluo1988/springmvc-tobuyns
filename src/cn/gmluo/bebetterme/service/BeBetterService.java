package cn.gmluo.bebetterme.service;

import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.util.PageBean;

/**
 * 3.业务逻辑层
 * 3.1-service接口设计
 * Created by gmluo on 2018/4/9.
 */
public interface BeBetterService {
    /**
     * 添加每日报告方法
     * @param beBetter
     */
    public void saveReport(BeBetter beBetter);

    /**
     * 根据Id查询每日报告方法
     * @param id
     * @return
     */
    public BeBetter findById(int id);

    /**
     * 修改每日报告方法
     * @param beBetter
     */
    public void uadateReport(BeBetter beBetter);

    /**
     * 按ID删除报告方法
     * @param id
     */
    public void deleteReport(int id);

    /**
     * 分页查询所有报告方法
     * @param pageBean
     */
    public void getAllReports(PageBean<BeBetter> pageBean);

}
