package com.example.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getProductByNoFallback",
        commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")
        })
    public String getProductByNo(String productNo) {
        return (String) restTemplate.getForObject("http://localhost:2002/product/" + productNo, String.class);
    }

    private String getProductByNoFallback(String productNo) {
        return "ProductNo > " + productNo;
    }
}
