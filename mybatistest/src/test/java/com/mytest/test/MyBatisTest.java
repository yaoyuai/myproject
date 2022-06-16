package com.mytest.test;

import com.mytest.mapper.UserMapper;
import com.mytest.pojo.User;
import com.mytest.qo.UserQo;
import com.mytest.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年06月11日 21:48:00
 */
public class MyBatisTest {



    @Test
    public void testRead(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.readAllUserByRole();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testAdd(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQo userQo=new UserQo();
        userQo.setUserName("你好啊");
        if(mapper.addUser(userQo)>0){
            System.out.println("添加成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testdelete(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        if(mapper.deleteUser(1)>0){
            System.out.println("删除成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testModify(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserQo userQo=new UserQo();
        userQo.setUserId("4");
        userQo.setUserName("姚大哥");
        if(mapper.modifyUserByUserId(userQo)>0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
