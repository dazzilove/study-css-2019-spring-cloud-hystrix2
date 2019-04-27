package com.example.customer.controller;

import com.example.customer.bean.Customer;
import com.example.customer.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CouponService couponService;

    @RequestMapping(value = "/customer/print/{message}", method = RequestMethod.GET)
    public String print(@PathVariable("message") String message) {
        return "customer print > " + message;
    }

    @RequestMapping(value = "/customer/{customerNo}", method = RequestMethod.GET)
    public String getProductByNo(@PathVariable("customerNo") String customerNo) throws InterruptedException {
        Random random = new Random();
        int delay = random.nextInt(8) * 1000;
        Thread.sleep(delay);

        String customerInfo = customers.get(customerNo).toString();
        String couponList = couponService.getCustomerCouponList(customerNo);

        return customerInfo + "<div style='padding-left:10px;'>" + couponList + "</div>";
    }
}
