package org.example.home_work5.configApp;



import org.example.home_work5.repository.AccountRepo;
import org.example.homework1.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "org.example")
public class MyApplicationConfig {

    @Bean
    public AccountRepo accountRepo() {
        return new AccountRepo();
    }
    @Bean
    public AccountService accountService(){
        return new AccountService();
    }


}
