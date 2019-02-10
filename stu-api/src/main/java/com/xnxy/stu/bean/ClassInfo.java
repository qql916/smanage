package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClassInfo implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String className;
    @Column
    private String academyId;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }
}
