package com.example.order.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product", url="http://localhost:2002", fallback = ProductClientFallback.class)
public interface ProductClient {
    @RequestMapping(value = "/product/{productNo}", method = RequestMethod.GET)
    public String getProductByNo(@PathVariable("productNo") String productNo);
}
