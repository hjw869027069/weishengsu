package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.Number;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * number简单数据库操作
 * @author HJW
 */
public class NumberDao {

    /**
     * 将number对象存入数据库t_number表
     */
    public void insertNumber(Number number)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int userId = number.getUserId();
        String sex = number.getSex();
        String major = number.getMajor();
        int grade = number.getGrade();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_number (user_id,sex,major,grade)  value (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            pstmt.setString(2,sex);
            pstmt.setString(3,major);
            pstmt.setInt(4,grade);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    /**
     * 通过userId找出number对象
     */
    public Number findNumber(int userId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Number number = new Number();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_number where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                number.setUserId(rs.getInt("user_id"));
                number.setGrade(rs.getInt("grade"));
                number.setSex(rs.getString("sex"));
                number.setMajor(rs.getString("major"));
                return number;
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

    public void deleteNumber(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from t_number where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }
}
