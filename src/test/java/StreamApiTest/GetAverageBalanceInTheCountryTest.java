package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import java.util.OptionalDouble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetAverageBalanceInTheCountryTest {
    @Test
    public void testGetAverageBalanceInTheCountry(){
        String county = "Украина";
        OptionalDouble result = AccountService.getAverageBalanceInTheCountry(TestDataAccounts.ACCOUNTS_DATA, county);

        assertTrue(result.isPresent());
        assertEquals(2000.0, result.getAsDouble(), 0.01);
    }
}
