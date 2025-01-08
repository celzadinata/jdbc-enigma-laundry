package com.enigmacamp.service.impl;

import com.enigmacamp.config.DBConnector;
import com.enigmacamp.entity.Product;
import com.enigmacamp.service.ProductService;
import com.enigmacamp.utils.db_constant.product.ProductColumn;
import com.enigmacamp.utils.db_constant.product.ProductQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public Product create(Product product) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(ProductQuery.INSERT.getQuery());
                ){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Integer id = resultSet.getInt(ProductColumn.ID.getColumnName());
            product.setId(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (
                Connection connect = DBConnector.getConnection();
                PreparedStatement preparedStatement = connect.prepareStatement(ProductQuery.GET_ALL.getQuery());
                ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(ProductColumn.ID.getColumnName()));
                product.setName(resultSet.getString(ProductColumn.NAME.getColumnName()));
                product.setPrice(resultSet.getInt(ProductColumn.PRICE.getColumnName()));
                products.add(product);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product getById(Integer id_product) {
        return null;
    }

    @Override
    public Boolean delete(Integer id_product) {
        return null;
    }
}
