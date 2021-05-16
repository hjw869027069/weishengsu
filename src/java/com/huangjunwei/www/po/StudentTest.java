package com.huangjunwei.www.po;

/**
 * 学生测试成绩实体类
 * @author HJW
 */
public class StudentTest {
    private int id;
    private int userId;
    private int testId;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentTest{" +
                "id=" + id +
                ", userId=" + userId +
                ", testId=" + testId +
                ", score=" + score +
                '}';
    }
}
