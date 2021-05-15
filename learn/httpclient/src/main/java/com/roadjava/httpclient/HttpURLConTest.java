package com.roadjava.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpURLConTest {
    public static void main(String[] args) throws IOException {
        String baidu = "https://www.baidu.com/";
        URL url = new URL(baidu);
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection connection = (HttpURLConnection) urlConnection;

        try (
                InputStream is = connection.getInputStream();
                final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                final BufferedReader br = new BufferedReader(isr);
                ){
            String line;
            while ((line = br.readLine())!= null){
                System.out.println(line);
            }
        }
    }
}
