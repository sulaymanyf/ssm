package com.yefan.service.impl;

import com.github.pagehelper.PageHelper;
import com.yefan.dao.IProductDao;
import com.yefan.domain.Product;
import com.yefan.service.IProductService;
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
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iproductDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return iproductDao.findAll();
    }

    @Override
    public void addProduct(Product product) throws Exception {
        iproductDao.addProduct(product);
    }
}
