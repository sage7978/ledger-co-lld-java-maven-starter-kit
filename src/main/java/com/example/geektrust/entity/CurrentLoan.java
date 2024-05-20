package com.example.geektrust.entity;

import java.util.Set;
import java.util.TreeSet;

public class CurrentLoan {
    private Loan loan;
    private Set<EMI> emiList;

    public CurrentLoan(){
        emiList = new TreeSet<>();
    }

    public CurrentLoan(double inputPrincipal, int inputTenure, double inputRate){
        emiList = new TreeSet<>();
        Loan loan = new Loan(inputPrincipal, inputTenure, inputRate);

        this.loan = loan;
    }



    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Integer getMonthlyEMI() {
        return loan.getMonthlyEMI();
    }

    public Double getTotal() {
        return loan.getTotalAmount();
    }

    public Set<EMI> getEmiList() {
        return emiList;
    }

    public void setEmiList(Set<EMI> emiList) {
        this.emiList = emiList;
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
}
