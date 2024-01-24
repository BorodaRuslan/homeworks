package StreamApiTest;

import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.example.homework1.Gender;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import static org.junit.Assert.*;

public class AccountServiceTest {
    @Test
    public void testGetBalanceOver500(){
        AccountService service = new AccountService();
        List<Account> result = service.getBalanceOver500(TestDataAccounts.ACCOUNTS_DATA);
        assertEquals(5, result.size());
        assertEquals("Моника", result.get(0).getFirstName());
        assertEquals("Кармен", result.get(1).getFirstName());
        assertEquals("Саша", result.get(2).getFirstName());
        assertEquals("Джонни", result.get(3).getFirstName());
        assertEquals("Aрнольд", result.get(4).getFirstName());
    }
    @Test
    public void testGetCountry(){
        AccountService service = new AccountService();
        Set<String> result = service.getCountry(TestDataAccounts.ACCOUNTS_DATA);
        assertEquals(5, result.size());
        assertTrue(result.contains("USA"));
        assertTrue(result.contains("Польша"));
        assertTrue(result.contains("Украина"));
        assertTrue(result.contains("Грузия"));
        assertTrue(result.contains("Румуния"));
    }
    @Test
    public void testIsYoungerThan2000(){
        AccountService service = new AccountService();
        Boolean result = service.isYoungerThan2000(TestDataAccounts.ACCOUNTS_DATA);
        assertTrue(result);
    }
    @Test
    public void testSumOfBalancesForMaleAccounts(){
        AccountService service = new AccountService();
        Double result = service.sumOfBalancesForMaleAccounts(TestDataAccounts.ACCOUNTS_DATA);
        double expected = 5700.0;
        double delta = 0.001;   // Устанавливаем допустимую погрешность
        assertEquals(expected, result, delta);
    }
    @Test
    public void testGetGroupByBirthMonth(){
        AccountService service = new AccountService();
        Map<Month, List<Account>> result = service.getGroupByBirthMonth(TestDataAccounts.ACCOUNTS_DATA);
        assertEquals(4, result.size());
        assertEquals(2, result.get(Month.AUGUST).size());
        assertEquals(2, result.get(Month.OCTOBER).size());
        assertEquals(1, result.get(Month.NOVEMBER).size());
        assertEquals(1, result.get(Month.MAY).size());
    }
    @Test
    public void testCalculateAverageBalanceForCountry(){
        String county = "Украина";
        AccountService service = new AccountService();
        Double result = service.calculateAverageBalanceForCountry(TestDataAccounts.ACCOUNTS_DATA, county);
        assertNotNull(result);
        assertEquals(2000.0, result, 0.01);
    }
    @Test
    public void testGetNames(){
        AccountService service = new AccountService();
        String result = service.getNames(TestDataAccounts.ACCOUNTS_DATA);
        String expected = "Моника Беллуччи, Кармен Электра, Саша Грей, Джонни Синс, Джастин Бибер, Aрнольд Шварценеггер";
        assertEquals(expected, result);
    }
    @Test
    public void testGetSortedAccounts() {
        AccountService service = new AccountService();
        List<Account> result = service.getSortedAccounts(TestDataAccounts.ACCOUNTS_DATA);
        List<Account> expected = List.of(
                new Account("Моника", "Беллуччи", "Украина",
                        LocalDate.of(1990, 10, 5), 1000.0, Gender.FEMALE),
                new Account("Джастин", "Бибер", "Грузия",
                        LocalDate.of(1997, 10, 19), 500.0, Gender.MALE),
                new Account("Саша", "Грей", "Румуния",
                        LocalDate.of(1995, 11, 11), 2000.0, Gender.FEMALE),
                new Account("Джонни", "Синс", "USA",
                        LocalDate.of(1987, 5, 14), 2200.0, Gender.MALE),
                new Account("Aрнольд", "Шварценеггер", "Украина",
                        LocalDate.of(1978, 8, 25), 3000.0, Gender.MALE),
                new Account("Кармен", "Электра", "Польша",
                        LocalDate.of(1986, 8, 10), 1500.0, Gender.FEMALE)
        );
        assertEquals(expected, result);
    }
    @Test
    public void testGetOldestAccount(){
        AccountService service = new AccountService();
        Optional<Account> result = service.getOldestAccount(TestDataAccounts.ACCOUNTS_DATA);
        assertTrue(result.isPresent());
        Account expected = new Account("Aрнольд", "Шварценеггер", "Украина",
                LocalDate.of(1978, 8, 25), 3000.0, Gender.MALE);
        assertEquals(expected, result.get());
    }
    @Test
    public void testGetAverageBalanceByBirthYear(){
        AccountService service = new AccountService();
        Map<Integer, Double> result = service.getAverageBalanceByBirthYear(TestDataAccounts.ACCOUNTS_DATA);
        assertFalse(result.isEmpty());
        Map<Integer, Double> expected = Map.of(
                1986, 1500.0,
                1987, 2200.0,
                1990, 1000.0,
                1978, 3000.0,
                1995, 2000.0,
                1997, 500.0
        );
        assertEquals(expected, result);
    }
    @Test
    public void testGetLongestLastName(){
        AccountService service = new AccountService();
        Optional<Account> result = service.getLongestLastName(TestDataAccounts.ACCOUNTS_DATA);
        Account expected = new Account("Aрнольд", "Шварценеггер", "Украина",
                LocalDate.of(1978, 8, 25), 3000.0, Gender.MALE);
        assertEquals(expected, result.get());
    }
}
