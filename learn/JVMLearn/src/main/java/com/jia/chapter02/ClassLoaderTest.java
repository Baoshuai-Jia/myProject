package com.jia.chapter02;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(sysClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2


        ClassLoader extClassLoader = sysClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@61bbe9ba


        ClassLoader bootstrapClassloader = extClassLoader.getParent();
        System.out.println(bootstrapClassloader);//null

        //对于用户自定义的类，默认使用系统类加载器
        ClassLoader currClassloader = ClassLoaderTest.class.getClassLoader();
        System.out.println(currClassloader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String使用的是引导类加载器；系统的核心类库都是使用的引导类加载器
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);//null

    }
}
