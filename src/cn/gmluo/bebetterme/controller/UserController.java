package cn.gmluo.bebetterme.controller;

import cn.gmluo.bebetterme.entity.User;
import cn.gmluo.bebetterme.service.UserService;
import cn.gmluo.bebetterme.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 4.控制层
 * 4.1Controller控制类实现
 * Created by gmluo on 2018/4/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 分页查询所有用户信息
     * @param pageIndex
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getUsersByPageIndex",method = RequestMethod.GET)
    public PageBean<User> getUsersByPageIndex(@RequestParam(value = "pageIndex") int pageIndex){
        if (pageIndex<=0){
            pageIndex=1;
        }
        PageBean<User> pageBean=new PageBean<User>();
        pageBean.setCurrentPage(pageIndex);
        userService.getAllUsers(pageBean);
        return pageBean;
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public String saveUser(@RequestBody User user){
        userService.register(user);
        return "success";
    }

    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam(value = "id")int id){
        userService.deleteUserById(id);
        return "success";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestBody User user){
        userService.updateUser(user);
        return "success";
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findUserById",method = RequestMethod.GET)
    public User findUserById(@RequestParam(value = "id")int id){
        return userService.findById(id);
    }

}
