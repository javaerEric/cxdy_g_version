package com.lm.study.ch4feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : duozl
 * @date : 2019/3/8 16:54
 */
@FeignClient(name = "github", url = "https://api.github.com")
public interface GithubFeignClient {

    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepositories(@RequestParam(value = "q") String qureyStr);
}
