package com.enigmacamp.entity;

public class TransactionDetail {
    private Integer id;
    private Integer transactionId;
    private Integer productId;
    private Integer price;
    private Integer qty;

    public TransactionDetail(Integer transactionId, Integer productId, Integer price, Integer qty) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.price = price;
        this.qty = qty;
    }

    public TransactionDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "TransactionDetail{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", productId=" + productId +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
