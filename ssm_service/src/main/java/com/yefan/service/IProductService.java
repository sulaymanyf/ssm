package com.yefan.service;

import com.yefan.domain.Product;

import java.util.List;


public interface IProductService {

    List<Product> findAll(int page,int size) throws Exception;

    void addProduct(Product product) throws Exception;
}
