package com.enigmacamp.service.impl;

import com.enigmacamp.config.DBConnector;
import com.enigmacamp.entity.Customer;
import com.enigmacamp.entity.Product;
import com.enigmacamp.entity.dto.request.TransactionDetailRequest;
import com.enigmacamp.entity.dto.request.TransactionRequest;
import com.enigmacamp.entity.dto.response.TransactionDetailResponse;
import com.enigmacamp.entity.dto.response.TransactionResponse;
import com.enigmacamp.service.CustomerService;
import com.enigmacamp.service.ProductService;
import com.enigmacamp.service.TransactionService;
import com.enigmacamp.utils.db_constant.transaction.TransactionColumn;
import com.enigmacamp.utils.db_constant.transaction.TransactionQuery;
import com.enigmacamp.utils.db_constant.transaction_detail.TransactionDetailQuery;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private List<TransactionDetailRequest> trxDetail = new ArrayList<>();
    private ProductService productService = new ProductServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();

    public List<TransactionDetailRequest> getTrxDetail() {
        return trxDetail;
    }

    public void setTrxDetail(TransactionDetailRequest transactionDetailRequest) {
        getTrxDetail().add(transactionDetailRequest);
    }

    @Override
    public void create(TransactionRequest transactionRequest) {
        TransactionRequest request = transactionRequest;
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatementTransaction = connection.prepareStatement(TransactionQuery.INSERT.getQuery());
                PreparedStatement preparedStatementTransactionDetail = connection.prepareStatement(TransactionDetailQuery.INSERT.getQuery());
        ){
            preparedStatementTransaction.setInt(1, transactionRequest.getCustomerId());
            preparedStatementTransaction.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            ResultSet resultSetTransaction = preparedStatementTransaction.executeQuery();

            resultSetTransaction.next();
            Integer idTransaction = resultSetTransaction.getInt(TransactionColumn.ID.getColumnName());


            List<TransactionDetailRequest> transactionDetailRequests = transactionRequest.getTrxDetails();
            List<TransactionDetailResponse> transactionDetailResponses = new ArrayList<>();
            final Integer[] total = {0};
            transactionDetailRequests.stream()
                    .forEach(item -> {
                        try {
                            Product product = productService.getById(item.getProductId());
                            preparedStatementTransactionDetail.setInt(1, idTransaction);
                            preparedStatementTransactionDetail.setInt(2, item.getProductId());
                            preparedStatementTransactionDetail.setInt(3, product.getPrice());
                            preparedStatementTransactionDetail.setInt(4, item.getQty());
                            ResultSet resultSetTransactionDetail = preparedStatementTransactionDetail.executeQuery();
                            transactionDetailResponses.add(new TransactionDetailResponse(product.getName(), product.getPrice(), item.getQty(), product.getPrice() * item.getQty()));
                            total[0] = total[0] + (product.getPrice() * item.getQty());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });
            Customer customer = customerService.getById(transactionRequest.getCustomerId());
            TransactionResponse transactionResponse = new TransactionResponse(java.time.LocalDate.now().toString(), customer.getName(), transactionDetailResponses, total[0]);
            // Response Trx
            structResponse(transactionResponse, customer, total);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        getTrxDetail().clear();
    }

    private static void structResponse(TransactionResponse transactionResponse, Customer customer, Integer[] total) {
        System.out.println("\n\n========================= Transaksi Berhail Dibuat =========================");
        System.out.println(transactionResponse.getDate());
        System.out.println("Customer =================================");
        System.out.println("Name : " + customer.getName());
        System.out.println("Phone Number : " + customer.getPhone_number());
        System.out.println("Paket =================================");
        transactionResponse.getTrxDetails().stream()
                .forEach(item -> {
                    System.out.printf("%-10s :%-5d| %-15d %-2s = %d\n", item.getProductName(), item.getProductPrice(), item.getQty(), "Total", item.getSubtotal());
                });
        System.out.printf("%-35s = %-25d\n", "Total Pembayaran", total[0]);
        System.out.println("=========================       Terima Kasih !      =========================");
    }

    @Override
    public void createTrxDetail(TransactionDetailRequest transactionDetailRequest) {
        setTrxDetail(transactionDetailRequest);
    }
}
