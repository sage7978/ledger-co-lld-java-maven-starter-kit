package com.example.geektrust.entity;

import java.util.Set;
import java.util.TreeSet;

public class CurrentLoan {
    public Bank bank;
    public Loan loan;
    public Integer monthlyEMI;
    public Double total;
    public Set<EMI> emiList;

    public CurrentLoan(){
        emiList = new TreeSet<>();
    }

    public int amountPaidUpto(int inputEmiPaid) {
        int extra = 0;
        for(EMI emi: emiList){
            if(inputEmiPaid >= emi.emiPaid){
                extra += emi.lumpSum;
            }
        }
        return extra;
    }
}
