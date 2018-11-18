package com.yefan.dao;

import com.yefan.domain.Member;
import com.yefan.domain.Orders;
import com.yefan.domain.Product;
import com.yefan.domain.Traveller;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/11
 */

public interface IOrdersDao {

    @Select("select * from orders")
    @Results(value = {
            @Result(id = true, property = "id" ,column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc" ,column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class , one=@One(select = "com.yefan.dao.IProductDao.findProductById")),
    })
    public List<Orders> findAll() throws Exception;


    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime" ,column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc" ,column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class , one=@One(select = "com.yefan.dao.IProductDao.findProductById")),
            @Result(property = "travellers",column = "id", javaType = java.util.List.class, many=@Many(select = "com.yefan.dao.ITravellerDao.findTravellerById")),
            @Result(property = "member",column = "memberID", javaType = Member.class,one=@One(select ="com.yefan.dao.IMemberDao.findMemberById" ))
    })
    Orders findOrderById(String ordersId) throws Exception;

}
