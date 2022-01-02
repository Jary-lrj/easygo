package cn.edu.tongji.easygo.service;

import cn.edu.tongji.easygo.dto.UserRegisterDTO;
import cn.edu.tongji.easygo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User login(Long userId, String password);

    public User register(UserRegisterDTO userRegisterDTO);

    public void deleteUser(Long userId);

    public List<User> showAllUser();

    public User showConcreteUser(Long userId);

    public User updateUser(User updateInfo);
}
