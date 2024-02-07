package org.example.home_work5.service;

import org.example.home_work5.entity.AccountDTO;
import org.example.home_work5.repository.AccountRepo;
import org.example.homework1.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    @Autowired
    AccountRepo repo;

    public String creatAccount(AccountDTO accountDTO) throws FileNotFoundException {
        return repo.creatAccount(accountDTO);
    }
    public List<AccountDTO> readAccounts(){
        return repo.getAccounts();
    }

    public String updateAccount(long idAccount, AccountDTO accountDTO) throws IOException {
        return repo.updateAccount(idAccount, accountDTO);
    }
    public String deleteAccount(long idAccount){
        return repo.deleteAccount(idAccount);
    }
    public List<AccountDTO> getBalanceOver500(){
        return repo.getAccounts().stream()
                .filter(a -> a.getBalance() > 500.0)
                .toList();
    }
    public Set<String> getCountry(){
        return repo.getAccounts().stream()
                .map(AccountDTO::getCountry)
                .collect(Collectors.toSet());
    }

    public String getNames() {
        return repo.getAccounts().stream()
                .map(a -> a.getFirstName() + " " + a.getLastName())
                .collect(Collectors.joining(", "));
    }

    public Optional<AccountDTO> getOldestAccount(){
        return repo.getAccounts().stream()
                .min(Comparator.comparing(AccountDTO::getBirthday));
    }


}
