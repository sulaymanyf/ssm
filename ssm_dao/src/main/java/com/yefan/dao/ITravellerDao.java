package com.yefan.dao;

import com.yefan.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select  * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findTravellerById(String ordersId) throws Exception;
}
