package com.course.service;

import com.course.qo.CommentInfoQo;
import com.course.vo.CommentInfoVo;

import java.util.List;

public interface CommentInfoService {
    List<CommentInfoVo> showAllComment(CommentInfoQo commentInfoQo);

    int showAllCommentCount(CommentInfoQo commentInfoQo);

    int addComment(CommentInfoQo commentInfoQo);

    int deleteComment(String commentId);

    int updateComment(CommentInfoQo commentInfoQo);
}
