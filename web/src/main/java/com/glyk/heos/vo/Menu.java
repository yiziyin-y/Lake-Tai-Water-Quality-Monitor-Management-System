package com.glyk.heos.vo;

import java.util.List;

public class Menu {
    private String id;
    private String name;
    private String url;
    private String icon;
    private List<Menu> subMenus;

    public Menu(){

    }
    public Menu(String id, String name,String url,String icon,List<Menu> subMenus){
        this.id = id;
        this.name=name;
        this.url=url;
        this.icon=icon;
        this.subMenus=subMenus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }
}
