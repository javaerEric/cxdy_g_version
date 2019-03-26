package com.lm.study.ch4feignclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author : duozl
 * @date : 2019/3/11 14:22
 */
@Component
public class FeignRequestInter implements RequestInterceptor {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if("GET".equals(requestTemplate.method()) && null != requestTemplate.requestBody().asBytes()){
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if(null != requestAttributes) {
                HttpServletRequest request = requestAttributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();
                    String headerValue = request.getHeader(headerName);
                    requestTemplate.header(headerName, headerValue);
                }
            }

            try {
                JsonNode jsonNode = mapper.readTree(requestTemplate.requestBody().asBytes());
                requestTemplate.body(Request.Body.empty());
//                requestTemplate.headers(null);
                requestTemplate.header("convertBy", "auto");

                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(jsonNode, queries);
                requestTemplate.queries(queries);
            }catch (Exception e){

            }
        }
    }

    private void buildQuery(JsonNode jsonNode, Map<String, Collection<String>> queries) {
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()){
            String key = iterator.next();
            List<String> values = jsonNode.findValuesAsText(key);
            queries.put(key, values);
        }
        System.out.println(queries);
    }
}
