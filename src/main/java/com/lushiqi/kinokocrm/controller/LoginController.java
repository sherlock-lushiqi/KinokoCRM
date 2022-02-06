package com.lushiqi.kinokocrm.controller;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import com.lushiqi.kinokocrm.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String dologin(Accounts accounts, HttpSession session, Model model){

        Accounts accounts1 = accountsService.findAccount(accounts.getUsername(), accounts.getPassword());

        if(accounts1 != null){
            model.addAttribute("message", "登录成功");
            return "index";
        }else{
            model.addAttribute("message", "登录失败");
            return "login_failed";
        }
    }

}
