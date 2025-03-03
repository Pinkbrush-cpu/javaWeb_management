package com.czy.dao.user;

import com.czy.dao.BaseDao;
import com.czy.pojo.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //得到要登录的用户
    public User getLoginUser(Connection con, String username, String password) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = null;

        if(con != null){
            //想要筛选的SQL语句  这里的?是一个参数占位符，它表示在执行查询之前，这个位置的值将被一个具体的值所替换。
            //这个具体的值是通过PreparedStatement对象的某个set方法
            String sql = "select * from user where username=?";

            Object[] params = {username};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            try {
                if (rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name").trim());
                    user.setUsername(rs.getString("username").trim());
                    user.setPassword(rs.getString("password").trim());
                    user.setSex(rs.getString("sex").charAt(0));
                    user.setPhonenumber(rs.getString("phonenumber").trim());
                    user.setEmail(rs.getString("email").trim());
                    if(rs.getString("college") != null)
                        user.setCollege(rs.getString("college").trim());
                    user.setRegistrationtime(rs.getTime("registrationtime"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            BaseDao.closeResource(null,pre,rs);

            if (user != null && !BCrypt.checkpw(password, user.getPassword())) {
                user = null;
            }
        }
        return user;
    }

    //通过用户名得到用户
    public User getUserName(Connection con, String username) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = null;
        if(con != null){
            //想要筛选的SQL语句  这里的?是一个参数占位符，它表示在执行查询之前，这个位置的值将被一个具体的值所替换。
            //这个具体的值是通过PreparedStatement对象的某个set方法
            String sql = "select * from user where username=?";

            Object[] params = {username};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            try {
                if (rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name").trim());
                    user.setUsername(rs.getString("username").trim());
                    user.setPassword(rs.getString("password").trim());
                    user.setSex(rs.getString("sex").charAt(0));
                    user.setPhonenumber(rs.getString("phonenumber").trim());
                    user.setEmail(rs.getString("email").trim());
                    if(rs.getString("college") != null)
                        user.setCollege(rs.getString("college").trim());
                    user.setRegistrationtime(rs.getTime("registrationtime"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            BaseDao.closeResource(null,pre,rs);
            if (user != null && !user.getUsername().equals(username)) {
                user = null;
            }
        }
        return user;
    }

    @Override
    public User getById(Connection con, int id) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        User user = null;
        if(con != null){
            //想要筛选的SQL语句  这里的?是一个参数占位符，它表示在执行查询之前，这个位置的值将被一个具体的值所替换。
            //这个具体的值是通过PreparedStatement对象的某个set方法
            String sql = "select * from user where id=?";

            Object[] params = {id};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            try {
                if (rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name").trim());
                    user.setUsername(rs.getString("username").trim());
                    user.setPassword(rs.getString("password").trim());
                    user.setSex(rs.getString("sex").charAt(0));
                    user.setPhonenumber(rs.getString("phonenumber").trim());
                    user.setEmail(rs.getString("email").trim());
                    if(rs.getString("college") != null)
                        user.setCollege(rs.getString("college").trim());
                    user.setRegistrationtime(rs.getTime("registrationtime"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            BaseDao.closeResource(null,pre,rs);
            if (user != null && (user.getId() != id)) {
                user = null;
            }
        }
        return user;
    }

    @Override
    //将用户存入数据库
    public boolean fillInDatabase(Connection con, User user) {
        PreparedStatement pre = null;
        if(con != null){
            String sql = "insert into user(`name`,`username`,`password`,sex,phonenumber,email,registrationtime) values(?,?,?,?,?,?,?);";
            Object[] params = {user.getName(),user.getUsername(),user.getPassword(),String.valueOf(user.getSex()),user.getPhonenumber(),user.getEmail(),user.getRegistrationtime()};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                BaseDao.closeResource(null,pre,null);
                return true;
            }
        }
        return false;
    }

    //得到用户id
    public int getUserid(Connection con,String username) throws SQLException {
        PreparedStatement pre = null;
        ResultSet rs = null;
        int id = 0;
        if(con != null){
            //想要筛选的SQL语句  这里的?是一个参数占位符，它表示在执行查询之前，这个位置的值将被一个具体的值所替换。
            //这个具体的值是通过PreparedStatement对象的某个set方法
            String sql = "select id from user where username=?";

            Object[] params = {username};
            rs = BaseDao.execute(con,pre,rs,sql,params);
            if (rs.next()){
                id = rs.getInt("id");
            }

            BaseDao.closeResource(null,pre,rs);
        }
        return id;
    }

    @Override
    public boolean informModify(Connection con, User user) {
        PreparedStatement pre = null;
        if(con != null){
            String sql = "UPDATE user SET `name` = ?, `username` = ?, `sex` = ?, phonenumber = ?, `email` = ?, `college` = ? WHERE `id` = ?";
            Object[] params = {user.getName(),user.getUsername(), String.valueOf(user.getSex()),user.getPhonenumber(),user.getEmail(),user.getCollege(),user.getId()};
            if(BaseDao.execute(con,pre,sql,params) > 0){
                BaseDao.closeResource(null,pre,null);
                return true;
            }
        }
        return false;
    }

    public int updatePwd(Connection con, int id, String password) {

        return 0;
    }

    public List<User> getUserList(Connection con, String userName, int userRole, int currentPageNo, int pageSize) {
        return null;
    }

    @Override
    public StringBuffer viewExamInformation(Connection con,User user) {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Object[] params;
        StringBuffer appOut = new StringBuffer();
        String sql;
        int rowNumber = 0;
        if(con != null){
            sql = "SELECT * FROM application WHERE `id` = ? ;";
            params = new Object[]{user.getId()};
            try {
                rs = BaseDao.execute(con,pre,rs,sql,params);

                while (rs.next()) {
                    rowNumber++;

                    LocalDate appDate = rs.getObject("examTime", LocalDate.class);
                    LocalTime appTime = rs.getObject("examTime", LocalTime.class);
                    LocalDateTime comTime = LocalDateTime.of(appDate, appTime);
                    Date deDate = Date.from(comTime.atZone(ZoneId.systemDefault()).toInstant());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    String formattedDate = sdf.format(deDate);

                    appOut.append("<tr>" +
                            "<th id='thExamId_" + rowNumber + "'>" + rs.getInt("examId")  + "</th>" +
                            "<th id='thId_" + rowNumber + "'>" + rs.getInt("id")  + "</th>" +
                            "<th>" + rs.getString("name")  + "</th>" +
                            "<th>" + rs.getString("project")  + "</th>" +
                            "<th>" + rs.getString("phoneNumber")  + "</th>" +
                            "<th>" + rs.getString("major")  + "</th>" +
                            "<th>" + formattedDate  + "</th>" +
                            "<th>" + rs.getInt("results") + "</th>" +
                            "</tr>");

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        BaseDao.closeResource(null,pre,rs);
        return appOut;
    }
}
