package com.tyw.controller;

import com.tyw.domian.Result;
import com.tyw.domian.User;
import com.tyw.enums.ResultEnum;
import com.tyw.exception.UserException;
import com.tyw.service.UserService;
import com.tyw.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by tboss on 2017/11/10.
 */
@RestController
@Api(value = "userApi")
public class UserController {
    @Autowired
    private UserService userService;
    /*查询用户列表*/
    @GetMapping("/users")
    @ApiOperation(value = "users" ,notes = "users list")
    public List<User> userList(){
        return userService.findAll();
    }
    @PostMapping("/users")
    @ApiOperation(value = "users" ,notes = "users insert")
    public Result<User> addUser(@RequestParam("username") String username,
                          @RequestParam("password") String pwd)throws UserException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        user.setState("初始化");
        user.setCreateTime(new Date());
        if(user.getPassword().equals(user.getUsername())){
            throw new UserException(ResultEnum.CANNOTSAME);
        }
        return ResultUtil.success(userService.save(user));
    }
    @DeleteMapping("/users")
    public void delUser(@RequestParam("id") Integer id){
        userService.delete(id);
    }
    /*查询用户*/
    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id){
        return userService.findOne(id);
    }
}
