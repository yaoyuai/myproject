package com.course.mapper;

import com.course.qo.CommentInfoQo;
import com.course.vo.CommentInfoVo;

import java.util.List;

public interface CommentInfoMapper {


    List<CommentInfoVo> showAllComment(CommentInfoQo commentInfoQo);

    int showAllCommentCount(CommentInfoQo commentInfoQo);

    int addComment(CommentInfoQo commentInfoQo);

    int deleteComment(String commentId);

    int updateComment(CommentInfoQo commentInfoQo);

    List<CommentInfoVo> showFrontAllComment(CommentInfoQo commentInfoQo);

    int showFrontAllCommentCount(CommentInfoQo commentInfoQo);
}
