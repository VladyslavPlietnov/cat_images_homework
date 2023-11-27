package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code){
        String url = "";
        try{
             url = HttpStatusChecker.getStatusImage(code);
        }catch(Exception e){
            System.out.println("This is not a real response code, no picture corresponds to it. Exception:"+ e.getMessage());
        }
        try{
            Connection.Response image = Jsoup.connect(url).ignoreContentType(true).execute();
            try(FileOutputStream out = new FileOutputStream("image.jpg")){
                out.write(image.bodyAsBytes());
            }
        }catch(IOException e){
            System.out.println("A problem downloading the picture. Reason:"+e.getMessage());
        }
    }

}
