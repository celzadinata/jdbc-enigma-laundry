package com.enigmacamp.entity.dto.response;

import java.util.List;

public class TransactionResponse {
    private String date;
    private String customerName;
    private List<TransactionDetailResponse> trxDetails;
    private Integer total;
}
