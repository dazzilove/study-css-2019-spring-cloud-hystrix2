package com.example.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCustomerByNoFallback")
    public String getCustomerByNo(String customerNo) {
        return (String) restTemplate.getForObject("http://localhost:2003/customer/" + customerNo, String.class);
    }

    private String getCustomerByNoFallback(String customerNo) {
        return "CustomerNo > " + customerNo;
    }
}
