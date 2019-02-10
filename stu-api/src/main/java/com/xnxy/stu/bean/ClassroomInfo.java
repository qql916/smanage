package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ClassroomInfo implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String classroomName;
    @Column
    private String academyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
