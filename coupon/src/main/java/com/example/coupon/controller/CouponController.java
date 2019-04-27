package com.example.coupon.controller;

import com.example.coupon.bean.Coupon;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CouponController {
    private static final Map<String, Coupon> coupons = new HashMap<String, Coupon>() {
        private static final long serialVersionUID = -1L;
        {
            put("1", new Coupon("1", "Coupon1", 30));
            put("2", new Coupon("2", "Coupon2", 25));
        }
    };
    @RequestMapping(value = "/coupon/customerCouponList/{customerNo}", method = RequestMethod.GET)
    public String print(@PathVariable("customerNo") String customerNo) {
        return coupons.get(customerNo).toString();
    }
}
