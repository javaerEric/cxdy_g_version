package com.lm.study.ch4feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : duozl
 * @date : 2019/3/11 10:24
 */
@RestController
public class DemoFeignController {

    @Autowired
    private DemoFeignService service;

    @RequestMapping(value = "/user/save")
    public String addUser(String userName, Integer age) {
        return service.addUser(userName, age);
    }

    @RequestMapping(value = "/user/update")
    public String updateUser(String userName, Integer age) {
        return service.updateUser(userName, age);
    }

    @RequestMapping(value = "/user/save2")
    public String addUser2(String userName, Integer age) {
        return service.addUser2(userName, age);
    }

    @RequestMapping(value = "/user/update2")
    public String updateUser2(String userName, Integer age) {
        return service.updateUser2(userName, age);
    }

    @RequestMapping(value = "/hystrix/test")
    public String hystrixTest(String name) throws Exception {
        return service.hystrixTest(name);
    }
}
