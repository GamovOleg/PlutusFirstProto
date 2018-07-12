package com.plutus.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.List;

@Document(collection = "Accounts")
public class Account {

    @Id
    private String name;

    @Valid
    private List<Article> incomes;

    @Valid
    private List<Article> expenses;

    @Valid
    private Savings savings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Article> incomes) {
        this.incomes = incomes;
    }

    public List<Article> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Article> expenses) {
        this.expenses = expenses;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }

}
