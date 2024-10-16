package com.filecompression.compression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Compression {
    private char previousChar = '\0';
    private int charCount = 0;

    public void compress(String filePath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("compressed.txt"))) { 
            int character;
            while ((character = reader.read()) != -1) {
                char ch = (char) character;
                 
                if(this.previousChar == '\0'){
                    this.previousChar = ch;
                    this.charCount = 1;
                } 
                else if(ch == this.previousChar){
                    this.charCount++;
                }
                else{
                    switch(this.charCount){
                        case 1: 
                            writer.write(this.previousChar);
                            break;
                        default: 
                             writer.write("" + this.charCount + "" + this.previousChar + "");
                        break;
                    }
                    this.previousChar = ch;
                    this.charCount = 1;
                }
            }
            if (this.previousChar != '\0') {
                writer.write("" + this.charCount + "" + this.previousChar + "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
