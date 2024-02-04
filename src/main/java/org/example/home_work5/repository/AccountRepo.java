package org.example.home_work5.repository;

import org.example.homework1.Account;
import org.example.homework1.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public class AccountRepo {
    private final List<Account> ACCOUNTS_DATA = List.of( new Account("Моника", "Беллуччи", "Украина",
                    LocalDate.of(1990, 10, 5), 1000.0, Gender.FEMALE),
            new Account("Кармен", "Электра", "Польша",
                    LocalDate.of(1986, 8, 10), 1500.0, Gender.FEMALE),
            new Account("Саша", "Грей", "Румуния",
                    LocalDate.of(1995, 11, 11), 2000.0, Gender.FEMALE),
            new Account("Джонни", "Синс", "USA",
                    LocalDate.of(1987, 5, 14), 2200.0, Gender.MALE),
            new Account("Джастин", "Бибер", "Грузия",
                    LocalDate.of(1997, 10, 19), 500.0, Gender.MALE),
            new Account("Aрнольд", "Шварценеггер", "Украина",
                    LocalDate.of(1978, 8, 25), 3000.0, Gender.MALE)
    );

    @Bean
    public List<Account> getAllAccounts(){
        return ACCOUNTS_DATA;
    }
}
