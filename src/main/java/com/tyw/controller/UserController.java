package com.tyw.controller;

import com.tyw.domian.User;
import com.tyw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by tboss on 2017/11/10.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    /*查询用户列表*/
    @GetMapping("/users")
    public List<User> userList(){
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User addUser(@RequestParam("username") String username,
                        @RequestParam("password") String pwd){
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setState(1);
        user.setCreateTime(new Date());
        return userRepository.save(user);
    }
    @DeleteMapping("/users")
    public void delUser(@RequestParam("id") Integer id){
        userRepository.delete(id);
    }
    /*查询用户*/
    @GetMapping("/users/{id}")
    public User findUser(@RequestParam(value = "id") Integer id){
        return userRepository.findOne(id);
    }
}
