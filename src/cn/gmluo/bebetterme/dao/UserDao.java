package cn.gmluo.bebetterme.dao;

import cn.gmluo.bebetterme.entity.User;
import cn.gmluo.bebetterme.util.PageBean;

/**
 * 2.数据访问层（持久层）
 * 2.1-dao接口设计
 * Created by gmluo on 2018/4/9.
 */
public interface UserDao {
    /**
     * 保存用户信息方法
     *
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据用户登陆Email和PassWord验证用户方法
     *
     * @param user
     * @return
     */
    public User findByEmailAndPwd(User user);

    /**
     * 根据用户id查询用户信息方法
     *
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 修改用户信息方法
     *
     * @param user
     */
    public void updateUser(User user);


    /**
     * 检查email是否存在方法
     *
     * @param email
     * @return
     */
    public boolean emailExist(String email);

    /**
     * 检查userName是否存在方法
     *
     * @param userName
     * @return
     */
    public boolean userNameExist(String userName);

    /**
     * 分页获取用户信息方法
     */
    public void getAllUsers(PageBean<User> pageBean);

    /**
     * 查询总记录数方法
     *
     * @return
     */
    public int getTotalCount();

    /**
     * 删除用户信息方法
     *
     * @param id
     */
    public void deleteUserById(int id);

}
