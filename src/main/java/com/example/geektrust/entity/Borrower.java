package com.example.geektrust.entity;

import java.util.ArrayList;
import java.util.List;

public class Borrower extends User{
    private final List<BankBorrower> bankBorrowers;

    public Borrower(String name) {
        super(name);
        bankBorrowers = new ArrayList<>();
    }

    public void addBank(String bankName, double inputPrincipal, int inputTenure, double inputRate){
        BankBorrower bankBorrower = new BankBorrower(bankName, inputPrincipal, inputTenure, inputRate);
        bankBorrowers.add(bankBorrower);
    }

    public BankBorrower fetchBank(String bankName){
        return bankBorrowers.stream()
                            .filter(e -> e.doesBankMatch(bankName))
                            .findFirst()
                            .orElse(null);
    }

    public CurrentLoan fetchCurrentLoan(String inputBank) {
        BankBorrower bankBorrower = fetchBank(inputBank);
        return bankBorrower.getCurrentLoan();
    }
}
