package com.filecompression;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.filecompression.cli.CLI;
import com.filecompression.decompression.Decompression;
import com.filecompression.compression.Compression;

public class Main {
    public static void main(String[] args){
        CLI commandLine = new CLI();
        Compression compressor = new Compression();
        Decompression decompressor = new Decompression();
        int userInputLoop = 1;
        String filePath;
        
        while (userInputLoop == 1) {
            commandLine.printString("Welcome to My File Compression Tool!");
            String userChoiceInput = commandLine.getInput("Please Enter 1 (File Compression) or 2 (File Decompression): ");
            
            switch (userChoiceInput) {
                case "1":
                    filePath = commandLine.getInput("Please Enter the path to your desired file to compress: ");
                    if(isValidFile(filePath, commandLine)){
                        compressor.compress(filePath);
                    }else{
                        commandLine.printString("File Path Could Not be found or is Invalid please double check file path and permissions");
                    }
                    break;
                case "2":
                    decompressor.decompress("../compressed.txt");
                    break;
                default:
                    commandLine.printString("Invalid input. Please enter 1 or 2.");
                    break;
            }

            String continueInput = commandLine.getInput("Would you like to run again or exit the program? Enter 1 to continue or any other input to exit: ");
            commandLine.printBreak();
            if ("1".equals(continueInput)) {
                userInputLoop = 1; 
            } else {
                userInputLoop = 0; 
            }
        }
        commandLine.Close();
    }

    private static boolean isValidFile(String filePath, CLI commandLine) {
        if (Files.exists(Paths.get(filePath)) && Files.isRegularFile(Paths.get(filePath)) && Files.isReadable(Paths.get(filePath))) {
            return true;
        } else {
            commandLine.printString("File Path Could Not be found or is Invalid, please double check file path and permissions.");
            return false;
        }
    }

}
