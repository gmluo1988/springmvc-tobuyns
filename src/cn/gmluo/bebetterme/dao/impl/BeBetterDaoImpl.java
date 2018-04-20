package cn.gmluo.bebetterme.dao.impl;

import cn.gmluo.bebetterme.dao.BeBetterDao;
import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.service.requesttype.GetReportList;
import cn.gmluo.bebetterme.util.GetBeBetterScore;
import cn.gmluo.bebetterme.util.NowTime;
import cn.gmluo.bebetterme.util.PageBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 2.数据访问层（持久层）
 * 2.1-dao接口方法实现类
 * Created by gmluo on 2018/4/9.
 */
@Repository("beBetterDaoImpl")
public class BeBetterDaoImpl implements BeBetterDao {
    //IOC容器注入对象jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private NowTime nowTime = new NowTime();

    /**
     * 添加每日报告方法实现
     *
     * @param beBetter
     */
    @Override
    public void saveReport(BeBetter beBetter) {
        String sql = "INSERT INTO bebetter ("
                + "Cola, Fattyfood, Snacks, Badword, Complain, Stayuplate,"
                + " Readbook, Learnskills, Developskills, "
                + "Running, Keep, " + "Breakfast, Lunch, Otherfood, "
                + "Score,DataChange_CreateTime,DataChange_LastTime"
                + ")VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql,
                beBetter.getCola(), beBetter.getFattyfood(), beBetter.getSnacks(),
                beBetter.getBadword(), beBetter.getComplain(), beBetter.getStayuplate(),
                beBetter.getReadbook(), beBetter.getLearnskills(), beBetter.getDevelopskills(),
                beBetter.getRunning(), beBetter.getKeep(),
                beBetter.getBreakfast(), beBetter.getLunch(), beBetter.getOtherfood(),
                this.getScore(beBetter),
                nowTime.getNowTime(), nowTime.getNowTime());
//                this.todayDate(), this.todayDate());

    }

    /**
     * 修改每日报告方法实现
     *
     * @param beBetter
     */
    @Override
    public void uadateReport(BeBetter beBetter) {
        String sql = "UPDATE bebetter "
                + "SET Cola=?,Fattyfood=?, Snacks=?, Badword=?, Complain=?, Stayuplate=?,"
                + "Readbook=?, Learnskills=?, Developskills=?,"
                + " Running=?, Keep=?,"
                + " Breakfast=?, Lunch=?, Otherfood=?, "
                + "Score=? ,DataChange_LastTime=? WHERE id=?;";
        jdbcTemplate.update(sql,
                beBetter.getCola(), beBetter.getFattyfood(), beBetter.getSnacks(),
                beBetter.getBadword(), beBetter.getComplain(), beBetter.getStayuplate(),
                beBetter.getReadbook(), beBetter.getLearnskills(), beBetter.getDevelopskills(),
                beBetter.getRunning(), beBetter.getKeep(),
                beBetter.getBreakfast(), beBetter.getLunch(), beBetter.getOtherfood(),
                this.getScore(beBetter),
                nowTime.getNowTime(), beBetter.getId());

    }

    /**
     * 分页查询所有报告方法实现
     * 根据日期倒序查询
     *
     * @param pageBean
     */
    @Override
    public void findAllReports(PageBean<BeBetter> pageBean) {
        // 2.查询总结果数;设置到pageBean对象中
        int totalCount = this.getTotalCount();
        pageBean.setTotalCount(totalCount);

        // 1.判断前端传入的当前页值
        // 1.1如果前端传入的当前页值<=0;则需将当前页赋值为1（即第一页）
        if (pageBean.getCurrentPage() <= 0) {
            pageBean.setCurrentPage(1);// 将当前页赋值为第一页
        }
        // 1.2如果前端传入的当前页值大于最大页的值
        else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());// 将当前页赋值为最大页的值
        }

        // 1.3获取当前页数，计算当前页数据查询sql需要的起始行和放回的行数
        int currentPage = pageBean.getCurrentPage();// 获取此时pageBean中的当前页值
        int index = (currentPage - 1) * pageBean.getPageCount();// 计算出sql查询语句中的起始值
        int count = pageBean.getPageCount();// 获取需要返回的数据行数
        String sql = "SELECT * FROM bebetter ORDER BY DataChange_CreateTime DESC LIMIT ?,?;";

        List<BeBetter> betterList = jdbcTemplate.query(sql, new MyResult(), index, count);
        pageBean.setPageData(betterList);

    }

    /**
     * 根据查询条件获取报告列表方法实现
     *
     * @param pageBean
     * @param getReportList
     */
    @Override
    public void getReportList(PageBean<BeBetter> pageBean, GetReportList getReportList) {
        String date = getReportList.getDate();
        int pageIndex = getReportList.getPageIndex();
        int pageSize = getReportList.getPageSize();
        int totalCount = -1;

        // 1.设置当前页码
        pageBean.setCurrentPage(pageIndex);

        // 2.设置每页返回的数据数目
        pageBean.setPageCount(pageSize);

        // 3.1查询总结果数;设置到pageBean对象中
        if (date == null || date.length() <= 0) {
            totalCount = this.getTotalCount();
        } else {
            totalCount = this.getTotalCountByDate(date);
        }
        //3.2如果总条数小于等于0
        if (totalCount <= 0) {
            pageBean.setTotalCount(0);
            pageBean.setTotalPage(0);
            pageBean.setPageData(null);
        } else {
            //3.3设置结果总条数
            pageBean.setTotalCount(totalCount);

            // 4.判断前端传入的当前页值
            // 4.1如果前端传入的当前页值<=0;则需将当前页赋值为1（即第一页）
            if (pageBean.getCurrentPage() <= 0) {
                pageBean.setCurrentPage(1);// 将当前页赋值为第一页
            }
            // 4.2如果前端传入的当前页值大于最大页的值
            else if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
                pageBean.setCurrentPage(pageBean.getTotalPage());// 将当前页赋值为最大页的值
            }

            // 5. 获取当前页数，计算当前页数据查询sql需要的起始行和放回的行数
            int currentPage = pageBean.getCurrentPage();// 获取此时pageBean中的当前页值
            int index = (currentPage - 1) * pageBean.getPageCount();// 计算出sql查询语句中的起始值
            int count = pageBean.getPageCount();// 获取需要返回的数据行数

            //如果没有传入date,即走分页查询
            if (date == null || date.length() <= 0) {
                String sql = "SELECT * FROM bebetter ORDER BY DataChange_CreateTime DESC LIMIT ?,?;";

                List<BeBetter> betterList = jdbcTemplate.query(sql, new MyResult(), index, count);
                pageBean.setPageData(betterList);
            }
            //如果传入了date，即走按date查询
            else {
                //模糊查询语句WHERE DataChange_CreateTime LIKE concat('%',?,'%');
                String sql = "SELECT * FROM bebetter WHERE DataChange_CreateTime LIKE concat('%',?,'%') ORDER BY id DESC LIMIT ?,?;";
                List<BeBetter> betterList = jdbcTemplate.query(sql, new MyResult(), date, index, count);
                pageBean.setPageData(betterList);
            }
        }

    }

    /**
     * 获取所有结果行数方法实现
     *
     * @return
     */
    @Override
    public int getTotalCount() {
        String sql = "SELECT count(*) FROM bebetter;";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * 根据日期查询总记录数方法
     *
     * @param date
     * @return
     */
    public int getTotalCountByDate(String date) {
        //模糊查询语句WHERE DataChange_CreateTime LIKE concat('%',?,'%');
        String sql = "SELECT count(*) FROM bebetter WHERE DataChange_CreateTime LIKE concat('%',?,'%');";
        return jdbcTemplate.queryForObject(sql, Integer.class, date);
    }

    /**
     * 按ID查询每日报告方法实现
     *
     * @param id
     * @return
     */
    @Override
    public BeBetter findById(int id) {
        String sql = "SELECT * FROM bebetter WHERE id=?;";
        List<BeBetter> list = jdbcTemplate.query(sql, new MyResult(), id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    /**
     * 按ID删除报告方法实现
     *
     * @param id
     */
    @Override
    public void deleteReport(int id) {
        String sql = "DELETE FROM bebetter WHERE id=?;";
        jdbcTemplate.update(sql, id);

    }

    /**
     * 计算每日报告得分方法实现
     *
     * @param beBetter
     * @return
     */
    @Override
    public int getScore(BeBetter beBetter) {
        return new GetBeBetterScore().getDayScore(beBetter);
    }


    /**
     * 封装方法1
     */
    class MyResult implements RowMapper<BeBetter> {
        // 如何封装一行记录
        public BeBetter mapRow(ResultSet rs, int index) throws SQLException {
            BeBetter beBetter = new BeBetter();
            beBetter.setId(rs.getInt("id"));

            beBetter.setDataChange_LastTime(rs.getDate("dataChange_LastTime"));
            beBetter.setDataChange_CreateTime(rs.getDate("dataChange_CreateTime"));

            beBetter.setCola(rs.getInt("cola"));
            beBetter.setFattyfood(rs.getInt("fattyfood"));
            beBetter.setSnacks(rs.getInt("snacks"));
            beBetter.setBadword(rs.getInt("badword"));
            beBetter.setComplain(rs.getInt("complain"));
            beBetter.setStayuplate(rs.getInt("stayuplate"));

            beBetter.setReadbook(rs.getInt("readbook"));
            beBetter.setLearnskills(rs.getInt("learnskills"));
            beBetter.setDevelopskills(rs.getInt("developskills"));

            beBetter.setRunning(rs.getFloat("running"));
            beBetter.setKeep(rs.getInt("keep"));

            beBetter.setBreakfast(rs.getInt("breakfast"));
            beBetter.setLunch(rs.getInt("lunch"));
            beBetter.setOtherfood(rs.getInt("otherfood"));

            beBetter.setScore(rs.getInt("Score"));
            return beBetter;
        }
    }
}
