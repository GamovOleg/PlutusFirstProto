package com.plutus.account.model;

public enum Currency {

    UAH, TRY, USD, EUR;

    public static Currency getDefault(){
        return UAH;
    }
}
