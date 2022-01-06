package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Admin;
import cn.edu.tongji.easygo.repository.AdminRepository;
import cn.edu.tongji.easygo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin login(Long adminId, String adminPassword) {
        Admin admin = adminRepository.findByAdminIdAndAdminPassword(adminId, adminPassword);
        if(admin!=null)
            return admin;
        else
            return null;
    }
}
