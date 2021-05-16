package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.Application;
import com.huangjunwei.www.util.DateUtils;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 申请表简单的数据库操作
 * @author HJW
 */
public class ApplicationDao {

    /**
     * 通过teacherId找到所有的申请表，查询申请记录
     */
    public List<Application> findApplication(int teacherId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Application> applications = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_application_test where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,teacherId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setUserId(rs.getInt("user_id"));
                application.setNumber(rs.getInt("number"));
                application.setApplyTime(DateUtils.gainTime(rs.getTimestamp("apply_time")));
                application.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                application.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));
                application.setCourseId(rs.getInt("course_id"));
                application.setClassroom(rs.getInt("classroom"));

                applications.add(application);
            }
            return applications;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     *添加申请表
     */
    public void addApplication(int userId,int courseId,int number,int classroom,String beginTime,String endTime){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_application_test (user_id,course_id,classroom,number,begin_time,end_time) value (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            pstmt.setInt(2,courseId);
            pstmt.setInt(3,classroom);
            pstmt.setInt(4,number);
            pstmt.setString(5,beginTime);
            pstmt.setString(6,endTime);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    /**
     * 找到所有的申请表，返回申请表对象集合
     */
    public List<Application> findAllApplication(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Application> applications = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_application_test ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Application application = new Application();
                application.setId(rs.getInt("id"));
                application.setUserId(rs.getInt("user_id"));
                application.setNumber(rs.getInt("number"));
                application.setApplyTime(DateUtils.gainTime(rs.getTimestamp("apply_time")));
                application.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                application.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));
                application.setCourseId(rs.getInt("course_id"));
                application.setClassroom(rs.getInt("classroom"));

                applications.add(application);
            }
            return applications;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }
}
