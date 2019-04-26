package com.example.customer.controller;

import com.example.customer.bean.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class CustomerController {
    private static final Map<String, Customer> customers = new HashMap<String, Customer>() {
        private static final long serialVersionUID = -1L;
        {
            put("1", new Customer("1", "Customer1"));
            put("2", new Customer("2", "Customer2"));
        }
    };

    @RequestMapping(value = "/customer/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "customer print > " + message;
    }

    @RequestMapping(value = "/customer/{customerNo}", method = RequestMethod.GET)
    public String getProductByNo(@PathVariable("customerNo") String customerNo) throws InterruptedException {
        Random random = new Random();
        int delay = random.nextInt(8) * 1000;
        Thread.sleep(delay);
        return customers.get(customerNo).toString();
    }
}
