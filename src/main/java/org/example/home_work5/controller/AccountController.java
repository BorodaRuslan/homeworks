package org.example.home_work5.controller;

import org.example.home_work5.entity.AccountDTO;
import org.example.home_work5.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/")
public class AccountController {

    @Autowired
    AccountsService service;

    @GetMapping("account/read")
    public List<AccountDTO> readAllAccounts(){
        return service.readAccounts();
    }

    @PostMapping("account/create")
    public String createAccount(@RequestBody AccountDTO account){
        try {
            return service.creatAccount(account);
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while creating account", e);
        }
    }

    @PutMapping("account/{id}")
    public String updateAccount(@PathVariable long id, @RequestBody AccountDTO account) throws IOException {
        return service.updateAccount(id, account);
    }
    @DeleteMapping("account/{id}")
    public String deleteAccount(@PathVariable long id){
        return service.deleteAccount(id);
    }

    @GetMapping("account/names")
    public String getAllNameAccounts(){
        return service.getNames();
    }
    @GetMapping("account/oldest")
    public Optional<AccountDTO> getAllOldestAccount(){
        return service.getOldestAccount();
    }
}
