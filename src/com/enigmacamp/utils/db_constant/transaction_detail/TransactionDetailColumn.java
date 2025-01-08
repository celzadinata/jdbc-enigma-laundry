package com.enigmacamp.utils.db_constant.transaction_detail;

public enum TransactionDetailColumn {
    ID("id"),
    TRANSACTION_ID("transaction_id"),
    PRODUCT_ID("product_id"),
    PRICE("price"),
    QTY("qty");

    private final String columnName;

    TransactionDetailColumn(String columnName){
        this.columnName = columnName;
    }

    public String getColumnName(){
        return this.columnName;
    }
}
