package com.tyw.service;

import com.tyw.domian.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by tboss on 2017/11/12.
 */
public interface UserService {
    public User findOne(Integer id);
    public User save(User user);
    public void delete(Integer id);
    public List<User> findAll();
}
