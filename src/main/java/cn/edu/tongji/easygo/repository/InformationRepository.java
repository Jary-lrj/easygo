package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Long> {

    Information findByInformationId(Long informationId);

}