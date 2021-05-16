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

    /**
     * 通过课程id返回Test对象
     */
    public Test findCourseTest(int courseId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_test where course_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseId);
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
     * 添加考试
     */
    public void addTest(int courseId,int number,int classroom,String beginTime,String endTime){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_test (course_id,classroom,number,begin_time,end_time) value (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseId);
            pstmt.setInt(2,classroom);
            pstmt.setInt(3,number);
            pstmt.setString(4,beginTime);
            pstmt.setString(5,endTime);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    /**
     * 通过courseId查找修改申请表情况
     */
    public void updateTestSituation(int courseId,int situation){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "update t_test set situation=? where course_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,situation);
            pstmt.setInt(2,courseId);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }
}
