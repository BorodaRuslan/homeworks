package StreamApiTest;

import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetSortedAccountsTest {

    @Test
    public void testGetSortedAccounts() {
        List<Account> result = AccountService.getSortedAccounts(TestDataAccounts.ACCOUNTS_DATA);
        List<Account> expected = List.of(
                new Account("Моника", "Беллуччи", "Украина",
                        LocalDate.of(1990, 10, 5), 1000.0, "Female"),
                new Account("Джастин", "Бибер", "Грузия",
                        LocalDate.of(1997, 10, 19), 500.0, "Male"),
                new Account("Саша", "Грей", "Румуния",
                        LocalDate.of(1995, 11, 11), 2000.0, "Female"),
                new Account("Джонни", "Синс", "USA",
                        LocalDate.of(1987, 5, 14), 2200.0, "Male"),
                new Account("Aрнольд", "Шварценеггер", "Украина",
                        LocalDate.of(1978, 8, 25), 3000.0, "Male"),
                new Account("Кармен", "Электра", "Польша",
                        LocalDate.of(1986, 8, 10), 1500.0, "Female")
        );
        assertEquals(expected, result);
    }
}
