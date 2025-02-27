package com.irnin.cashbattle;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

public class Team {
    private final ReadOnlyIntegerWrapper accountBalance;

    public Team() {
        accountBalance = new ReadOnlyIntegerWrapper(10000);
    }

    public ReadOnlyIntegerProperty getAccountBalanceProperty() {
        return accountBalance;
    }

    public void charge(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if(accountBalance.get() < amount) {
            throw new IllegalStateException("Insufficient funds");
        }

        accountBalance.set(accountBalance.get() - amount);
    }

    public void increaseBalance(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        accountBalance.set(accountBalance.get() + amount);
    }
}
