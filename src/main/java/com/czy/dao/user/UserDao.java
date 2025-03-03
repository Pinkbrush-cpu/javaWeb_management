package com.czy.dao.user;

import com.czy.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    public User getLoginUser(Connection con, String username, String password);

    //修改当前用户密码
    public int updatePwd(Connection con, int id, String password) throws SQLException;

    //查询用户总数
    public int getUserid(Connection con, String username)throws SQLException;

    //通过条件查询-userList
    public List<User> getUserList(Connection con, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;

    //通过用户名得到用户
    public User getUserName(Connection con, String username);

    //通过ID得到用户
    public User getById(Connection con, int id);

    //将用户存入数据库
    public boolean fillInDatabase(Connection con,User user) throws SQLException;

    //将修改数据库信息
    public boolean informModify(Connection con,User user);

    //查询用户报名信息
    public StringBuffer viewExamInformation(Connection con,User user);
}
