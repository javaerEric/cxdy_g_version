package com.lm.study.ch4feignclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : duozl
 * @date : 2019/3/11 10:23
 */
@Service
public class DemoFeignService {

    @Autowired
    private DemoFeignClient feignClient;

    public String addUser(String userName, Integer age) {
        return feignClient.saveUser(userName, age);
    }

    public String updateUser(String userName, Integer age) {
        return feignClient.updateUser(userName, age);
    }

    public String addUser2(String userName, Integer age) {
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        return feignClient.saveUser2(user);
    }

    public String updateUser2(String userName, Integer age) {
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        return feignClient.updateUser2(user);
    }

    @HystrixCommand(fallbackMethod = "defaultHystrixText")
    public String hystrixTest(String name) throws Exception {
        if("spring".equals(name)){
            return "hello spring";
        }else {
            throw new Exception();
        }
    }

    public String defaultHystrixText(String name){
        return "请传入spring!";
    }
}
