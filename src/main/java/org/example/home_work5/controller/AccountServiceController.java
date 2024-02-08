package org.example.home_work5.controller;

import org.example.home_work5.repository.AccountRepo;
import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("api/account")
public class AccountServiceController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AccountService service;

    @GetMapping("/names")
    public String getAllNameAccounts(){
        if (accountRepo.getAllAccounts().isEmpty()){
            throw new NoSuchElementException("No accounts found.");
        }
        return service.getNames(accountRepo.getAllAccounts());
    }
    @GetMapping("/oldest")
    public Optional<Account> getAllOldestAccount(){
        if (accountRepo.getAllAccounts().isEmpty()) {
            throw new NoSuchElementException("No accounts found.");
        }
        return service.getOldestAccount(accountRepo.getAllAccounts());
    }

}
