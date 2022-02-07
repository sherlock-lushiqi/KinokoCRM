package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import com.lushiqi.kinokocrm.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AccountsService accountsService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin")
    public String doLogin(Accounts accounts, HttpSession httpSession, Model model){
        Accounts accounts1 = accountsService.findAccount(accounts.getUsername(), accounts.getPassword());
        if (accounts1 != null){
           model.addAttribute("msg","成功");
           return "index";
        }else {
            model.addAttribute("msg","用户名不存在");
            return "login_failed";
        }
    }
}
