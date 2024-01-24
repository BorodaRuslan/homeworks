package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IsYoungerThan2000Test {

    @Test
    public void testIsYoungerThan2000(){
        Boolean result = AccountService.isYoungerThan2000(TestDataAccounts.ACCOUNTS_DATA);
        assertTrue(result);
    }
}
