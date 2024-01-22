package StreamApiTest;

import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetOldestAccountTest {

    @Test
    public void testGetOldestAccount(){
        Optional<Account> result = AccountService.getOldestAccount(TestDataAccounts.ACCOUNTS_DATA);
        assertTrue(result.isPresent());

        Account expected = new Account("Aрнольд", "Шварценеггер", "Украина",
                LocalDate.of(1978, 8, 25), 3000.0, "Male");

        assertEquals(expected, result.get());
    }
}
