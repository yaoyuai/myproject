package com.bosssoft.hr.javase;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName MyQueueEx.java
 * @Description TODO
 * @createTime 2022年06月11日 22:35:00
 */
public class MyQueueEx {


    @Test
    public void testQueueAdd() {
        Queue<User> userQueue = new MyQueue();
        User[] userArr={new User(1,"小白"),new User(2,"小姚"),
                     new User(3,"小花"),new User(4,"小肉"),new User(5,"小清")};

        // 使用add方法加入5个用户
        for (User newUser : userArr) {
            userQueue.add(newUser);
        }
        Assert.assertEquals("插入成功",userQueue.size(),userArr.length);

        // 断言数量正确  否则抛出异常
    }


    @Test
    public void testQueueRemove(){
        Queue<User> users=new MyQueue();
        // 使用add方法加入5个用户
        Queue<User> userQueue = new MyQueue();
        User[] userArr={new User(1,"小白"),new User(2,"小姚"),
                new User(3,"小花"),new User(4,"小肉"),new User(5,"小清")};

        // 使用add方法加入5个用户
        for (User newUser : userArr) {
            userQueue.add(newUser);
        }

        for (int i=0;i<6;i++){
            userQueue.poll();
            if(i==5){
                Assert.assertEquals("移除失败",null,userQueue.poll());
            }
        }

        //  循环6次删除poll队列首，断言第6次为false
    }

    public static void main(String[] args) {


        MyQueueEx myQueueEx=new MyQueueEx();
        myQueueEx.testQueueAdd();
        myQueueEx.testQueueRemove();


    }
}
