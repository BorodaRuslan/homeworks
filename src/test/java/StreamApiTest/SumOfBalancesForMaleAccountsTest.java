package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SumOfBalancesForMaleAccountsTest {
    @Test
    public void testSumOfBalancesForMaleAccounts(){
        Double result = AccountService.sumOfBalancesForMaleAccounts(TestDataAccounts.ACCOUNTS_DATA);
        double expected = 5700.0;
        double delta = 0.001;   // Устанавливаем допустимую погрешность
        assertEquals(expected, result, delta);
    }
}
