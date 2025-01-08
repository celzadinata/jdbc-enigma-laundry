package com.enigmacamp.service;

import com.enigmacamp.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    List<Product> getAll();
    Product getById(Integer id_product);
    Boolean delete(Integer id_product);
}
