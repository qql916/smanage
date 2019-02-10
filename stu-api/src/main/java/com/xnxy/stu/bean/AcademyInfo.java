package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

public class AcademyInfo implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String academyName;


    @Transient
    private List<MajorInfo> majorInfoList;
    @Transient
    private List<ClassInfo> classInfoList;
    @Transient
    private List<ClassroomInfo> classroomInfoList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}
