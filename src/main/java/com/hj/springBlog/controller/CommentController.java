package com.hj.springBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hj.springBlog.model.RespCM;
import com.hj.springBlog.model.comment.dto.ReqDetailDto;
import com.hj.springBlog.model.comment.dto.RespDetailDto;
import com.hj.springBlog.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/comment/write")
	public ResponseEntity<?> write(@RequestBody ReqDetailDto dto) {
		RespDetailDto comment = commentService.댓글등록(dto);

		if (comment != null) {
			comment.setStatus(new RespCM(200, "ok"));
			return new ResponseEntity<RespDetailDto>(comment, HttpStatus.OK);
		} else {
			RespDetailDto error = new RespDetailDto();
			error.setStatus(new RespCM(400, "fail"));
			return new ResponseEntity<RespDetailDto>(error, HttpStatus.OK);
		}
	}

	@DeleteMapping("comment/delete/{id}")
	public ResponseEntity<?> write(@PathVariable int id) {
	
		int result = commentService.댓글삭제(id);

		if (result == 1)
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		else if(result==3)
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);
		else
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
	}
}
