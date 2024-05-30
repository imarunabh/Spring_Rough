package com.codeElevate.blogServer.service;

import java.util.List;

import com.codeElevate.blogServer.entity.Comment;

public interface CommentService {
	
	Comment createComment(Long postId,String postedBy,String content);
	List<Comment> getCommentByPostId(Long postId);

}
