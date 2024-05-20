package com.example.geektrust.entity;

import java.util.Set;
import java.util.TreeSet;

public class CurrentLoan {
    private final Loan loan;
    private final Set<EMI> emiList;

    public CurrentLoan(double inputPrincipal, int inputTenure, double inputRate){
        emiList = new TreeSet<>();
        this.loan = new Loan(inputPrincipal, inputTenure, inputRate);
    }

    public Integer getMonthlyEMI() {
        return loan.getMonthlyEMI();
    }

    public Double getTotal() {
        return loan.getTotalAmount();
    }

    public int extraAmountPaid(int inputEmiPaid) {
        int extra = 0;
        for(EMI emi: emiList){
            if(inputEmiPaid >= emi.getEmiPaid()){
                extra += emi.getLumpSum();
            }
        }
        return extra;
    }

    public int amountPaid(int inputEmiPaid){
        int extraAmountPaid = extraAmountPaid(inputEmiPaid);
        return Math.min(inputEmiPaid * getMonthlyEMI() + extraAmountPaid, (int)Math.ceil(getTotal()));
    }

    public int remainingEMIs(int inputEmiPaid){
        return (int)Math.ceil((getTotal() - amountPaid(inputEmiPaid)) / getMonthlyEMI());
    }

    public void addEMI(Integer inputEmiPaid, Double inputLumpSum) {
        emiList.add(new EMI(inputEmiPaid, inputLumpSum));
    }
}
