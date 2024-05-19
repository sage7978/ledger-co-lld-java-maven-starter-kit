package com.example.geektrust.enums;

public enum Command {
    LOAN("LOAN"),
    PAYMENT("PAYMENT"),
    BALANCE("BALANCE");

    private String val;

    Command(String val){
        this.val = val;
    }

    public static Command fetchCommandFromVal(String val){
        for(Command c: Command.values()){
            if(val.equalsIgnoreCase(c.val)){
                return c;
            }
        }
        return null;
    }
}
