package com.course.service.impl;

import com.course.mapper.CommentInfoMapper;
import com.course.qo.CommentInfoQo;
import com.course.service.CommentInfoService;
import com.course.vo.CommentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentInfoServiceImpl implements CommentInfoService {
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    @Override
    public List<CommentInfoVo> showAllComment(CommentInfoQo commentInfoQo) {
        if(commentInfoQo.getCourseName()==null || commentInfoQo.getCourseName().trim().isEmpty()){
            commentInfoQo.setCourseName(null);
        }
        if(commentInfoQo.getStudentName()==null || commentInfoQo.getStudentName().trim().isEmpty()){
            commentInfoQo.setStudentName(null);
        }
        if(commentInfoQo.getStateId()==null || commentInfoQo.getStateId().equals("-1")){
            commentInfoQo.setStateId(null);
        }
        return commentInfoMapper.showAllComment(commentInfoQo);
    }

    @Override
    public int showAllCommentCount(CommentInfoQo commentInfoQo) {
        if(commentInfoQo.getCourseName()==null || commentInfoQo.getCourseName().trim().isEmpty()){
            commentInfoQo.setCourseName(null);
        }
        if(commentInfoQo.getStudentName()==null || commentInfoQo.getStudentName().trim().isEmpty()){
            commentInfoQo.setStudentName(null);
        }
        if(commentInfoQo.getStateId()==null || commentInfoQo.getStateId().equals("-1")){
            commentInfoQo.setStateId(null);
        }
        return commentInfoMapper.showAllCommentCount(commentInfoQo);
    }

    @Override
    public int addComment(CommentInfoQo commentInfoQo) {
        if(commentInfoQo.getStudentId()==null){
            return -1;
        }
        if(commentInfoQo.getCommentContent()==null || commentInfoQo.getCommentContent().trim().isEmpty()){
            return -1;
        }
        if(commentInfoQo.getCourseId()==null){
            return -1;
        }
        return commentInfoMapper.addComment(commentInfoQo);
    }

    @Override
    public int deleteComment(String commentId) {
        return commentInfoMapper.deleteComment(commentId);
    }

    @Override
    public int updateComment(CommentInfoQo commentInfoQo) {
        if(commentInfoQo.getTeacherContent()==null || commentInfoQo.getTeacherContent().trim().isEmpty()){
            return -1;
        }
        if(commentInfoQo.getTeacherId()==null){
            return -1;
        }
        return commentInfoMapper.updateComment(commentInfoQo);
    }
}
