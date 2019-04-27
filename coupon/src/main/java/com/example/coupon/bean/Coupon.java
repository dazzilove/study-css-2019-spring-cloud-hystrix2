package com.example.coupon.bean;

public class Coupon {
    String couponNo;
    String name;
    int discountRate;

    public Coupon(String couponNo, String name, int discountRate) {
        this.couponNo = couponNo;
        this.name = name;
        this.discountRate = discountRate;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "Coupon {" +
                "couponNo='" + couponNo + '\'' +
                ", name='" + name + '\'' +
                ", discountRate=" + discountRate +
                '}';
    }
}
