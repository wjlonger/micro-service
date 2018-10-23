package com.coder.base.model;

import java.io.Serializable;

public class RoleMenu extends BaseModel implements Serializable {

    private static final long serialVersionUID = 5691130140690811801L;

    private Integer roleid;

    private Integer menuid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}