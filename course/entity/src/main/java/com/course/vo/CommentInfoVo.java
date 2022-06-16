package com.course.vo;

import com.course.pojo.CommentInfo;
import lombok.Data;

@Data
public class CommentInfoVo extends CommentInfo {
    private String courseName;
    private String stateName;
    private String studentName;
}
