package com.xnxy.stu.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PermissionInfo implements Serializable {

    @Id
    @Column
    private String id;
    @Column
    private String pid;
    @Column
    private String permissionName;
    @Column
    private String icon;
    @Column
    private String url;
    //必须和zTree中使用的属性名一致
    @Transient
    private Boolean open = true;
    @Transient
    private Boolean checked;
    //必须和zTree中使用的属性名一致
    private List<PermissionInfo> children = new ArrayList<>();
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<PermissionInfo> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionInfo> children) {
        this.children = children;
    }
}
