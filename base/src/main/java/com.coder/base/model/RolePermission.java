package com.coder.base.model;

import java.io.Serializable;

public class RolePermission extends BaseModel implements Serializable {

    private static final long serialVersionUID = 8406529315299707809L;

    private Integer rid;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}