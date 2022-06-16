package com.mytest.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author yaoyu
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年06月11日 18:39:00
 */
@Data
public class User {
    private Integer userId;
    private String userName;
    private List<Role> roleList;
}
