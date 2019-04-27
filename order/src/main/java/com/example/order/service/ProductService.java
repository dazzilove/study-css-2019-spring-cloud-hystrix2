package com.example.order.service;

import com.example.order.restclient.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
    ProductClient productClient;

    public String getProductByNo(String productNo) {
        return (String) productClient.getProductByNo(productNo);
    }
}
