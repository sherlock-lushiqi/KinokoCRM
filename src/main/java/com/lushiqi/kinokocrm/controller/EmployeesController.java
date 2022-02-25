package com.lushiqi.kinokocrm.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lushiqi.kinokocrm.commonutils.vo.ResultVo;
import com.lushiqi.kinokocrm.dao.EmployeesRepository;
import com.lushiqi.kinokocrm.entity.Employees;
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
public class EmployeesController {
    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = "/employees.html")
    public String employees(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageRequest pageParam = PageRequest.of(pageNum, pageSize);
        Page<Employees> page = employeesRepository.findAll(pageParam);
        model.addAttribute("employees",page);
        return "employees";
    }

    @ResponseBody
    public ResultVo toEmployeeEdit(Integer id){
        Optional<Employees> byID = employeesRepository.findById(id);
        return ResultVo.ok().data("employees",byID);
    }

    @ResponseBody
    @RequestMapping("/employeeEdit")
    public ResultVo employeeEdit(Employees employees){
        if (employees.getEmployeeid() != null){
            Optional<Employees> byID = employeesRepository.findById(employees.getEmployeeid());
            if (byID.isPresent()){
                Employees employees1 = byID.get();
                BeanUtil.copyProperties(employees,employees1);
                employeesRepository.save(employees1);
            }
        }else {
            employeesRepository.save(employees);
        }
        return ResultVo.ok();
    }

    @ResponseBody
    @RequestMapping("/employeeDelete")
    public ResultVo del(Integer id){
        employeesRepository.deleteById(id);
        return ResultVo.ok();
    }
}
