package com.jia.chapter02;

import java.io.FileNotFoundException;

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] result = getClassFromCustomPath(name);
        if (result == null){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            return defineClass(name,result,0,result.length);
        }
        throw new ClassNotFoundException();
    }

    public byte[] getClassFromCustomPath(String name){
        //从只定义路径中加载类
        //字节码文件解密
        return null;
    }
}
