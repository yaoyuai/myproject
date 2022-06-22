package com.bosssoft.hr.javase;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName HashMapExample.java
 * @Description TODO
 * @createTime 2022年06月11日 00:34:00
 */
public class HashMapExample {

    private Map<Integer,User> map=new HashMap<Integer, User>();
    
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18
     * @param key
     * @param value 
     * @return com.boss.test.User
     */
    User put(Integer key,User value){
        return map.put(key,value);
    }
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18
     * @param key 
     * @return com.boss.test.User
     */
    User remove(Integer key){
        return map.remove(key);
    }
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18
     * @param key 
     * @return boolean
     */
    boolean containsKey(Integer key){
        return map.containsKey(key);
    }
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18 
     */
    void visitByEntrySet(){
        for(Map.Entry<Integer, User> entry:map.entrySet()){
            System.out.println(entry);
        }
    }
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18 
     */
    void visitByKeySet(){
        for(Integer key:map.keySet()){
            System.out.println("键:"+key+"值:"+map.get(key));
        }
    }
    /*
     * 
     * @author yaoyu
     * @date 2022/6/11 11:18 
     */
    void visitByValues(){
        for(User user:map.values()){
            System.out.println("值:"+user);
        }
    }

    public static void main(String[] args) {

        //初始化数据
        HashMapExample hashMapExample=new HashMapExample();

        //添加数据
        hashMapExample.put(1,new User(1,"小明"));
        hashMapExample.put(2,new User(2,"小红"));
        hashMapExample.put(3,new User(3,"小栏"));
        hashMapExample.put(4,new User(4,"小主"));

        //移除数据
        User user=hashMapExample.remove(4);
        if(user!=null){
            System.out.println("移除"+user+"成功");
        }

        //是否存在key
        System.out.println(hashMapExample.containsKey(1)?"存在key1":"不存在key1");

        //第一种遍历方式：通过set视图
        hashMapExample.visitByEntrySet();
        System.out.println("----------------");
        //第二种遍历方式: 通过keyset方法
        hashMapExample.visitByKeySet();
        System.out.println("----------------");
        //第三种遍历方式: 通过vaules()方法
        hashMapExample.visitByValues();

    }
}
