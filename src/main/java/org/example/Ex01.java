package org.example;

import java.io.IOException;
import java.io.InputStream;

public class Ex01 {
    public static void main(String[] args) throws IOException{
        new Ex01().printFile();


    }

    public void printFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.tht");
        System.out.println(new String(inputStream.readAllBytes()));
    }
}
