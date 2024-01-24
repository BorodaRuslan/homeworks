package StreamApiTest;

import org.example.homework1.AccountService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetNamesTest {
    @Test
    public void testGetNames(){
        String result = AccountService.getNames(TestDataAccounts.ACCOUNTS_DATA);
        String expected = "Моника Беллуччи, Кармен Электра, Саша Грей, Джонни Синс, Джастин Бибер, Aрнольд Шварценеггер";
        assertEquals(expected, result);
    }
}
