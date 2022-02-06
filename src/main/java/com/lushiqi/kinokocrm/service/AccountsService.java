package com.lushiqi.kinokocrm.service;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import com.lushiqi.kinokocrm.entity.repo.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountsService {
    Accounts findAccount(String username, String password);
}
