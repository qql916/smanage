package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class LeaveInfo implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String studentNum;
    @Column
    private String studentName;
    @Column
    private String classId;
    @Column
    private Date LeaveStartTime;//请假开始时间
    @Column
    private Date leaveEndTime;//请假结束时间
    @Column
    private String reason;
    @Column
    private Date applyTime;//申请时间
    @Column
    private String auditingStatus;
    @Column
    private String gradeName;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Date getLeaveStartTime() {
        return LeaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        LeaveStartTime = leaveStartTime;
    }

    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }



    public String getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(String auditingStatus) {
        this.auditingStatus = auditingStatus;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
