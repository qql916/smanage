package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CourseInfo implements Serializable{

    @Id
    @Column
    private String id;
    @Column
    private String courseName;
}
