package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.Test;
import com.huangjunwei.www.util.DateUtils;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 对Test表处理简单的数据库操作
 * @author HJW
 */
public class TestDao {

    /**
     * 通过testId返回test对象
     */
    public Test findTest(int testId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_test where situation=1 and id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,testId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setCourseId(rs.getInt("course_id"));
                test.setNumber(rs.getInt("number"));
                test.setClassroom(rs.getInt("classroom"));
                test.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                test.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));
                test.setSituation(rs.getInt("situation"));
                return test;
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
     * 通过testId返回CourseId
     */
    public int findCourse(int testId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_test where situation=1 and id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,testId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("course_id");
            }else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return 0;
    }

}
