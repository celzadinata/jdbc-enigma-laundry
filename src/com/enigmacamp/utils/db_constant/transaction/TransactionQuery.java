package com.enigmacamp.utils.db_constant.transaction;

public enum TransactionQuery {
    INSERT("INSERT INTO transactions(customer_id, date) values(?, ?) RETURNING id"),
    GET_ALL("SELECT * FROM transactions");

    private final String query;

    TransactionQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
