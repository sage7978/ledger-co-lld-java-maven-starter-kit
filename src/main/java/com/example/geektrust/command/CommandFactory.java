package com.example.geektrust.command;

import com.example.geektrust.balance.BalanceManager;
import com.example.geektrust.enums.Command;
import com.example.geektrust.features.CommandExecutable;
import com.example.geektrust.loan.LoanManager;
import com.example.geektrust.payment.PaymentManager;

import java.util.Objects;

public class CommandFactory {

    public CommandExecutable getInstance(String command, String[] splitted) {
        switch(Objects.requireNonNull(Command.fetchCommandFromVal(command))){
            case LOAN: return new LoanManager(splitted);
            case PAYMENT: return new PaymentManager(splitted);
            case BALANCE: return new BalanceManager(splitted);
        }
        return null;
    }
}
