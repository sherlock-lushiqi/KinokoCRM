package com.lushiqi.kinokocrm.controller;


import cn.hutool.core.bean.BeanUtil;
import com.lushiqi.kinokocrm.commonutils.vo.ResultVo;
import com.lushiqi.kinokocrm.dao.ProductsRepository;
import com.lushiqi.kinokocrm.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ProductsController {
    @Autowired
    ProductsRepository productRepository;

    @GetMapping(value = "/products.html")
    public String products(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageParam = PageRequest.of(pageNum, pageSize);
        Page<Products> page = productRepository.findAll(pageParam);
        model.addAttribute("products",page);
        return "products";
    }

    @ResponseBody
    public ResultVo toProductEdit(Integer id){
        Optional<Products> byID = productRepository.findById(id);
        return ResultVo.ok().data("products",byID);
    }

    @ResponseBody
    @RequestMapping("/productEdit")
    public ResultVo edit(Products products){
        if (products.getProductid() != null) {
            Optional<Products> byID = productRepository.findById(products.getProductid());
            if (byID.isPresent()) {
                Products products1 = byID.get();
                BeanUtil.copyProperties(products, products1);
                productRepository.save(products1);
            }

        }else {
                productRepository.save(products);
        }
        return ResultVo.ok();
    }

    @ResponseBody
    @RequestMapping("/productDelete")
    public ResultVo del(Integer id){
        productRepository.deleteById(id);
        return ResultVo.ok();
    }

//    @ResponseBody
//    @RequestMapping("/toAdd")
//    public ResultVo add(){
//        return "products-add";
//    }
}
