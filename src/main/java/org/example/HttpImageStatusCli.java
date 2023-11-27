package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus(){
        Scanner scanner = new Scanner(System.in);
        int code =0;
        try{
            code = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid nmber");
        }
        String url = "";
        try{
            HttpStatusImageDownloader.downloadStatusImage(code);
        }catch(Exception e){
            System.out.println("There is not image for HTTP status <"+ code +">");
        }

    }

    public static void main(String[] args) {
        askStatus();
    }
}
