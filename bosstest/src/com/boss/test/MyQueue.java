package com.boss.test;

import java.util.LinkedList;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName MyQueue.java
 * @Description TODO
 * @createTime 2022年06月11日 14:20:00
 */
public class MyQueue<T> implements  Queue<T>{
    private Object[] queue;

    @Override
    public boolean add(T data) {
        return false;
    }

    @Override
    public boolean offer(T data) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    public static void main(String[] args) {
        Queue<User> userQueue=new MyQueue<>();

    }


    public Object[] getQueue() {
        return queue;
    }

    public void queue(Object[] queue) {
        this.queue = queue;
    }
}
