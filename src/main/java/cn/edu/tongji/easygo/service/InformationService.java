package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.model.Information;

import java.util.List;

public interface InformationService {

    void addInformation(Information information);

    void deleteInformation(Long informationId);

    Information showInformation(Long informationId);

    void updateInformation(Long informationId,Information information);

    List<Information> findInformationByType(Integer informationType);

    List<Information> findInformationByUser(Long userId);

    List<Information> findInformationByTypeAndContent(Integer informationType, String content);

    List<Information> findInformationByKeyword(String keyword);
}
