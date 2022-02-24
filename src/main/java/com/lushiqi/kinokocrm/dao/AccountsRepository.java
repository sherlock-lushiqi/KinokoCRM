package com.lushiqi.kinokocrm.dao;

import com.lushiqi.kinokocrm.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
}
