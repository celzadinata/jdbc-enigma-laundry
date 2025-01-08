package com.enigmacamp.console;

import com.enigmacamp.entity.Product;
import com.enigmacamp.entity.Transaction;
import com.enigmacamp.entity.dto.request.TransactionDetailRequest;
import com.enigmacamp.entity.dto.request.TransactionRequest;
import com.enigmacamp.service.ProductService;
import com.enigmacamp.service.TransactionService;
import com.enigmacamp.service.impl.ProductServiceImpl;
import com.enigmacamp.service.impl.TransactionServiceImpl;
import com.enigmacamp.utils.InputHandler;

import java.util.List;

public class TransactionConsole {
    private TransactionService services;
    private InputHandler inputHandler;
    private ProductService productService;
    private TransactionServiceImpl transactionService;

    public TransactionConsole(TransactionService service, InputHandler inputHandler) {
        this.services = service;
        this.inputHandler = inputHandler;
        this.productService = new ProductServiceImpl();
        this.transactionService = new TransactionServiceImpl();
    }

    private void showMenu(){
        System.out.println("\n==== Transaction Management ====");
        System.out.println("1. Add Transaction");
        System.out.println("2. Back");
    }

    public void run(){
        while (true){
            this.showMenu();
            int choice = inputHandler.getInt("Pilih Menu : ");
            switch (choice){
                case 1:
                    this.createNewTransaction();
                    break;

                case 2:
                    return;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void createNewTransaction(){
        System.out.println("\n==== Transaction Process ====");
        Integer customerId = this.inputHandler.getInt("Masukan Customer ID : ");
        createNewTransactionDetail(customerId);
    }

    private void createNewTransactionDetail(Integer customerId){
        trxDetailCreated();
        while (true){
            System.out.println("\n1. Tambah produk");
            System.out.println("2. Selesai");
            int choice = inputHandler.getInt("Pilih Menu : ");
            switch (choice){
                case 1:
                    trxDetailCreated();
                    break;

                case 2:
                    transactionService.create(new TransactionRequest(customerId, transactionService.getTrxDetail()));
                    return;

                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void trxDetailCreated() {
        List<Product> productList = this.productService.getAll();
        System.out.printf("_________________________________________\n");
        System.out.printf("|%-5s |%-20s |%-10s|\n", "ID", "Name", "Price");
        System.out.printf("_________________________________________\n");
        productList.stream().forEach(product -> {
            System.out.printf("|%-5s |%-20s |%-10s|\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice()
            );
        });
        System.out.printf("_________________________________________\n");
        Integer productId = this.inputHandler.getInt("Masukan ID Produk yang ingin dibeli : ");
        Integer productQty = this.inputHandler.getInt("Masukan banyaknya produk yang dibeli : ");
        transactionService.createTrxDetail(new TransactionDetailRequest(productId, productQty));
    }
}
