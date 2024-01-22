package org.example.homework1;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class AccountService {

    public static List<Account> getBalanceOver500(List<Account> accountsData){
        return accountsData.stream()
                .filter(a -> a.getBalance() > 500.0)
                .toList();
    }
    public static Set<String> getCountry(List<Account> accountsData){
        return accountsData.stream()
                .map(Account::getCountry)
                .collect(Collectors.toSet());

    }
    public static Boolean isYoungerThan2000(List<Account> accountsData){
        return accountsData.stream()
                .anyMatch(a -> a.getBirthday().getYear() < 2000);
    }
    public static Double sumOfBalancesForMaleAccounts(List<Account> accountsData){
        return accountsData.stream()
                .filter(a -> "Male".equals(a.getGender()))
                .mapToDouble(Account::getBalance)
                .sum();
    }
    public static Map<Month, List<Account>> getGroupByBirthMonth(List<Account> accountsData){
        return accountsData.stream()
                .collect(Collectors.groupingBy(a -> a.getBirthday().getMonth()));
    }
    public static OptionalDouble getAverageBalanceInTheCountry(List<Account> accountsData, String country){
        return accountsData.stream()
                .filter(a -> a.getCountry().equalsIgnoreCase(country))
                .mapToDouble(Account::getBalance)
                .average();
    }
    public static String getNames(List<Account> accountsData) {
        return accountsData.stream()
                .map(a -> a.getFirstName() + " " + a.getLastName())
                .collect(Collectors.joining(", "));
    }

    public static List<Account> getSortedAccounts(List<Account> accountsData){
        return accountsData.stream()
                .sorted(Comparator.comparing(Account::getLastName).thenComparing(Account::getFirstName))
                .toList();
    }

    public static Optional<Account> getOldestAccount(List<Account> accountsData){
        return accountsData.stream()
                .min(Comparator.comparing(Account::getBirthday));
    }
    public static Map<Integer, Double> getAverageBalanceByBirthYear(List<Account> accountsData){
        return accountsData.stream()
                .collect(Collectors.groupingBy(a -> a.getBirthday().getYear(),
                        Collectors.averagingDouble(Account::getBalance)));
    }

    public static Optional<Account> getLongestLastName(List<Account> accountsData){
        return accountsData.stream()
                .max(Comparator.comparingInt(a -> a.getLastName().length()));
    }







}
