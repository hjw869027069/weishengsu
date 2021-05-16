package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.User;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *User实体类的简单数据库操作
 * @author HJW
 */
public class UserDao {

    /**
     * 把登录的账号封装成实体类
     * */
    public User login(User loginUser) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user where username=? and password=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginUser.getUsername());
            pstmt.setString(2,loginUser.getPassword());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLever(rs.getInt("lever"));
                user.setName(rs.getString("name"));
                return user;
            }else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     * 判断是否存在账号
     * */
    public boolean findUser(String username)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user where username=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            rs = pstmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return false;
    }

    /**
     * 往数据库增加User数据
     * */
    public void insertUser(User user)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String username = user.getUsername();
        String password = user.getPassword();
        String name = user.getName();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_user value (null,'"+name+"','"+username+"','"+password+"',1)";
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    /**
     * 通过userId找出user对象
     */
    public User findTeacher(int userId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = new User();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLever(rs.getInt("lever"));
                user.setName(rs.getString("name"));
                return user;
            }else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     *更新用户密码
     */
    public void updatePassword(int userId,String newPassword){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "update t_user set password=? where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newPassword);
            pstmt.setInt(2,userId);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    public void deleteUser(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from t_user where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }


    /**
     * 查找所有的user对象，返回user对象的集合
     */
    public List<User> findAllUser(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setLever(rs.getInt("lever"));
                user.setName(rs.getString("name"));

                users.add(user);
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     * 修改用户权限
     */
    public void updateLeverUserId(int userId,int lever){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "update t_user set lever=? where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,lever);
            pstmt.setInt(2,userId);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }
}
