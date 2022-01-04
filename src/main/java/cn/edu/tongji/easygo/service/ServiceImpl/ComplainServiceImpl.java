package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Complain;
import cn.edu.tongji.easygo.repository.ComplainRepository;
import cn.edu.tongji.easygo.service.ComplainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Resource
    ComplainRepository complainRepository;

    @Override
    public boolean addComplain(Complain complain) {
        complainRepository.save(complain);
        return true;
    }

    @Override
    public Complain showConcreteComplain(Long complainId) {
        return complainRepository.findByComplainId(complainId);
    }
}
