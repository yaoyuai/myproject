package com.mytest.mapper;

import com.mytest.pojo.User;
import com.mytest.qo.UserQo;

import java.util.List;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2022年06月11日 21:42:00
 */
public interface UserMapper {

    /*
     * 查询所有的用户所对应的角色（一对多 一个用户多个角色）
     * @author yaoyu
     * @date 2022/6/11 21:46
     * @return java.util.List<com.mytest.pojo.User>
     */
    List<User> readAllUserByRole();

    /*
     * 添加用户
     * @author yaoyu
     * @date 2022/6/11 21:46
     * @param userQo
     * @return int
     */
    int addUser(UserQo userQo);

    /*
     * 删除用户
     * @author yaoyu
     * @date 2022/6/11 21:47
     * @param userId
     * @return int
     */
    int deleteUser(int userId);

    /*
     * 更新用户
     * @author yaoyu
     * @date 2022/6/11 21:47
     * @param userQo
     * @return int
     */
    int modifyUserByUserId(UserQo userQo);

}
