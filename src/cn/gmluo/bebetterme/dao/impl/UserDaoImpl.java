package cn.gmluo.bebetterme.dao.impl;

import cn.gmluo.bebetterme.dao.UserDao;
import cn.gmluo.bebetterme.entity.User;
import cn.gmluo.bebetterme.service.requesttype.GetUserList;
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
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
    //IOC容器注入对象jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private NowTime nowTime=new NowTime();

    /**
     * 保存用户信息方法实现
     * @param user
     */
    @Override
    public void saveUser(User user) {
        String sql ="INSERT INTO user (  UserName, PassWord," +
                " Email, Birthday, Age,Gender, " +
                "DataChange_CreateTime, DataChange_LastTime) VALUES (?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql,
                user.getUserName(),user.getPassword(),
                user.getEmail(),user.getBirthday(),user.getAge(),user.getGender(),
                nowTime.getNowTime(), nowTime.getNowTime());
//                this.todayDate(),this.todayDate());
    }

    /**
     * 根据用户登陆UserName和PassWord验证用户方法实现
     * @param user
     * @return
     */
    @Override
    public User findByUserNameAndPassWord(User user) {
        String sql = "SELECT * FROM user WHERE UserName=? AND PassWord=?;";
        List<User> list=jdbcTemplate.query(sql,new MyResult(),user.getUserName(),user.getPassword());
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    /**
     * 根据用户id查询用户信息方法实现
     * @param id
     * @return
     */
    @Override
    public User findById(int id) {
        String sql ="SELECT * FROM user WHERE Id=?;";
        List<User> list=jdbcTemplate.query(sql,new MyResult(),id);
        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

    /**
     * 修改用户信息方法实现
     * @param user
     */
    @Override
    public void updateUser(User user) {
        String sql ="UPDATE user SET UserName=?,PassWord=?,Email=?,Birthday=?,Age=?,Gender=?,DataChange_LastTime=?  WHERE Id=?;";
        jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getEmail(),user.getBirthday(),user.getAge(),user.getGender(),nowTime.getNowTime(),user.getId());

    }

    /**
     * 检查email是否存在方法实现
     * @param email
     * @return
     */
    @Override
    public boolean emailExist(String email) {
        String sql ="SELECT Email FROM user WHERE Email=?;";
        if (jdbcTemplate.queryForObject(sql,String.class)!=null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 检查userName是否存在方法实现
     * @param userName
     * @return
     */
    @Override
    public boolean userNameExist(String userName) {
        String sql ="SELECT UserName FROM user WHERE UserName=?;";
        if (jdbcTemplate.queryForObject(sql,String.class)!=null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 分页获取用户信息方法
     * @param pageBean
     */
    @Override
    public void getAllUsers(PageBean<User> pageBean) {
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
//        String sql = "SELECT * FROM user LIMIT ?,?;";//正序查询
        String sql = "SELECT * FROM user ORDER BY Id DESC LIMIT ?,?;";//倒序查询

        List<User> userList = jdbcTemplate.query(sql, new MyResult(), index, count);
        pageBean.setPageData(userList);

    }

    @Override
    public void getUserList(PageBean<User> pageBean, GetUserList getUserList) {
        String uerName=getUserList.getUserName();
        int pageIndex=getUserList.getPageIndex();
        int pageSize=getUserList.getPageSize();
        int totalCount=-1;

        // 1.设置当前页码
        pageBean.setCurrentPage(pageIndex);

        // 2.设置每页返回的数据数目
        pageBean.setPageCount(pageSize);

        // 3.1查询总结果数;设置到pageBean对象中
        if (uerName==null||uerName.length()<=0){
            totalCount = this.getTotalCount();
        }else {
            totalCount = this.getTotalCountByUserName(uerName);
        }
        //3.2如果总条数小于0
        if (totalCount<=0){
            pageBean.setTotalCount(0);
            pageBean.setTotalPage(0);
            pageBean.setPageData(null);
        }else {
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

            //如果没有传入uerName,即走分页查询
            if (uerName==null||uerName.length()<=0){
                String sql = "SELECT * FROM user ORDER BY Id DESC LIMIT ?,?;";//倒序查询
                List<User> userList = jdbcTemplate.query(sql, new MyResult(), index, count);
                pageBean.setPageData(userList);
            }
            //如果传入了uerName，即走按名字查询
            else {
                //模糊查询语句UserName LIKE concat('%',?,'%')
                String sql = "SELECT * FROM user WHERE UserName LIKE concat('%',?,'%') ORDER BY Id DESC LIMIT ?,?;";//倒序查询
                List<User> userList = jdbcTemplate.query(sql, new MyResult(),uerName,index, count);
                pageBean.setPageData(userList);
            }
        }
    }

    /**
     * 查询总记录数方法
     * @return
     */
    @Override
    public int getTotalCount() {
        String sql ="SELECT count(*) FROM user;";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    /**
     * 根据用户名称查询总记录数方法
     * @param userName
     * @return
     */
    public int getTotalCountByUserName(String userName){
        //模糊查询语句UserName LIKE concat('%',?,'%')
        String sql ="SELECT count(*) FROM user WHERE UserName LIKE concat('%',?,'%');";
        return jdbcTemplate.queryForObject(sql,Integer.class,userName);
    }

    /**
     * 删除用户信息方法实现
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        String sql ="DELETE FROM user WHERE Id=?;";
        jdbcTemplate.update(sql,id);

    }

//    /**
//     * 获取当前系统时间
//     *
//     * @return
//     */
//    public String todayDate() {
//        // 获取当前系统时间
//        Date nowTime = new Date();
//        // 设置时间格式化的样式
//        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH-mm:ss");
//        // 对当前时间进行格式化
//        String dateString = format.format(nowTime);
//        return dateString;
//    }

    /**
     * 封装方法1
     */
    class MyResult implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int index) throws SQLException {
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setAge(resultSet.getInt("age"));
            user.setGender(resultSet.getInt("gender"));
            user.setDataChange_CreateTime(resultSet.getDate("dataChange_CreateTime"));
            user.setDataChange_LastTime(resultSet.getDate("dataChange_LastTime"));

            return user;
        }
    }

}
