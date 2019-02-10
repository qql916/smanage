package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RoleInfo implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
