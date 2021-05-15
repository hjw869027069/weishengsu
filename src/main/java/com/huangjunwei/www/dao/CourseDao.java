package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.Course;
import com.huangjunwei.www.util.DateUtils;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程表相关的简单数据库操作
 * @author HJW
 */
public class CourseDao {

    /**
     * 通过教师Id找出课程
     * */
    public List<Course> findCourseTeacher(int teacherId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Course> courses = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,teacherId);
            rs = pstmt.executeQuery();
            while(rs.next()) {

                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setClassroom(rs.getInt("classroom"));
                course.setMaxNumber(rs.getInt("max_number"));
                course.setCourse(rs.getString("course"));
                course.setMajor(rs.getString("major"));
                course.setGrade(rs.getInt("grade"));
                course.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                course.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));
                courses.add(course);
            }
            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     * 可查询该年级的选修或者必修的所有课表，返回arraylist的课表id
     */
    public List<Integer> findAllStudentCourseId(int grade,String course){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> courses = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course where grade=? and course=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,grade);
            pstmt.setString(2,course);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                courses.add(rs.getInt("id"));

            }
            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     * 根据课程id查找课程，返回课程对象
     */
    public Course findCourse(int courseId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = new Course();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseId);
            rs = pstmt.executeQuery();

            if(rs.next()){
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setClassroom(rs.getInt("classroom"));
                course.setMaxNumber(rs.getInt("max_number"));
                course.setCourse(rs.getString("course"));
                course.setMajor(rs.getString("major"));
                course.setGrade(rs.getInt("grade"));
                course.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                course.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));

                return course;
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
     * 直接通过课程找出教师Id，返回int
     */
    public int findTeacherId(Course course){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course where id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,course.getId());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getInt("user_id");
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

        public Course searchStudentCourse(int courseId,String courseName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course where id=? and name like ?";
            pstmt = conn.prepareStatement(sql);
            String s = "%" +
                    courseName +
                    "%";
            pstmt.setInt(1,courseId);
            pstmt.setString(2,s);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setClassroom(rs.getInt("classroom"));
                course.setMaxNumber(rs.getInt("max_number"));
                course.setCourse(rs.getString("course"));
                course.setMajor(rs.getString("major"));
                course.setGrade(rs.getInt("grade"));
                course.setBeginTime(DateUtils.gainTime(rs.getTimestamp("begin_time")));
                course.setEndTime(DateUtils.gainTime(rs.getTimestamp("end_time")));

                return course;
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }
}
