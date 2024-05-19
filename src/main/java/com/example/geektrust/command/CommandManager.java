package com.example.geektrust.command;

import com.example.geektrust.features.CommandExecutable;

public class CommandManager {
    private CommandFactory factory = new CommandFactory();
    public void executeCommand(String str){
        String[] splitted = str.split(" ");
        String command = splitted[0];
        CommandExecutable executable = factory.getInstance(command, splitted);
        executable.execute();
    }
}
