package com.plutus.account.service;

import com.plutus.account.model.Account;
import com.plutus.account.model.Currency;
import com.plutus.account.model.Savings;
import com.plutus.account.model.User;
import com.plutus.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Account findByName(String name){
        return repository.findByName(name);
    }

    @Override
    public Account create(User user){

        Savings saving = new Savings();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());

        Account account = new Account();
        account.setName(user.getFirstName());
        account.setSavings(saving);

        repository.save(account);

        return account;
    }

    @Override
    public void saveChanges(String name, Account update){

        Account account = repository.findByName(name);

        account.setIncomes(update.getIncomes());
        account.setExpenses(update.getExpenses());
        account.setSavings(update.getSavings());

        repository.save(account);
    }

}
