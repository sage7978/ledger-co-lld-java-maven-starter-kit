package com.example.geektrust.entity;

import java.util.Set;
import java.util.TreeSet;

public class CurrentLoan {
    private Bank bank;
    private Loan loan;
    private Integer monthlyEMI;
    private Double total;
    private Set<EMI> emiList;

    public CurrentLoan(){
        emiList = new TreeSet<>();
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Integer getMonthlyEMI() {
        return monthlyEMI;
    }

    public void setMonthlyEMI(Integer monthlyEMI) {
        this.monthlyEMI = monthlyEMI;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<EMI> getEmiList() {
        return emiList;
    }

    public void setEmiList(Set<EMI> emiList) {
        this.emiList = emiList;
    }

    public int amountPaidUpto(int inputEmiPaid) {
        int extra = 0;
        for(EMI emi: emiList){
            if(inputEmiPaid >= emi.getEmiPaid()){
                extra += emi.getLumpSum();
            }
        }
        return extra;
    }
}
