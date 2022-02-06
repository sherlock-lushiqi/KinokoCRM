package com.lushiqi.kinokocrm;

import com.lushiqi.kinokocrm.entity.data.Accounts;
import com.lushiqi.kinokocrm.entity.data.Customers;
import com.lushiqi.kinokocrm.entity.data.Employees;
import com.lushiqi.kinokocrm.entity.repo.AccountRepository;
import com.lushiqi.kinokocrm.entity.repo.CustomersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest
class KinokoCrmApplicationTests {

    @Resource
    private AccountRepository repository;

    @Transactional    //懒加载属性需要在事务环境下获取，因为repository方法调用完后session回立即关闭，此时会报错could not initialize proxy  - no Session
    @Test
    void contextLoads() {
        repository.findById(1).ifPresent(accounts -> {
            System.out.println(accounts.getUsername());
            System.out.println(accounts.getEmployees());
        });
    }

    @Test
    void addAccount() {
        Accounts accounts = new Accounts();
        accounts.setUsername("test2");
        accounts.setPassword("test2");
        Employees employees = new Employees();
        employees.setEmployeeName("本田源次郎");
        employees.setEmployeeDepartments("市場部");
        employees.setEmployee_phone("09043218765");
        employees.setEmployee_email("abc@outlook.com");
        accounts.setEmployees(employees);
        accounts = repository.save(accounts);
        System.out.println("插入时，自动生成的主键ID为："+ accounts.getAccountID()+"，外键ID为："+accounts.getEmployees().getEmployeeID());
    }

    @Test
    void addCustomers() {
    }

    @Test
    void deleteAccount() {
        repository.deleteById(4);
    }

    @Test
    void pageAccount() {
        repository.findAll(PageRequest.of(0,6)).forEach(System.out::println);
    }
}
