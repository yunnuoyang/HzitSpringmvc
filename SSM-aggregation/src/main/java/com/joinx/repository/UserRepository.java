package com.joinx.repository;

import com.joinx.mapper.IUserMapper;
import com.joinx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepository {
    @Autowired
    IUserMapper userMapper;
    public User getUserByID(Integer id){
        return userMapper.getUserByID(id);
    }
}
