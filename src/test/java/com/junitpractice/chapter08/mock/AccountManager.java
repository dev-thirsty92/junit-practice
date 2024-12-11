package com.junitpractice.chapter08.mock;

public interface AccountManager {

    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
