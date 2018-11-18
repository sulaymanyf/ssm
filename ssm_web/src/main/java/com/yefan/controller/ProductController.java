package com.yefan.controller;

import com.github.pagehelper.PageInfo;
import com.yefan.domain.Product;
import com.yefan.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController  {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name ="page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = iProductService.findAll(page,size);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        System.out.println(products);
        mv.addObject("productList",products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/addProduct.do")
    public String addProduct(Product product) throws Exception {
        iProductService.addProduct(product);
        System.out.println(product);
        return "redirect:findAll.do";

    }

}
