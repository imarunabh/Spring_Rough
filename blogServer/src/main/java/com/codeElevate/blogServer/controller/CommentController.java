package com.codeElevate.blogServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeElevate.blogServer.service.CommentService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("comments/create")
	public ResponseEntity<?> createComment(@RequestParam Long postId,@RequestParam String postedBy,@RequestBody String content){
		
		try {
			return ResponseEntity.ok(commentService.createComment(postId, postedBy, content));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}
	
	@GetMapping("/comments/{postId}")
	public ResponseEntity<?> getCommentsByPostId(@PathVariable Long postId){
		try {
			return ResponseEntity.ok(commentService.getCommentByPostId(postId));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}

}
