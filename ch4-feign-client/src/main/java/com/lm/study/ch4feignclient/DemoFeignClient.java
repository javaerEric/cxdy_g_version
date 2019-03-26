package com.lm.study.ch4feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : duozl
 * @date : 2019/3/11 10:21
 */
@FeignClient(value = "ch4-feign-server", fallback = DemoFeignClientImpl.class)
public interface DemoFeignClient {

    @GetMapping(value = "/user/save")
    String saveUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "age") Integer age);

    @PostMapping(value = "update/user")
    String updateUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "age") Integer age);

    @GetMapping(value = "/user/save2")
    String saveUser2(User user);

    @PostMapping(value = "update/user2")
    String updateUser2(User user);
}
