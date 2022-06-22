package com.bosssoft.hr.javase;

import java.util.Set;
import java.util.TreeSet;


public class TreeSetExample {
    private Set<User> set=new TreeSet<User>(new UserComparator());

    /*
     *
     * @author yaoyu
     * @date 2022/6/11 0:29
     */
    void query(){
        for (User user : set.toArray(new User[set.size()])) {
            System.out.println(user);
        }
    }

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 0:22
     * @param users 
     * @return com.boss.test.User[]
     */
    User[] sort(User[] users){
        for (User user : users) {
            set.add(user);
        }
        return set.toArray(new User[set.size()]);
    }

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 0:22
     * @param user 
     * @return boolean
     */
    boolean add(User user){
        return set.add(user);
    }

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 0:22
     * @param user 
     * @return boolean
     */
    boolean remove(User user){
        return set.remove(user);
    }

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 0:22
     * @param user 
     * @return boolean
     */
    boolean contains(User user){
        return set.contains(user);
    }

    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 0:22 
     * @return com.boss.test.User[]
     */
    User[] toArray(){
        return  set.toArray(new User[set.size()]);
    }


    public static void main(String[] args) {
        //初始化数据
        User uOne=new User(2,"姚宇");
        User uTwo=new User(1,"小姚");
        User uThree=new User(3,"小宇");
        User[] users=new User[]{uOne,uTwo,uThree};
        //创建对象调用对应方法
        TreeSetExample treeSetExample=new TreeSetExample();
        //1、排序方法
        User[] sortArr = treeSetExample.sort(users);
        treeSetExample.query();
        System.out.println("-----------------------");
        //2、添加元素
        if(treeSetExample.add(new User(4,"小白"))){
            System.out.println("添加成功");
            treeSetExample.query();
        }
        System.out.println("-----------------------");
        //3.删除元素
        if(treeSetExample.remove(uTwo)){
            System.out.println("移除成功");
            treeSetExample.query();
        }
        System.out.println("-----------------------");
        //4.是否包含元素
        if(treeSetExample.contains(uThree)){
            System.out.println("包含该元素");
            treeSetExample.query();
        }
        System.out.println("-----------------------");
        //5.将set集合转为数组输出
        for (User user : treeSetExample.toArray()) {
            System.out.println(user);
        }
    }
}
