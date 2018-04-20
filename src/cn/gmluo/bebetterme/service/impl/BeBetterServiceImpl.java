package cn.gmluo.bebetterme.service.impl;

import cn.gmluo.bebetterme.dao.BeBetterDao;
import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.service.BeBetterService;
import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 3.业务逻辑层
 * 3.2-service接口实现类
 * Created by gmluo on 2018/4/9.
 */
@Service("beBetterServiceImpl")
public class BeBetterServiceImpl implements BeBetterService {
    @Resource(name = "beBetterDaoImpl")
    private BeBetterDao beBetterDao;

    /**
     * 添加每日报告方法实现
     *
     * @param beBetter
     */
    @Override
    public void saveReport(BeBetter beBetter) {
        beBetterDao.saveReport(beBetter);

    }

    /**
     * 根据Id查询每日报告方法实现
     *
     * @param id
     * @return
     */
    @Override
    public BeBetter findById(int id) {
        return beBetterDao.findById(id);
    }

    /**
     * 修改每日报告方法实现
     *
     * @param beBetter
     */
    @Override
    public void uadateReport(BeBetter beBetter) {
        beBetterDao.uadateReport(beBetter);

    }

    /**
     * 按ID删除报告方法实现
     *
     * @param id
     */
    @Override
    public void deleteReport(int id) {
        beBetterDao.deleteReport(id);

    }

    /**
     * 根据ID批量删除报告方法
     * @param idList
     */
    @Override
    public void batchDeleteReportById(DeleteIdList idList) {
        for (Integer id : idList.getIdList()) {
            beBetterDao.deleteReport(id);
        }
    }

    /**
     * 分页查询所有报告方法实现
     *
     * @param pageBean
     */
    @Override
    public void getAllReports(PageBean<BeBetter> pageBean) {
        beBetterDao.findAllReports(pageBean);

    }

    /**
     * 根据查询条件获取报告列表方法实现
     *
     * @param pageBean
     * @param getReportList
     */
    @Override
    public void getReportList(PageBean<BeBetter> pageBean, GetReportList getReportList) {
        beBetterDao.getReportList(pageBean, getReportList);
    }
}
