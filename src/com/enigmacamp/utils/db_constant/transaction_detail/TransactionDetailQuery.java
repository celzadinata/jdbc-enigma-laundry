package com.enigmacamp.utils.db_constant.transaction_detail;

public enum TransactionDetailQuery {
    INSERT("INSERT INTO trx_details(transaction_id, product_id, price, qty) values(?, ?, ?, ?) RETURNING id"),
    GET_ALL("SELECT * FROM trx_details");

    private final String query;

    TransactionDetailQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
