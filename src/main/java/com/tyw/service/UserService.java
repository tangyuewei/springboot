package com.tyw.service;

import com.tyw.domian.User;
import com.tyw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tboss on 2017/11/12.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findOne(Integer id){
        return userRepository.findOne(id);
    }
}
