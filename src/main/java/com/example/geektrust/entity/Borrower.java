package com.example.geektrust.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Borrower extends User{
    private List<BankBorrower> bankBorrowers;

    public Borrower(String name) {
        super(name);
        bankBorrowers = new ArrayList<>();
    }

    public List<BankBorrower> getBankBorrowers() {
        return bankBorrowers;
    }

    public void setBankBorrowers(List<BankBorrower> bankBorrowers) {
        this.bankBorrowers = bankBorrowers;
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
}
