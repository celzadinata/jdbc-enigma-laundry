package com.enigmacamp.entity.dto.response;

public class TransactionDetailResponse {
    private String productName;
    private Integer productPrice;
    private Integer qty;
    private Integer subtotal;

    public TransactionDetailResponse(String productName, Integer productPrice, Integer qty, Integer subtotal) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "TransactionDetailResponse{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", qty=" + qty +
                ", subtotal=" + subtotal +
                '}';
    }
}
