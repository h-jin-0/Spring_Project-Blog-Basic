package com.hj.springBlog.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hj.springBlog.model.user.User;

@Controller
public class PostController {

	@Autowired
	private HttpSession session;

	@GetMapping({ "", "/", "/post" })
	public String posts() {

		return "/post/list";
	}

	@GetMapping("/post/{id}")
	public String post() {
		return "/post/detail";
	}

	// 인증체크(세션이 있어야 글쓰기 가능)
	@GetMapping("/post/write")
	public String write() {
		if (session.getAttribute("principal") != null) {
			return "/post/write";
		} else {
			return "redirect:/user/login";
		}
	}

	// 인증 체크, 동일인 체크
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id) {
		
		User principal=(User)session.getAttribute("principal");
		if(principal!=null) {
			if(principal.getId()==id) {
				return "/user/profile";
			}else {
				//잘못된 접근입니다.-권한이 없습니다.
				return "/user/login";
			}
		}else {
			//인증이 되지 않은 사용자입니다-로그인해주세요
			return "/user/login";
		}
		
	}

}
