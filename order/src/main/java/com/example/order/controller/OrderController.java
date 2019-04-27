package com.example.order.controller;

import com.example.order.service.CustomerService;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/order/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "order print > " + message;
    }

    @RequestMapping(value = "/order/{customerNo}/{productNo}", method = RequestMethod.GET)
    public String createOrder(@PathVariable("customerNo") String customerNo, @PathVariable("productNo") String productNo) {
        String productInfo = productService.getProductByNo(productNo);
        String customerInfo = customerService.getCustomerByNo(customerNo);
        return "Create Order<div style='padding-left:10px'>" + customerInfo + "</div><div style='padding-left:10px'>" + productInfo + "</div>";
    }
}
