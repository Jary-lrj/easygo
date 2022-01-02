package cn.edu.tongji.easygo.service.ServiceImpl;

import cn.edu.tongji.easygo.dto.UserRegisterDTO;
import cn.edu.tongji.easygo.model.*;
import cn.edu.tongji.easygo.repository.*;
import cn.edu.tongji.easygo.service.UserService;
import cn.edu.tongji.easygo.util.JpaUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public User login(Long userId, String password) {
        if (userRepository.findByUserId(userId) != null) {
            if (userRepository.findByUserIdAndUserPassword(userId, password) != null)
                return userRepository.findByUserId(userId);
            else
                return null;
        }
        return null;
    }

    @Override
    public User register(UserRegisterDTO userRegisterDTO) {
        User registerUser = new User();
        registerUser.setUserId(userRegisterDTO.getUserId());
        registerUser.setUserName(userRegisterDTO.getUserName());
        registerUser.setUserPassword(userRegisterDTO.getUserPassword());
        registerUser.setUserPhonenumber(userRegisterDTO.getUserPhonenumber());
        if (userRepository.findByUserId(userRegisterDTO.getUserId()) != null)
            return null;
        userRepository.save(registerUser);
        return registerUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteByUserId(userId);
    }

    @Override
    public List<User> showAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User showConcreteUser(Long userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public User updateUser(User updateUserInfo) {
        User originUserInfo = userRepository.findByUserId(updateUserInfo.getUserId());
        JpaUtil.copyNotNullProperties(updateUserInfo, originUserInfo);
        return userRepository.save(originUserInfo);
    }
}
