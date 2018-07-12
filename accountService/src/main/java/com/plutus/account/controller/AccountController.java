package com.plutus.account.controller;

import com.plutus.account.model.Account;
import com.plutus.account.model.User;
import com.plutus.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Account getAccountByName(@PathVariable String name){
        return accountService.findByName(name);
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Account getCurrentAccount(Principal principal){
        return accountService.findByName(principal.getName());
    }

    @RequestMapping(value = "/current", method = RequestMethod.PUT)
    public void saveCurrentAccount(Principal principal, @RequestBody Account account){
        accountService.saveChanges(principal.getName(), account);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Account createNewAccount(@RequestBody User user){
        return accountService.create(user);
    }

}
