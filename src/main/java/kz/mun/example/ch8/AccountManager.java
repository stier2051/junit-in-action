package kz.mun.example.ch8;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
