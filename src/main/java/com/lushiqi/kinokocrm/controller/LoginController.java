package com.lushiqi.kinokocrm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.lushiqi.kinokocrm.dao.*;
import com.lushiqi.kinokocrm.entity.*;
import com.lushiqi.kinokocrm.vo.SalesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class LoginController {
    @Autowired
    AccountsRepository accountsRepository;
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    EmployeesRepository employeeRepository;
    @Autowired
    ProductsRepository productRepository;
    @GetMapping(value = {"/login","/login.html"})
    public String loginPage(){
        return "login";
    }
    @GetMapping(value = {"/customers"})
    public String CustomersPage(){
        return "customers";
    }
    @GetMapping(value = {"/index.html"})
    public String Index(Model model){
        //找到最近交易的10个顾客
        List<Integer> integers = salesRepository.selectRecentCustomers();
        List<Customers> name = customersRepository.findAllById(integers);
        model.addAttribute("customers",name);

        //找到最近的10条订单
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("saleDate").descending());
//        Page<Sales> salesPage = salesRepository.findAll(pageable);
//        List<SalesVO> salesVOList = salesPage.get().map(e -> {
//            SalesVO salesVO = BeanUtil.toBean(e, SalesVO.class);
//            Customers customers = customersRepository.getOne(salesVO.getCustomerName());
//            salesVO.setCustomerName(customers.getCustomerName());
//            Employees employees = employeeRepository.getOne(salesVO.getEmployeeName());
//            salesVO.setEmployeeName(employees.getEmployeeName());
//            Products products = productRepository.getOne(salesVO.getProductName());
//            salesVO.setProductName(products);
//            return salesVO;
//        }).collect(Collectors.toList());
//        model.addAttribute("salesVO",salesVOList);

        //统计Customers Products Orders
        long count = customersRepository.count();
        long count1 = productRepository.count();
        long count2 = salesRepository.count();
        model.addAttribute("customersCount", count);
        model.addAttribute("productsCount", count1);
        model.addAttribute("ordersCount", count2);

        return "index";
    }
    @GetMapping(value = {"/loginAction"})
    public String login(Accounts accounts, HttpSession httpSession, Model model){
        if(StrUtil.isEmpty(accounts.getUsername())){
            model.addAttribute("msg", "用户名为空");
            return "login";
        }
        if(StrUtil.isEmpty(accounts.getPassword())){
            model.addAttribute("msg", "密码为空");
            return "login";
        }
        Optional<Accounts> repositoryOne = accountsRepository.findOne(Example.of(accounts));
        boolean present = repositoryOne.isPresent();
        if(!present){
            model.addAttribute("msg", "用户名或密码为空");
            return "login";
        }
        httpSession.setAttribute("loginUser",repositoryOne.get().getUsername());
        return "redirect:/index.html";
    }

    @GetMapping(value = {"/loginOut"})
    public String loginOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/login.html";
    }
}
