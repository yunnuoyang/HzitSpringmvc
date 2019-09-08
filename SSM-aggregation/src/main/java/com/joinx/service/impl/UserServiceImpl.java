package com.joinx.service.impl;

import com.joinx.pojo.User;
import com.joinx.repository.UserRepository;
import com.joinx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
    @Override
    public User getUserByID(Integer id) {
        return userRepository.getUserByID(id);
    }
}
