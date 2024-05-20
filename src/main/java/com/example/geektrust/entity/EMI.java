package com.example.geektrust.entity;

public class EMI implements Comparable<EMI>{
    private final int emiPaid;
    private final double lumpSum;

    public EMI(int emiPaid, double lumpSum) {
        this.emiPaid = emiPaid;
        this.lumpSum = lumpSum;
    }

    @Override
    public int compareTo(EMI o) {
        return emiPaid-o.emiPaid;
    }

    public double toBeCounted(int inputEmiPaid) {
        if(inputEmiPaid >= emiPaid){
            return lumpSum;
        }
        return 0;
    }
}
