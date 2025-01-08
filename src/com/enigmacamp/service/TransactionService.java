package com.enigmacamp.service;

import com.enigmacamp.entity.dto.request.TransactionDetailRequest;
import com.enigmacamp.entity.dto.request.TransactionRequest;

import java.util.List;

public interface TransactionService {
    void create(TransactionRequest transactionRequest);
    void createTrxDetail(TransactionDetailRequest transactionDetailRequest);
}
