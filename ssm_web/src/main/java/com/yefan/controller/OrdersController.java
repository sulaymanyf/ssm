package com.yefan.controller;

import com.github.pagehelper.PageInfo;
import com.yefan.domain.Orders;
import com.yefan.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/11
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = iOrdersService.findAll(page, size);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        System.out.println(pageInfo + "sssssssssssss");
        mv.addObject("ordersList", ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("order-list");

        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders order = iOrdersService.findOrderById(ordersId);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }

}
