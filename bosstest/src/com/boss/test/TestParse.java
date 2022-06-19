package com.boss.test;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName TestParse.java
 * @Description TODO
 * @createTime 2022年06月19日 18:51:00
 */
public class TestParse {
    public static void main(String[] args) {

        Parser parser=new Dom4jPaser();
        User[] users = parser.parse("user.xml");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
