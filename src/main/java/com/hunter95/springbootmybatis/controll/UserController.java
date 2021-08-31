package com.hunter95.springbootmybatis.controll;

import com.hunter95.springbootmybatis.mapper.UserMapper;
import com.hunter95.springbootmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList=userMapper.queryUserList();
        return userList;
    }

    //根据id查询用户
    @GetMapping("/queryUserById")
    public User queryUserById(){
        User user=userMapper.queryUserById(5);
        return user;
    }
    //添加用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"zhangsan","12345"));
        return "ok";
    }

    //修改用户
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"zhangsan","54321"));
        return "ok";
    }

    //根据id删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "ok";
    }

}
