package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {
    Complain findByComplainId(Long userId);
}
