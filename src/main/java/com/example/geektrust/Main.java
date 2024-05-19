package com.example.geektrust;

import com.example.geektrust.command.CommandManager;
import com.example.geektrust.entity.CurrentLoan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static Map<String, CurrentLoan> userLoan = new HashMap<>();

    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        String filePath = args[0];
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(
                    fileLine -> {
                        commandManager.executeCommand(fileLine);
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
