package com.foresee.concurrent.chapter3;

import java.awt.*;
import java.util.EventListener;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/13-11:19
 */
public class ThisEscape {
//    public ThisEscape(EventSource source) {
//        source.registerListener(
//                new EventListener() {
//                    public void onEvent(Event e) {
//                        ThisEscape escape = doSomething();
//                        // 在构造函数中访问ThisEscape对象的引用
//                        escape.doAnotherThing();
//                    }
//                }
//        );
//    }

    public ThisEscape doSomething() {
        // 执行操作...
        return this;
    }

    public void doAnotherThing() {
        // 执行其他操作...
    }
}
