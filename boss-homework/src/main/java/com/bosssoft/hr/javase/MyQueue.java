package com.bosssoft.hr.javase;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName MyQueue.java
 * @Description TODO
 * @createTime 2022年06月11日 14:20:00
 */
public class MyQueue<T> implements  Queue<T>{
    private Object [] queue;
    private int begin=0;
    private int end=0;
    private int length=0;

    public MyQueue(int size){
        queue=new Object[size];
    }

    public MyQueue(){
        queue=new Object[32];
    }

    /**
     * 入队
     * @author yaoyu
     * @date 2022/6/11 21:59
     * @param data
     * @return boolean
     */
    @Override
    public synchronized boolean add(T data) {
        int oldLength=this.length;
        if(this.length<this.queue.length){//队不满的情况
            this.queue[this.length++]=data;
        }else{//队满的情况
            throw new RuntimeException();
//            this.length=this.queue.length+(int)(this.queue.length*0.75+1);
//            Object[] newQueue=new Object[this.length];
//            System.arraycopy(this.queue,0,newQueue,0,this.queue.length);
//            this.queue=newQueue;
        }
        return this.length>oldLength?true:false;
    }

    /**
     * 入队
     * @author yaoyu
     * @date 2022/6/11 22:15
     * @param data
     * @return boolean
     */
    @Override
    public boolean offer(T data) {
        if(this.length!=this.end){//队不满的情况
            this.queue[this.end++]=data;
            return true;
        }
        return false;
    }


    @Override
    public T remove() {
        if(this.length==0){
            throw new RuntimeException();
        }
        T data= (T) this.queue[0];
        this.length--;
        System.arraycopy(this.queue,1,this.queue,0,length);
        return data;
    }

    @Override
    public T poll() {
        if(this.length==0){
            return null;
        }
        T data= (T) this.queue[0];
        this.length--;
        System.arraycopy(this.queue,1,this.queue,0,length);
        return data;
    }

    @Override
    public T element() {
        if(this.length==0){
            throw new RuntimeException();
        }
        return this.length==0? (T) this.queue[0]:null;
    }

    @Override
    public T peek() {
        return this.length==0? (T) this.queue[0] :null;
    }

    @Override
    public int size() {
        return this.length;
    }



}
