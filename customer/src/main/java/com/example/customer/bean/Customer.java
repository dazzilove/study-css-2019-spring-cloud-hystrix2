package com.example.customer.bean;

public class Customer {
    String customerNo;
    String name;

    public Customer(String customerNo, String name) {
        this.customerNo = customerNo;
        this.name = name;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "customerNo='" + customerNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
