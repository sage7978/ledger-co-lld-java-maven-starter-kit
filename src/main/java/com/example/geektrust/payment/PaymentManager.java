package com.example.geektrust.payment;

import com.example.geektrust.GenericManager;
import com.example.geektrust.Main;
import com.example.geektrust.entity.CurrentLoan;
import com.example.geektrust.entity.EMI;
import com.example.geektrust.features.CommandExecutable;

public class PaymentManager extends GenericManager implements CommandExecutable {
    public PaymentManager(String[] inputSplit) {
        super(inputSplit);
        inputBank = inputSplit[1];
        inputBorrower = inputSplit[2];
        inputLumpSum = Double.parseDouble(inputSplit[3]);
        inputEmiPaid = Integer.parseInt(inputSplit[4]);
    }

    @Override
    public void execute() {
        CurrentLoan currentLoan = Main.userLoan.get(inputBorrower);
        currentLoan.getEmiList().add(new EMI(inputEmiPaid, inputLumpSum));
    }
}
