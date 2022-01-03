package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information,Long> {

    Information findByInformationId(Long informationId);

    List<Information> findInformationsByInformationType(Integer informationType);

    List<Information> findInformationsByInformationUserId(Long userId);

    @Query(value = "select * from information where information_type=?1 " +
            "and information_name like %?2%" ,nativeQuery = true)
    List<Information> findByTypeAndContent(Integer informationType, String content);
}