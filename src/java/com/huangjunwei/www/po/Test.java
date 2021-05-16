package com.huangjunwei.www.po;

/**
 * Test表实体类
 * @author HJW
 */
public class Test {
    private int id;
    private int courseId;
    private String beginTime;
    private String endTime;
    private int number;
    private int classroom;
    private int situation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", number=" + number +
                ", classroom=" + classroom +
                ", situation=" + situation +
                '}';
    }
}
