package com.filecompression.decompression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decompression {
    public void decompress(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("compressed.txt"))) { 
            
            int character;
            while((character = reader.read()) != -1){
                char ch = (char) character;

            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
