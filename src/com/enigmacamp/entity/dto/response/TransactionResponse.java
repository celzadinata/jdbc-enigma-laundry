package com.enigmacamp.entity.dto.response;

import java.util.List;

public class TransactionResponse {
    private String date;
    private String customerName;
    private List<TransactionDetailResponse> trxDetails;
    private Integer total;

    public TransactionResponse(String date, String customerName, List<TransactionDetailResponse> trxDetails, Integer total) {
        this.date = date;
        this.customerName = customerName;
        this.trxDetails = trxDetails;
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<TransactionDetailResponse> getTrxDetails() {
        return trxDetails;
    }

    public void setTrxDetails(List<TransactionDetailResponse> trxDetails) {
        this.trxDetails = trxDetails;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", trxDetails=" + trxDetails +
                ", total=" + total +
                '}';
    }
}
