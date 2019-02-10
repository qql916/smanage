package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class StudentInfo implements Serializable{
    @Id
    @Column
    private String id;
    @Column
    private String studentNum;//学生学号
    @Column
    private String stuName;
    @Column
    private String passwd;
    @Column
    private String classId;
    @Column
    private String phoneNum;
    @Column
    private String sex;
    @Column
    private String email;
    @Column
    private Date createTime;//学生注册时间
    @Column
    private String cardNum;//学生卡号
    @Column
    private String gradeName;//年级
    @Column
    private String academyId;//学院id
    @Column
    private String majorId;//专业

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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
}
