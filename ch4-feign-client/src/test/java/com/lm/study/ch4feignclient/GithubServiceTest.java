package com.lm.study.ch4feignclient;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : duozl
 * @date : 2019/3/8 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch4FeignClientApplication.class)
public class GithubServiceTest {

    @Rule
    public final SystemOutRule outRule = new SystemOutRule().enableLog().muteForSuccessfulTests();

    @Autowired
    private GithubService githubService;

    @Test
    public void searchRepositories() {
        String repositories = githubService.searchRepositories("spring-cloud-gray");
//        repositories = githubService.searchRepositories("spring-cloud-gray");
        System.out.println(repositories);
        String outRuleLog = outRule.getLog();
        System.err.println(outRuleLog.length());
    }
}