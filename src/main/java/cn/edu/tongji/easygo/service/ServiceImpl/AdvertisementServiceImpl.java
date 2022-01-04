package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.model.Advertisement;
import cn.edu.tongji.easygo.repository.AdvertisementRepository;
import cn.edu.tongji.easygo.service.AdvertisementService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Resource
    AdvertisementRepository advertisementRepository;

    @Override
    public boolean addAdvertisement(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        return true;
    }

    @Override
    public List<Advertisement> showAllAdvertisement() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement showConcreteAdvertisement(Long advertisementId) {
        return advertisementRepository.findByAdvertisementId(advertisementId);
    }

    @Override
    public boolean updateAdvertisement(Long advertisementId, Advertisement after) {
        Advertisement before = advertisementRepository.findByAdvertisementId(advertisementId);
        JpaUtil.copyNotNullProperties(after, before);
        advertisementRepository.save(before);
        return true;
    }

    @Override
    public void deleteAdvertisement(Long advertisementId) {
        advertisementRepository.deleteAdvertisementByAdvertisementId(advertisementId);
    }
}
