package com.glyk.heos.vo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by thoma on 2017/6/12.
 */
public class LoginStatus implements Serializable, HttpSessionBindingListener {
    String deptName;
    String adminName;
    String accountType;
    Long deptId;
    String address;
    String contactTel;
    String adminTel;
    String admin;
    String adminId;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    private static Map<LoginStatus, HttpSession> logins = new HashMap<LoginStatus, HttpSession>();

    @Override
    public boolean equals(Object other) {
        return (other instanceof LoginStatus) && (adminId != null) ? adminId.equals(((LoginStatus) other).adminId) : (other == this);
    }


    @Override
    public int hashCode() {
        return (adminId != null) ? (this.getClass().hashCode() + adminId.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = logins.remove(this);
        if (session != null && !accountType.equals("1")) {
            session.invalidate();
        }
        logins.put(this, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        logins.remove(this);
    }
}
