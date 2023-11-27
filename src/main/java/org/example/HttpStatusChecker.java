package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws Exception{
        String base ="https://http.cat";
        String result ="";
       try {
           Connection.Response response  = Jsoup.connect(base + "/" + code + ".jpg").ignoreContentType(true).execute();
           int statusCode = response.statusCode();
           if(statusCode == 404){
               throw new Exception("this is not a proper code, there is no picture for it");
           }
           else{
             result = base + "/" + code + ".jpg";
           }
        }catch(IOException e){
           System.out.println(e.getMessage());
       }
       return result;
    }

}
