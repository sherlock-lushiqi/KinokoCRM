package com.lushiqi.kinokocrm.service.impl;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import com.lushiqi.kinokocrm.entity.repo.AccountsRepository;
import com.lushiqi.kinokocrm.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountsService {

    @Autowired
    AccountsRepository accountsRepository;

    public Accounts findAccount(String username, String password) {
        return accountsRepository.findByUsernameAndPassword(username, password);
    }
}
