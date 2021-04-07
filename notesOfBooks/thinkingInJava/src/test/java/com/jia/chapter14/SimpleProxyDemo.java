//package com.jia.chapter14;
//interface Interface{
//    void doSomething();
//    void doSomethingElse(String arg);
//}
//class RealObject implements Interface{
//    @Override
//    public void doSomething() {
//        System.out.println("do something ...");
//    }
//
//    @Override
//    public void doSomethingElse(String arg) {
//        System.out.println("do something else "+arg);
//    }
//}
//class SimpleProxy implements Interface{
//
//    private final Interface proxied;
//
//    public SimpleProxy(Interface proxied) {
//        this.proxied = proxied;
//    }
//
//    @Override
//    public void doSomething() {
//        System.out.println("Simple proxy doSomething");
//        proxied.doSomething();
//    }
//
//    @Override
//    public void doSomethingElse(String arg) {
//        System.out.println("Simple proxy doSomethingElse ");
//        proxied.doSomethingElse(arg);
//    }
//}
//public class SimpleProxyDemo {
//    public static void consumer(Interface iface){
//        iface.doSomething();
//        iface.doSomethingElse("bo");
//    }
//
//    public static void main(String[] args) {
//        consumer(new RealObject());
//        consumer(new SimpleProxy(new RealObject()));
//    }
//}
