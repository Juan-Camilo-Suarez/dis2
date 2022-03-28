package ru.itis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            Process process = new ProcessBuilder("ls").start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hola");
    }
}



