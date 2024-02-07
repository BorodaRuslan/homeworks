package org.example.home_work5.controller;

import org.example.home_work5.entity.AccountDTO;
import org.example.home_work5.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    AccountsService service;

    @GetMapping("/read")
    public List<AccountDTO> readAllAccounts(){
        return service.readAccounts();
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody AccountDTO account) throws FileNotFoundException {
        return service.creatAccount(account);
    }

    @PutMapping("/update/{id}")
    public String updateAccount(@PathVariable long id, @RequestBody AccountDTO account) throws IOException {
        return service.updateAccount(id, account);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable long id){
        return service.deleteAccount(id);
    }

    @GetMapping("/names")
    public String getAllNameAccounts(){
        return service.getNames();
    }
    @GetMapping("/oldest")
    public Optional<AccountDTO> getAllOldestAccount(){
        return service.getOldestAccount();
    }





}
