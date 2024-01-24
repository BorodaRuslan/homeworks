package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCountryTest {
    @Test
    public void testGetCountry(){
        Set<String> result = AccountService.getCountry(TestDataAccounts.ACCOUNTS_DATA);

        assertEquals(5, result.size());
        assertTrue(result.contains("USA"));
        assertTrue(result.contains("Польша"));
        assertTrue(result.contains("Украина"));
        assertTrue(result.contains("Грузия"));
        assertTrue(result.contains("Румуния"));
    }
}
