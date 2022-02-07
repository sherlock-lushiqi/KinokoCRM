package com.lushiqi.kinokocrm.entity.repo;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findByUsernameAndPassword(String username, String password);
}

