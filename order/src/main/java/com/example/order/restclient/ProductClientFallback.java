package com.example.order.restclient;

import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String getProductByNo(String productNo) {
        return "Feign ProductClientFallback Result";
    }
}
