package com.roadjava.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HttpClientTest {
    /**
     * 使用httpclient发送get请求
     * application/x-www-form-urlencoded
     * @param args
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        //可关闭的httpclient客户端， 相当于打开一个浏览器
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlStr = "http://localhost:8081/test3";
//        String urlStr = "http://localhost:8081/test1?userName=wendy&password=abc";
        FileBody fileBody = new FileBody(new File("/Users/ebaoshuaijia/Public/vscode-server/code/myProVscode/myProject/learn/httpclient/src/main/java/com/roadjava/httpclient/HttpClientTest.java"));
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder
        .setContentType(ContentType.MULTIPART_FORM_DATA)//设置contentType
        .setCharset(Consts.UTF_8)//设置编码
        .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)//设置为浏览器模式
        .addPart("fileName",fileBody)
        .addBinaryBody("fileName",new File("/Users/ebaoshuaijia/Public/vscode-server/code/myProVscode/myProject/learn/httpclient/src/main/java/com/roadjava/httpclient/HttpClientTest.java"))
                //如果普通的表单含有中文名称，那么不可以使用addTextBody 方法，否则乱码
//        .addTextBody("userName","wendy= 加")
        .addPart("userName",new StringBody("wendy-加",
                ContentType.create(
                        ContentType.TEXT_PLAIN.getMimeType(),Consts.UTF_8)
                )
        )
        .addTextBody("password","wendy");
        HttpEntity httpEntity = builder.build();
        //构建http请求对象
        final HttpPost httpPost = new HttpPost(urlStr);
//        stringEntity.setContentType(new BasicHeader("content-type","application/json"));
        httpPost.setEntity(httpEntity);
//        httpPost.setHeader("content-type","application/x-www-form-urlencoded");
        //可关闭的响应
        CloseableHttpResponse response = null;

        try {
            //执行httpget请求
            response = httpClient.execute(httpPost);
            //获取响应结果
            final HttpEntity entity = response.getEntity();
            //使用工具类处理结果
            final String entityToStr = EntityUtils.toString(entity);
            System.out.println(entityToStr);
            //确保content被使用，同时关闭 content stream
            EntityUtils.consume(entity);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (httpClient != null){
                    httpClient.close();
                }
                if (response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}