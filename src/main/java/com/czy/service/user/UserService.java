package com.czy.service.user;

import com.czy.pojo.User;

public interface UserService {
    //实现用户登录验证
    public User login(String username,String password);

    //实现用户信息显示
    public User inForm(String rName);

    //修改数据库中信息
    public boolean InformModify(User user);

    //通过id得到用户
    public User getUserById(int id);

    //查询用户报名信息
    public String examInfo(User user);
}
