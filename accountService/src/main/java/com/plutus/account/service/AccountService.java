package com.plutus.account.service;

import com.plutus.account.model.Account;
import com.plutus.account.model.User;

public interface AccountService {

    Account findByName(String name);
    Account create(User user);

    void saveChanges(String name, Account update);

}
