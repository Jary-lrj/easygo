package cn.edu.tongji.easygo.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@DynamicUpdate
@DynamicInsert
public class Admin {
    private long adminId;
    private String adminPassword;

    @Id
    @Column(name = "admin_id")
    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "admin_password")
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminId == admin.adminId && Objects.equals(adminPassword, admin.adminPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminPassword);
    }
}
