package com.example.geektrust.entity;

public class BankBorrower {
    private Bank bank;
    private CurrentLoan currentLoan;

    public BankBorrower(String bankName, double inputPrincipal, int inputTenure, double inputRate) {
        this.bank = new Bank(bankName);
        this.currentLoan = new CurrentLoan(inputPrincipal, inputTenure, inputRate);
    }

    public CurrentLoan getCurrentLoan() {
        return currentLoan;
    }

    public boolean doesBankMatch(String bankName){
        return bank.getName().equalsIgnoreCase(bankName);
    }
}
