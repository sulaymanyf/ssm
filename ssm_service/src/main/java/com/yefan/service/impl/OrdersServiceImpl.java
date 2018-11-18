package com.yefan.service.impl;


import com.github.pagehelper.PageHelper;
import com.yefan.dao.IOrdersDao;
import com.yefan.domain.Orders;
import com.yefan.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/11
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return iOrdersDao.findAll();
}

    @Override
    public Orders findOrderById(String ordersId) throws Exception{
       return iOrdersDao.findOrderById(ordersId) ;
    }
}
