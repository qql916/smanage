package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class SAddendance implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String studentNum;
    @Column
    private Date addendTime;
    @Column
    private String courseId;
    @Column
    private String courseName;
    @Column
    private Date courseTime;
    @Column
    private String classroomId;
    @Column
    private String addendStatus;
    @Column
    private Date createTime;
    @Column
    private String week;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Date getAddendTime() {
        return addendTime;
    }

    public void setAddendTime(Date addendTime) {
        this.addendTime = addendTime;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getAddendStatus() {
        return addendStatus;
    }

    public void setAddendStatus(String addendStatus) {
        this.addendStatus = addendStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
