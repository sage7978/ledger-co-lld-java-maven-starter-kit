package com.example.geektrust.loan;

import com.example.geektrust.GenericManager;
import com.example.geektrust.Main;
import com.example.geektrust.entity.*;
import com.example.geektrust.features.CommandExecutable;

public class LoanManager extends GenericManager implements CommandExecutable {

    public LoanManager(String[] inputSplit) {
        super(inputSplit);
        inputBank = inputSplit[1];
        inputBorrower = inputSplit[2];
        inputPrincipal = Double.parseDouble(inputSplit[3]);
        inputTenure = Integer.parseInt(inputSplit[4]);
        inputRate = Double.parseDouble(inputSplit[5]);
    }

    @Override
    public void execute() {
        Borrower borrower = BorrowerEntries.getInstance().fetchBorrower(inputBorrower);
        borrower.addBank(inputBank, inputPrincipal, inputTenure, inputRate);
    }
}
