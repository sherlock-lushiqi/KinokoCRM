package com.lushiqi.kinokocrm.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lushiqi.kinokocrm.commonutils.vo.ResultVo;
import com.lushiqi.kinokocrm.dao.SalesRepository;
//import com.lushiqi.kinokocrm.entity.sales;
import com.lushiqi.kinokocrm.entity.Sales;
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
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @GetMapping("/sales.html")
    public String sales(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        PageRequest pageParam = PageRequest.of(pageNum, pageSize);
        Page<Sales> page = salesRepository.findAll(pageParam);
        model.addAttribute("sales",page);
        return "sales";
    }

    @ResponseBody
    public ResultVo toSaleEdit(Integer id){
        Optional<Sales> byID = salesRepository.findById(id);
        return ResultVo.ok().data("sales",byID);
    }

    @ResponseBody
    @RequestMapping("/salesEdit")
    public ResultVo edit(Sales sales){
        if (sales.getSaleid() != null) {
            Optional<Sales> byID = salesRepository.findById(sales.getSaleid());
            if (byID.isPresent()) {
                Sales sales1 = byID.get();
                BeanUtil.copyProperties(sales, sales1);
                salesRepository.save(sales1);
            }

        }else {
            salesRepository.save(sales);
        }
        return ResultVo.ok();
    }

    @ResponseBody
    @RequestMapping("/salesDelete")
    public ResultVo delete(Integer id){
        salesRepository.deleteById(id);
        return ResultVo.ok();
    }
}
