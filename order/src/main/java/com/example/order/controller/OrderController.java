package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/order/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "order print > " + message;
    }

    @RequestMapping(value = "/order/{customerNo}/{productNo}", method = RequestMethod.GET)
    public String createOrder(@PathVariable("customerNo") String customerNo, @PathVariable("productNo") String productNo) {
        String productInfo = (String) restTemplate.getForObject("http://localhost:2002/product/" + productNo, String.class);
        String customerInfo = (String) restTemplate.getForObject("http://localhost:2003/customer/" + customerNo, String.class);
        return "Create Order <br>&nbsp;&nbsp;" + customerInfo + "<br>&nbsp;&nbsp;" + productInfo;
    }
}
