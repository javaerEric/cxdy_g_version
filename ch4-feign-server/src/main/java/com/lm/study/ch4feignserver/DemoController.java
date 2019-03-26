package com.lm.study.ch4feignserver;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : duozl
 * @date : 2019/3/8 17:40
 */
@RestController
public class DemoController {

    @GetMapping(value = "/user/save")
    public String saveUser(String userName, Integer age, HttpServletRequest request) {
        return "Hello " + userName + ", age " + age + ", from " + request.getServerPort();
    }

    @PostMapping(value = "update/user")
    public String updateUser(String userName, Integer age, HttpServletRequest request) {
        return "update " + userName + ", age " + age + ", from " + request.getServerPort();
    }

    @GetMapping(value = "/user/save2")
    public String saveUser2(User user, HttpServletRequest request){
        return "Hello " + user.getUserName() + ", age " + user.getAge() + ", from " + request.getServerPort();
    }

    @PostMapping(value = "update/user2")
    public String updateUser2(@RequestBody User user, HttpServletRequest request) {
        return "update " + user.getUserName() + ", age " + user.getAge() + ", from " + request.getServerPort();
    }
}
