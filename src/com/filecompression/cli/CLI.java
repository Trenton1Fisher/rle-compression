package com.filecompression.cli;
import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI(){
        this.scanner =  new Scanner(System.in);
    }

    public void printString(String message){
        System.out.println(message);
    }

    public void printBreak(){
        System.out.println("\n\n");
    }

    public String getInput(String prompt){
        System.out.print(prompt);
        return scanner.nextLine(); 
    }

    public void Close(){
        scanner.close();
    }

}
