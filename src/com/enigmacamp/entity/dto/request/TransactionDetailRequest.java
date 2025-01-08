package com.enigmacamp.entity.dto.request;

public class TransactionDetailRequest {
    private Integer productId;
    private Integer qty;

    public TransactionDetailRequest(Integer productId, Integer qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "TransactionDetailRequest{" +
                "productId=" + productId +
                ", qty=" + qty +
                '}';
    }
}
