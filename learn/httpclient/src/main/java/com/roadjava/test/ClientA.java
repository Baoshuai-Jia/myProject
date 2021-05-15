package com.roadjava.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClientA {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        ClientA client = new ClientA();
        client.service();
    }

    public void service() {
        // TODO 自动生成的方法存根

        String url = "http://127.0.0.1/download.do";

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);

        try {

            HttpResponse response = client.execute(get);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
