package kz.mun.example.ch8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAccountService {
    @Test
    public void testTransferOk() {
        Account senderAccount = new Account("1", 200L);
        Account beneficiaryAccount = new Account("2", 100L);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        accountService.transfer("1", "2", 50L);

        assertEquals(150L, senderAccount.getBalance());
        assertEquals(150L, beneficiaryAccount.getBalance());
    }
}
