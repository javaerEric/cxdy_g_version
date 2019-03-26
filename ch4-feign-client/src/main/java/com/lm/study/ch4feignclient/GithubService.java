package com.lm.study.ch4feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : duozl
 * @date : 2019/3/8 16:58
 */
@Service
public class GithubService {

    @Autowired
    private GithubFeignClient githubFeignClient;

    public String searchRepositories(String queryStr){
        return githubFeignClient.searchRepositories(queryStr);
    }
}
