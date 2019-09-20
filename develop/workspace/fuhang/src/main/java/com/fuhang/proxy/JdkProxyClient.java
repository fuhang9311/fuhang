package com.fuhang.proxy;

import java.lang.reflect.Proxy;

public class JdkProxyClient {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(JdkProxyClient.class.getClassLoader(),new Class[]{Subject.class},new JdkProxySubject(new RealSubject()));
        subject.hello();
    }
}
