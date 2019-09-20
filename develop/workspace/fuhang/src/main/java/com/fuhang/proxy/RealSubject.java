package com.fuhang.proxy;

import org.apache.lucene.index.DocIDMerger;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("realSubject excute");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
