package com.example.geektrust.loan;

import com.example.geektrust.GenericManager;
import com.example.geektrust.Main;
import com.example.geektrust.entity.Bank;
import com.example.geektrust.entity.CurrentLoan;
import com.example.geektrust.entity.Loan;
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
        CurrentLoan currentLoan = fetchCurrentLoan();
        Main.userLoan.put(inputBorrower, currentLoan);
    }

    public CurrentLoan fetchCurrentLoan(){
        Bank currentBank = new Bank();
        currentBank.name = inputBank;

        Loan loan = new Loan();
        loan.interest = inputRate;
        loan.principal = inputPrincipal;
        loan.tenure = inputTenure;

        CurrentLoan currentLoan = new CurrentLoan();
        currentLoan.loan = loan;
        currentLoan.bank = currentBank;
        currentLoan.total = inputPrincipal + ((loan.principal * loan.interest * loan.tenure * 1.0D) / 100);
        currentLoan.monthlyEMI = (int) Math.ceil(currentLoan.total / (currentLoan.loan.tenure * 12));

        return currentLoan;
    }
}
