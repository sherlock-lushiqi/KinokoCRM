package com.lushiqi.kinokocrm.entity.repo;


import com.lushiqi.kinokocrm.entity.data.CustomerClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerClassesRepository extends JpaRepository<CustomerClasses, Long> {
}
