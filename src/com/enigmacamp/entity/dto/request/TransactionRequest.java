package com.enigmacamp.entity.dto.request;

import java.util.List;

public class TransactionRequest {
    private Integer customerId;
    private List<TransactionDetailRequest> trxDetails;
}
