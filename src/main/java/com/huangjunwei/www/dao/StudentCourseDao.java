package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.StudentCourse;
import com.huangjunwei.www.po.User;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 简单的数据库的t_course_student表操作
 * @author HJW
 */
public class StudentCourseDao {

    /**
     * 可查询该学生在数据库中存储的所有课表，返回arraylist的课表id
     */
    public List<Integer> findStudentCourseId(int studentId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> courses = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course_student where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,studentId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                courses.add(rs.getInt("course_id"));
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
     * 直接在t_course_student上添加学生和课程Id
     */
    public void addStudentCourse(int studentId,int courseId){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_course_student (user_id,course_id) value (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,studentId);
            pstmt.setInt(2,courseId);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    /**
     * 通过学生id获取课程，返回StudentCourse对象集合
     */
    public List<StudentCourse> findStudentCourse(int stuId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<StudentCourse> studentCourses = new ArrayList<>();

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course_student where user_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,stuId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentCourse studentCourse = new StudentCourse();

                studentCourse.setCourseId(rs.getInt("course_id"));
                studentCourse.setStudentId(rs.getInt("user_id"));
                studentCourse.setScore(rs.getDouble("score"));
                studentCourse.setWords(rs.getString("words"));

                studentCourses.add(studentCourse);
            }
            return studentCourses;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }

    /**
     * 通过课程id获取课程，返回StudentCourse对象
     */
    public StudentCourse findCourseEvaluate(int courseId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_course_student where course_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,courseId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                StudentCourse studentCourse = new StudentCourse();

                studentCourse.setCourseId(rs.getInt("course_id"));
                studentCourse.setStudentId(rs.getInt("user_id"));
                studentCourse.setScore(rs.getDouble("score"));
                studentCourse.setWords(rs.getString("words"));

                return studentCourse;
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
     * 直接在t_course_student上更新评分和评价
     */
    public void updateStudentEvaluate(int courseId,String words,double score){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "update t_course_student set score=? ,words=? where course_id=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1,score);
            pstmt.setString(2,words);
            pstmt.setInt(3,courseId);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt,conn);
        }
    }

    public void deleteCourse(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;


        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from t_course_student where user_id=? ";
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
