package StreamApiTest;

import org.example.homework1.Account;
import org.example.homework1.AccountService;
import org.junit.Test;

import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class getGroupByBirthMonthTest {
    @Test
    public void testGetGroupByBirthMonth(){
        Map<Month, List<Account>> result = AccountService.getGroupByBirthMonth(TestDataAccounts.ACCOUNTS_DATA);

        assertEquals(4, result.size());
        assertEquals(2, result.get(Month.AUGUST).size());
        assertEquals(2, result.get(Month.OCTOBER).size());
        assertEquals(1, result.get(Month.NOVEMBER).size());
        assertEquals(1, result.get(Month.MAY).size());
    }
}
