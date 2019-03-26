package com.lm.study.ch4feignclient;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableHystrix
@EnableFeignClients
@SpringCloudApplication
public class Ch4FeignClientApplication {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch4FeignClientApplication.class, args);
    }

}
