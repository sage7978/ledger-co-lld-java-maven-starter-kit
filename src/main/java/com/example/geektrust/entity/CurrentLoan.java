package com.example.geektrust.entity;

import java.util.Set;
import java.util.TreeSet;

public class CurrentLoan {
    public static int NUMBER_OF_MONTHS_IN_A_YEAR            = 12;
    public static double PERCENTAGE_DENOMINATOR             = 100.0;
    private Loan loan;
    private Integer monthlyEMI;
    private Double total;
    private Set<EMI> emiList;

    public CurrentLoan(){
        emiList = new TreeSet<>();
    }

    public CurrentLoan(double inputPrincipal, int inputTenure, double inputRate){
        emiList = new TreeSet<>();
        Loan loan = new Loan(inputPrincipal, inputTenure, inputRate);

        this.loan = loan;

        double interestAmt = loan.getPrincipal() * loan.getInterest() * loan.getTenure() / PERCENTAGE_DENOMINATOR;
        this.total = inputPrincipal + interestAmt;

        int numberOfMonths = loan.getTenure() * NUMBER_OF_MONTHS_IN_A_YEAR;
        this.monthlyEMI = (int)Math.ceil(this.total / numberOfMonths);
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
