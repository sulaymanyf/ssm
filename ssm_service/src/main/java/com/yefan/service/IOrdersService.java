package com.yefan.service;

import com.yefan.domain.Orders;

import java.util.List;

public interface IOrdersService {



    public List<Orders> findAll(int page,int size) throws Exception;

    Orders findOrderById(String ordersId) throws Exception;
}
