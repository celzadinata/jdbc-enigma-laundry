package com.enigmacamp.service.impl;

import com.enigmacamp.config.DBConnector;
import com.enigmacamp.entity.Customer;
import com.enigmacamp.entity.Customer;
import com.enigmacamp.entity.Product;
import com.enigmacamp.service.CustomerService;
import com.enigmacamp.utils.db_constant.customer.CustomerColumn;
import com.enigmacamp.utils.db_constant.customer.CustomerQuery;
import com.enigmacamp.utils.db_constant.product.ProductColumn;
import com.enigmacamp.utils.db_constant.product.ProductQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer create(Customer customer) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(CustomerQuery.INSERT.getQuery());
        ){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone_number());
            preparedStatement.setString(4, customer.getBirth_date());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Integer id = resultSet.getInt(CustomerColumn.ID.getColumnName());
            customer.setId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (
                Connection connect = DBConnector.getConnection();
                PreparedStatement preparedStatement = connect.prepareStatement(CustomerQuery.GET_ALL.getQuery());
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(CustomerColumn.ID.getColumnName()));
                customer.setName(resultSet.getString(CustomerColumn.NAME.getColumnName()));
                customer.setAddress(resultSet.getString(CustomerColumn.ADDRESS.getColumnName()));
                customer.setPhone_number(resultSet.getString(CustomerColumn.PHONE.getColumnName()));
                customer.setBirth_date(resultSet.getString(CustomerColumn.BIRTH_DATE.getColumnName()));
                customers.add(customer);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customers;
    }

    @Override
    public Customer getById(Integer id_customer) {
        Customer customer = new Customer();
        try (
                Connection connect = DBConnector.getConnection();
                PreparedStatement preparedStatement = connect.prepareStatement(CustomerQuery.GET_BY_ID.getQuery());
        ){
            preparedStatement.setInt(1, id_customer);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer.setId(resultSet.getInt(CustomerColumn.ID.getColumnName()));
            customer.setName(resultSet.getString(CustomerColumn.NAME.getColumnName()));
            customer.setAddress(resultSet.getString(CustomerColumn.ADDRESS.getColumnName()));
            customer.setPhone_number(resultSet.getString(CustomerColumn.PHONE.getColumnName()));
            customer.setBirth_date(resultSet.getString(CustomerColumn.BIRTH_DATE.getColumnName()));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(customer);
        return customer;
    }

    @Override
    public Customer getByPhone(String phone_customer) {
        Customer customer = new Customer();
        try (
                Connection connect = DBConnector.getConnection();
                PreparedStatement preparedStatement = connect.prepareStatement(CustomerQuery.GET_BY_PHONE.getQuery());
        ){
            preparedStatement.setString(1, phone_customer);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer.setId(resultSet.getInt(CustomerColumn.ID.getColumnName()));
            customer.setName(resultSet.getString(CustomerColumn.NAME.getColumnName()));
            customer.setAddress(resultSet.getString(CustomerColumn.ADDRESS.getColumnName()));
            customer.setPhone_number(resultSet.getString(CustomerColumn.PHONE.getColumnName()));
            customer.setBirth_date(resultSet.getString(CustomerColumn.BIRTH_DATE.getColumnName()));

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
