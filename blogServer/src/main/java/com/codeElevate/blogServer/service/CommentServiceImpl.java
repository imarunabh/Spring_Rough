package com.codeElevate.blogServer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeElevate.blogServer.entity.Comment;
import com.codeElevate.blogServer.entity.Post;
import com.codeElevate.blogServer.repository.CommentRepository;
import com.codeElevate.blogServer.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public Comment createComment(Long postId,String postedBy,String content) {
		Optional<Post> optionalPost = postRepository.findById(postId);
		if(optionalPost.isPresent()) {
			Comment comment= new Comment();
			comment.setPost(optionalPost.get());
			comment.setContent(content);
			comment.setPostedBy(postedBy);
			comment.setCreatedAt(new Date());
			
			return commentRepository.save(comment);
			
		}
		throw new EntityNotFoundException("Post Not Found");
		
	}
	
	public List<Comment> getCommentByPostId(Long postId){
		return commentRepository.findByPostId(postId);
		
	}

}
