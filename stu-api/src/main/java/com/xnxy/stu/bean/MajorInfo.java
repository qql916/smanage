package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;

public class MajorInfo {
    @Id
    @Column
    private String id;
    @Column
    private String majorName;
    @Column
    private String academyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }
}
