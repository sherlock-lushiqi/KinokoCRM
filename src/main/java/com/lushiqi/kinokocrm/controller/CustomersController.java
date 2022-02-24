package com.lushiqi.kinokocrm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.lushiqi.kinokocrm.commonutils.vo.ResultVo;
import com.lushiqi.kinokocrm.dao.CustomersRepository;
import com.lushiqi.kinokocrm.entity.Customers;
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
public class CustomersController {
    @Autowired
    CustomersRepository customersRepository;

    @GetMapping(value = {"/customers.html"})
    public String customers(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageParam = PageRequest.of(pageNum, pageSize);
        Page<Customers> page = customersRepository.findAll(pageParam);
        model.addAttribute("customers", page);
        return "customers";
    }

 /*   @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        Optional<Customers> byId = customersRepository.findById(id);
        model.addAttribute("customers", byId.get());
        return "customers-add";
    }*/
    @ResponseBody
    public ResultVo toCustomerEdit(Integer id) {
        Optional<Customers> byId = customersRepository.findById(id);
        return ResultVo.ok().data("customers",byId);
    }

/*
    @RequestMapping("/edit")
    public String edit(Customers customers,Model model) {
        if(StrUtil.isNotEmpty(customers.getCustomerPhone())){
            if(!customers.getCustomerPhone().matches("[\\d-]{6,12}")){
                model.addAttribute("msg", "电话号码为最多12位的数字或数字加'-'");
                model.addAttribute("customers", customers);
                return "customers-add";
            }
        }
        if (customers.getCustomerid() != null) {
            Optional<Customers> byId = customersRepository.findById(customers.getCustomerid());
            if (byId.isPresent()) {
                Customers customers1 = byId.get();
                BeanUtil.copyProperties(customers, customers1);
                customersRepository.save(customers1);
            }
        }else {
                customersRepository.save(customers);
        }
        return "redirect:/customers.html";
    }*/
    @ResponseBody
    @RequestMapping("/customerEdit")
    public ResultVo edit(Customers customers) {
        if (StrUtil.isNotEmpty(customers.getCustomerPhone())) {
            if (!customers.getCustomerPhone().matches("[\\d-]{6,12}")) {
                return ResultVo.error().message("电话号码为最多12位的数字或数字加'-'");
            }
        }
        if (customers.getCustomerid() != null) {
            Optional<Customers> byId = customersRepository.findById(customers.getCustomerid());
            if (byId.isPresent()) {
                Customers customers1 = byId.get();
                BeanUtil.copyProperties(customers, customers1);
                customersRepository.save(customers1);
            }
        }else {
                customersRepository.save(customers);
        }
        return ResultVo.ok();
    }

   /* @RequestMapping("/delete")
    public String delete(Integer id) {
        customersRepository.deleteById(id);
        return "redirect:/customers.html";
    }*/
   @ResponseBody
    @RequestMapping("/customerDelete")
    public ResultVo delete(Integer id) {
        customersRepository.deleteById(id);
        return ResultVo.ok();
    }

    @RequestMapping("/toAdd")
    public String add() {
        return "customers-add";
    }
}
