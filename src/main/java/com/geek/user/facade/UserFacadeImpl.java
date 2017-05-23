package com.geek.user.facade;

import com.geek.user.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 * 对外提供服务的接口
 */

@Service
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserRepository userRepository;

    public Long login(String userName, String password) {
        return userRepository.findIdByUserNameAndPassword(userName, password);
    }
}
