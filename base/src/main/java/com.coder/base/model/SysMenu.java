package com.coder.base.model;

import java.io.Serializable;
import java.util.List;

public class SysMenu extends BaseModel implements Serializable {

    private static final long serialVersionUID = -8586375203691764512L;
    
    private Integer id;

    private String name;

    private String icon;

    private Integer pid;

    private String url;

    private Integer order;

    private List<SysMenu> childrenMenus;

    private Boolean show = false;

    public Boolean getShow(){
        return this.show;
    }

    public void setShow(Boolean show){
        this.show = show;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<SysMenu> getChildrenMenus() {
        return childrenMenus;
    }

    public void setChildrenMenus(List<SysMenu> childrenMenus) {
        this.childrenMenus = childrenMenus;
    }
}