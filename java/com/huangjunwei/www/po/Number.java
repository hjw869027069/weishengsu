package com.huangjunwei.www.po;

/**
 * @author HJW
 */
public class Number {
    private int userId;
    private String sex;
    private String major;
    private int grade;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Number{" +
                "userId=" + userId +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                '}';
    }
}
