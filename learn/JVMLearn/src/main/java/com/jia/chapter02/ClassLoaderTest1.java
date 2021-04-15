package com.jia.chapter02;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*************启动类加载器***************");
        //获取BootstrapClassLoader能够获取加载的api的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for(URL url:urLs){
            System.out.println(url.toExternalForm());
        }

        System.out.println("**************拓展类加载器*****************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String extDir : extDirs.split(":")){
            System.out.println(extDir);
        }
    }
}
