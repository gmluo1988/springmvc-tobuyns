package cn.gmluo.bebetterme.entity;

import java.sql.Date;

/**
 * 1.数据实例层设计
 * Created by gmluo on 2018/4/9.
 */
public class User {
    /**
     * 主键
     */
    private int id;
    /**
     * Date 日期（时间戳）
     */
    private Date dataChange_LastTime;
    private Date dataChange_CreateTime;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;

    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     * 1：male
     * 0:female
     */
    private int gender;


    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dataChange_LastTime=" + dataChange_LastTime +
                ", dataChange_CreateTime=" + dataChange_CreateTime +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataChange_LastTime() {
        return dataChange_LastTime;
    }

    public void setDataChange_LastTime(Date dataChange_LastTime) {
        this.dataChange_LastTime = dataChange_LastTime;
    }

    public Date getDataChange_CreateTime() {
        return dataChange_CreateTime;
    }

    public void setDataChange_CreateTime(Date dataChange_CreateTime) {
        this.dataChange_CreateTime = dataChange_CreateTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
