package com.hj.springBlog.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hj.springBlog.model.RespCM;
import com.hj.springBlog.model.post.dto.ReqDeleteDto;
import com.hj.springBlog.model.post.dto.ReqUpdateDto;
import com.hj.springBlog.model.post.dto.ReqWriteDto;
import com.hj.springBlog.model.user.User;
import com.hj.springBlog.service.CommentService;
import com.hj.springBlog.service.PostService;

//security 구현 완료
@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;

	@Autowired
	private HttpSession session;

	@GetMapping({ "", "/", "/post" })
	public String posts(Model model) {

		model.addAttribute("posts", postService.글목록());
		return "/post/list";
	}

	@GetMapping("/post/{postId}")
	public String post(@PathVariable int postId, Model model) {

		model.addAttribute("comments", commentService.댓글목록보기(postId));
		model.addAttribute("post", postService.글상세보기(postId));
		return "/post/detail";
	}

	// 인증체크(세션이 있어야 글쓰기 가능)
	@GetMapping("/post/write")
	public String write() {
		return "/post/write";
	}

	@PostMapping("/post/write")
	public ResponseEntity<?> write(@Valid @RequestBody ReqWriteDto dto, BindingResult bindingResult) {
		User principal = (User) session.getAttribute("principal");
		dto.setUserId(principal.getId());

		int result = postService.글쓰기(dto);

		if (result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 인증 체크, 동일인 체크
	@GetMapping("/post/update/{postId}")
	public String update(@PathVariable int postId, Model model) {
		model.addAttribute("post", postService.수정하기(postId));
		
		return "/post/update";
	}

	@PutMapping("/post/update")
	public ResponseEntity<?> update(@Valid @RequestBody ReqUpdateDto dto) {

		int result = postService.수정완료(dto);
		
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);	
		}else if(result == -3) {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/post/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody ReqDeleteDto dto) {

		int result = postService.글삭제(dto);
		if (result == 1)
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		else
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
