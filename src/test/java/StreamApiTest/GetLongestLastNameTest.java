package StreamApiTest;

import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class GetLongestLastNameTest {
    @Test
    public void testGetLongestLastName(){
        Optional<Account> result = AccountService.getLongestLastName(TestDataAccounts.ACCOUNTS_DATA);
        Account expected = new Account("Aрнольд", "Шварценеггер", "Украина",
                LocalDate.of(1978, 8, 25), 3000.0, "Male");

        assertEquals(expected, result.get());
    }
}
