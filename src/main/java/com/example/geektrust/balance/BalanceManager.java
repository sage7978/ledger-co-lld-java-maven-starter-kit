package com.example.geektrust.balance;

import com.example.geektrust.GenericManager;
import com.example.geektrust.Main;
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
        // input EMI paid -> remaining amount -> remaining number of EMIs
        Borrower borrower = BorrowerEntries.getInstance().fetchBorrower(inputBorrower);
        CurrentLoan currentLoan = borrower.fetchBank(inputBank).getCurrentLoan();
        int extraAmountPaid = currentLoan.amountPaidUpto(inputEmiPaid);
        int amountPaid = inputEmiPaid * currentLoan.getMonthlyEMI() + extraAmountPaid;
        int remainingEMIs = (int)Math.ceil((currentLoan.getTotal() - amountPaid) / currentLoan.getMonthlyEMI() * 1.0D);
        System.out.printf("%s %s %d %d%n", inputBank, inputBorrower, amountPaid, remainingEMIs);
    }
}
