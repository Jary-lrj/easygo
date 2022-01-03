package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Information;

public interface InformationService {

    void addInformation(Information information);

    void deleteInformation(Long informationId);

    Information showInformation(Long informationId);

    void updateInformation(Information information);


}
