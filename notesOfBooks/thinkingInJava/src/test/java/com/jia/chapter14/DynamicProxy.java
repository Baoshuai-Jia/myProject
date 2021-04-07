package com.jia.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface{
    void doSomething();
    void doSomethingElse(String arg);
}
class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("do something ...");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("do something else "+arg);
    }
}

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(
                "proxy :"+proxy.getClass()+
                        "method : "+method+" args:"+args
        );
        if (args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.println("  "+args[i]);
            }
        }
        return method.invoke(proxied,args);
    }
}
public class DynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomethingElse("bo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //Insert a proxy and call again
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));
        consumer(proxy);

    }
}
