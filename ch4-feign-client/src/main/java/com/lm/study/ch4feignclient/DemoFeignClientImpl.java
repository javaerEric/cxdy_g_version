package com.lm.study.ch4feignclient;

import org.springframework.stereotype.Component;

/**
 * @author : duozl
 * @date : 2019/3/11 15:55
 */
@Component
public class DemoFeignClientImpl implements DemoFeignClient {
    @Override
    public String saveUser(String userName, Integer age) {
        return "服务挂了";
    }

    @Override
    public String updateUser(String userName, Integer age) {
        return "服务挂了";
    }

    @Override
    public String saveUser2(User user) {
        return "服务挂了";
    }

    @Override
    public String updateUser2(User user) {
        return "服务挂了";
    }
}
