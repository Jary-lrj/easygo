package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Complain;
import org.springframework.stereotype.Service;

@Service
public interface ComplainService {
    boolean addComplain(Complain complain);

    Complain showConcreteComplain(Long complainId);
}
