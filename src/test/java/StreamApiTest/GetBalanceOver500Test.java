package StreamApiTest;


import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetBalanceOver500Test {
    @Test
    public void testGetBalanceOver500(){
        List<Account> result = AccountService.getBalanceOver500(TestDataAccounts.ACCOUNTS_DATA);
        assertEquals(5, result.size());

        assertEquals("Моника", result.get(0).getFirstName());
        assertEquals("Кармен", result.get(1).getFirstName());
        assertEquals("Саша", result.get(2).getFirstName());
        assertEquals("Джонни", result.get(3).getFirstName());
        assertEquals("Aрнольд", result.get(4).getFirstName());

    }
}
