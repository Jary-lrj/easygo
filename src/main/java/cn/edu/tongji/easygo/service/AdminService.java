package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin login(Long adminId, String adminPassword);
}
