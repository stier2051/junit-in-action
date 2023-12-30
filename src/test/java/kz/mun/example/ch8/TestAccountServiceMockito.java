package kz.mun.example.ch8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestAccountServiceMockito {

    @Mock
    private AccountManager mockAccountManager;

    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1", 200L);
        Account beneficiaryAccount = new Account("2", 100L);

        Mockito.lenient()
                .when(mockAccountManager.findAccountForUser("1"))
                .thenReturn(senderAccount);

        Mockito.lenient()
                .when(mockAccountManager.findAccountForUser("2"))
                .thenReturn(beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50L);

        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }
}
