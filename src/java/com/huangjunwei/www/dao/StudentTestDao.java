package com.huangjunwei.www.dao;

import com.huangjunwei.www.po.StudentTest;
import com.huangjunwei.www.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生考试表的简单数据库操作
 * @author HJW
 */
public class StudentTestDao {
    public List<StudentTest> findStudentTest(int userId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_test_student where user_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userId);
            rs = pstmt.executeQuery();
            List<StudentTest> studentTests = new ArrayList<>();

            while (rs.next()) {
                StudentTest studentTest = new StudentTest();
                studentTest.setId(rs.getInt("id"));
                studentTest.setTestId(rs.getInt("test_id"));
                studentTest.setUserId(rs.getInt("user_id"));
                studentTest.setScore(rs.getDouble("score"));

                studentTests.add(studentTest);
            }
            return studentTests;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstmt,conn);
        }
        return null;
    }
}
