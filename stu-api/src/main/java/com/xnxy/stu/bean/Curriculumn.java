package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class Curriculumn implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String courseId;//课程id
    @Column
    private String teacherNum;
    @Column
    private Date courseHour;//上课时间
    @Column
    private String courseWeeks;//课程周数
    @Column
    private String courseStart;//课程开始周数
    @Column
    private String classroomId;
    @Column
    private String weekName;//星期
    @Column
    private String classId;
    @Column
    private String gradeName;
    @Column
    private String year;
    @Column
    private String team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public Date getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Date courseHour) {
        this.courseHour = courseHour;
    }

    public String getCourseWeeks() {
        return courseWeeks;
    }

    public void setCourseWeeks(String courseWeeks) {
        this.courseWeeks = courseWeeks;
    }

    public String getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(String courseStart) {
        this.courseStart = courseStart;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
