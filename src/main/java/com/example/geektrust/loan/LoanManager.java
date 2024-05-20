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
        Bank currentBank = new Bank(inputBank);

        Loan loan = new Loan(inputPrincipal, inputTenure, inputRate);

        CurrentLoan currentLoan = new CurrentLoan();
        currentLoan.setLoan(loan);
        currentLoan.setBank(currentBank);
        currentLoan.setTotal(inputPrincipal + ((loan.getPrincipal() * loan.getInterest() * loan.getTenure() * 1.0D) / 100));
        currentLoan.setMonthlyEMI((int) Math.ceil(currentLoan.getTotal() / (currentLoan.getLoan().getTenure() * 12)));

        return currentLoan;
    }
}
