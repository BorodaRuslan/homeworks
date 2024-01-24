package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GetAverageBalanceByBirthYearTest {
    @Test
    public void testGetAverageBalanceByBirthYear(){
        Map<Integer, Double> result = AccountService.getAverageBalanceByBirthYear(TestDataAccounts.ACCOUNTS_DATA);
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
}
