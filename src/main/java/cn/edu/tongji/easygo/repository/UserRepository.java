package cn.edu.tongji.easygo.repository;

import cn.edu.tongji.easygo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    User findByUserIdAndUserPassword(Long userId, String password);

    @Transactional
    void deleteByUserId(Long userId);
}
