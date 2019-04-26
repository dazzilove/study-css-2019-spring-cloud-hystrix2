package com.example.product.controller;

import com.example.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class ProductController {
    private static final Map<String, Product> products = new HashMap<String, Product>() {
        private static final long serialVersionUID = -1L;
        {
            put("1", new Product("1", "Customer1"));
            put("2", new Product("2", "Customer2"));
        }
    };

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/product/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "product print > " + message;
    }

    @RequestMapping(value = "/product/{productNo}", method = RequestMethod.GET)
    public String getProductByNo(@PathVariable("productNo") String productNo) throws InterruptedException {
        Random random = new Random();
        int delay = random.nextInt(2);
        if (delay >= 1) {
            Long.parseLong("test");
        }
        return products.get(productNo).toString();
    }
}
