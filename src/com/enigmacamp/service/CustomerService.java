package com.enigmacamp.service;

import com.enigmacamp.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> getAll();
    Customer getById(Integer id_customer);
    Customer getByPhone(String phone_customer);
}
