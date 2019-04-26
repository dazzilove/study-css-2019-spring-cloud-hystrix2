package com.example.product.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(value = "/product/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "product print > " + message;
    }
}
