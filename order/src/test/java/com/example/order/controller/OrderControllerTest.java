package com.example.order.controller;

import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Random;

public class OrderControllerTest {
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testOrder() throws InterruptedException {
        for(int i=0; i<1000; i++) {
            sendAndAcceptOrder();
            Thread.sleep(100);
        }
    }

    private void sendAndAcceptOrder() {
        try {
            Random r = new Random();
            String customerNo = String.valueOf(r.nextInt(2)+1);
            String productNo = String.valueOf(r.nextInt(2)+1);
            restTemplate.getForObject("http://localhost:2001/order/"  + customerNo +"/" + productNo, String.class);
        } catch(Exception e) {

        }
    }
}
