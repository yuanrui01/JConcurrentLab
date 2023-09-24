package com.foresee.concurrent.chapter3;

/**
 * @description: 可变整数
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/13-2:37
 */
public class MutableInteger {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
