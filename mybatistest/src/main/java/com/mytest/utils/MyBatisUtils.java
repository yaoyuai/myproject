package com.mytest.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName MyBatisUtils.java
 * @Description TODO
 * @createTime 2022年06月11日 19:09:00
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource="mybatis-config.xml";
        try {
            InputStream inputStream= Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取一个sqlsession的方法
     * @author yaoyu
     * @date 2022/6/11 19:10
     * @return org.apache.ibatis.session.SqlSession
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();//设置其为true代表自动开启事务提交
    }
}
