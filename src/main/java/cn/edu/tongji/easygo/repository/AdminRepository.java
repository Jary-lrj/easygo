package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByAdminIdAndAdminPassword(Long adminId,String adminPassword);
}
