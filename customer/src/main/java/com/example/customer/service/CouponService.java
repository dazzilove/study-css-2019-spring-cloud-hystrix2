package com.example.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CouponService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCustomerCouponListFallback")
    public String getCustomerCouponList(String customerNo) {
        return (String) restTemplate.getForObject("http://localhost:2004/coupon/customerCouponList/" + customerNo, String.class);
    }

    private String getCustomerCouponListFallback(String customerNo) {
        return "Customer > CouponService > CustomerNo - " + customerNo;
    }
}
