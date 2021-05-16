package com.huangjunwei.www.po;

/**
 * t_course_student的实体类
 * @author HJW
 */
public class StudentCourse {
    private int studentId;
    private int courseId;
    private double score;
    private String words;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", score=" + score +
                ", words='" + words + '\'' +
                '}';
    }
}
