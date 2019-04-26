package com.example.product.bean;

public class Product {
    String productNo;
    String productNm;

    public Product(String productNo, String productNm) {
        this.productNo = productNo;
        this.productNm = productNm;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductNm() {
        return productNm;
    }

    public void setProductNm(String productNm) {
        this.productNm = productNm;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", productNm='" + productNm + '\'' +
                '}';
    }
}
