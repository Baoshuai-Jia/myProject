package com.roadjava.test;

import java.io.BufferedInputStream;
 import java.io.BufferedOutputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.net.URLDecoder;
 import java.net.URLEncoder;

 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;



public class DownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String filename = request.getParameter("id");
        String fileUrl = request.getServletContext().getRealPath("").replace("\\", "/");
        fileUrl = fileUrl + "/files/document/" + filename;
        System.out.println("fileUrl:"+fileUrl);
        String rname = new String(filename.getBytes("utf-8"));
        System.out.println("begin:"+rname);
        rname = URLEncoder.encode(rname);
        System.out.println("end:"+rname);
        response.addHeader("Content-Disposition", "attachment;filename="+rname);
        response.setContentType("application/octet-stream");

        File file = new File(fileUrl);
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();

        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        os.write(buffer);
        os.flush();
        os.close();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


    }


    }

