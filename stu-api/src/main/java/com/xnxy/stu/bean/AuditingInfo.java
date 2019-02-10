package com.xnxy.stu.bean;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class AuditingInfo implements Serializable {
    @Column
    private String id;

    @Column
    private String leaveId;
    @Column
    private String auditingStatus;//审核状态
    @Column
    private String teacherNum;
    @Column
    private String teacherName;
    @Column
    private Date auditingCreateTime;//审核时间
    @Column
    private String advice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(String auditingStatus) {
        this.auditingStatus = auditingStatus;
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

    public Date getAuditingCreateTime() {
        return auditingCreateTime;
    }

    public void setAuditingCreateTime(Date auditingCreateTime) {
        this.auditingCreateTime = auditingCreateTime;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
