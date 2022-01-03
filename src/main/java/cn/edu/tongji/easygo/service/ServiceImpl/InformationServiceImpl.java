package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Information;
import cn.edu.tongji.easygo.repository.InformationRepository;
import cn.edu.tongji.easygo.service.InformationService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationRepository informationRepository;

    @Override
    public void addInformation(Information information) {
        informationRepository.save(information);
    }

    @Override
    public void deleteInformation(Long informationId) {
        informationRepository.deleteById(informationId);
    }

    @Override
    public Information showInformation(Long informationId) {
        return informationRepository.findByInformationId(informationId);
    }

    @Override
    public void updateInformation(Information information) {
        Information originInformation = informationRepository.findByInformationId(information.getInformationId());
        JpaUtil.copyNotNullProperties(information,originInformation);
        informationRepository.save(originInformation);
    }
}
