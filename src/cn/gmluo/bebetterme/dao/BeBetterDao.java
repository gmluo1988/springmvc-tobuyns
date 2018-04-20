package cn.gmluo.bebetterme.dao;

import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.PageBean;

/**
 * 2.数据访问层（持久层）
 * 2.1-dao接口设计
 * Created by gmluo on 2018/4/9.
 */
public interface BeBetterDao {
    /**
     * 添加每日报告方法
     */
    public void saveReport(BeBetter beBetter);

    /**
     * 修改每日报告方法
     *
     * @param beBetter
     */
    public void uadateReport(BeBetter beBetter);

    /**
     * 分页查询所有报告方法
     *
     * @param pageBean
     */
    public void findAllReports(PageBean<BeBetter> pageBean);

    /**
     * 根据查询条件获取报告列表方法
     * @param pageBean
     * @param getReportList
     */
    public void getReportList(PageBean<BeBetter> pageBean, GetReportList getReportList);

    /**
     * 获取所有结果行数方法
     *
     * @return
     */
    public int getTotalCount();

    /**
     * 按ID查询每日报告方法
     *
     * @param id
     * @return
     */
    public BeBetter findById(int id);

    /**
     * 按ID删除报告方法
     *
     * @param id
     */
    public void deleteReport(int id);

    /**
     * 计算每日报告得分方法
     *
     * @param beBetter
     * @return
     */
    public int getScore(BeBetter beBetter);
}
