package cn.gmluo.bebetterme.service;

import cn.gmluo.bebetterme.service.requesttype.DeleteIdList;
import cn.gmluo.bebetterme.entity.User;
import cn.gmluo.bebetterme.service.requesttype.GetUserList;
import cn.gmluo.bebetterme.util.PageBean;

/**
 * 3.业务逻辑层
 * 3.1-UserService接口
 * Created by gmluo on 2018/4/9.
 */
public interface UserService {
    /**
     * 注册方法
     *
     * @param user
     */
    public void register(User user);

    /**
     * 登陆验证方法
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 分页查询用户信息方法
     *
     * @param pageBean
     */
    public void getAllUsers(PageBean<User> pageBean);

    /**
     * 根据查询条件获取用户信息列表方法
     *
     * @param pageBean
     * @param getUserList
     */
    public void getUserList(PageBean<User> pageBean, GetUserList getUserList);


    /**
     * 根据用户id查询用户信息方法
     *
     * @param id
     * @return
     */
    public User findById(int id);

    /**
     * 更改用户信息方法
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户信息方法
     *
     * @param id
     */
    public void deleteUserById(int id);

    /**
     * 批量删除用户信息方法
     *
     * @param idList
     */
    public void batchDeleteUserById(DeleteIdList idList);

}
