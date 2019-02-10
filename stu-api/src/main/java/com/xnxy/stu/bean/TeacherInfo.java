package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TeacherInfo implements Serializable{

    @Id
    @Column
    private String id;

    @Column
    private String teacherNum;//教职工编号
    @Column
    private String teacherName;
    @Column
    private String phoneNum;
    @Column
    private String passwd;
    @Column
    private String academyId;
    @Column
    private String office;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
