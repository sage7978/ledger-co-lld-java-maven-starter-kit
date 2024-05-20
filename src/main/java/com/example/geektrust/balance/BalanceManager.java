package com.example.geektrust.balance;

import com.example.geektrust.GenericManager;
import com.example.geektrust.entity.Borrower;
import com.example.geektrust.entity.BorrowerEntries;
import com.example.geektrust.entity.CurrentLoan;
import com.example.geektrust.features.CommandExecutable;

public class BalanceManager extends GenericManager implements CommandExecutable {
    public BalanceManager(String[] inputSplit) {
        super(inputSplit);
        inputBank = inputSplit[1];
        inputBorrower = inputSplit[2];
        inputEmiPaid = Integer.parseInt(inputSplit[3]);
    }

    @Override
    public void execute() {
        Borrower borrower = BorrowerEntries.getInstance().fetchBorrower(inputBorrower);
        CurrentLoan currentLoan = borrower.fetchCurrentLoan(inputBank);
        int amountPaid = currentLoan.amountPaid(inputEmiPaid);
        int remainingEMIs = currentLoan.remainingEMIs(inputEmiPaid);
        System.out.printf("%s %s %d %d%n", inputBank, inputBorrower, amountPaid, remainingEMIs);
    }
}
