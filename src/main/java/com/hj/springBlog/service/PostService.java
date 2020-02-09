package com.hj.springBlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.springBlog.model.post.Post;
import com.hj.springBlog.model.post.dto.ReqDeleteDto;
import com.hj.springBlog.model.post.dto.ReqUpdateDto;
import com.hj.springBlog.model.post.dto.ReqWriteDto;
import com.hj.springBlog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public int 글쓰기(ReqWriteDto dto) {
		return postRepository.save(dto);
	}
	
	@Transactional
	public List<Post> 글목록() {
		return postRepository.findAll();
	}
	
	@Transactional
	public Post 글상세보기(int postId) {
		return postRepository.findById(postId);
	}
	
	@Transactional
	public int 글수정(ReqUpdateDto dto) {
		return postRepository.update(dto);
	}
	
	@Transactional
	public int 글삭제(ReqDeleteDto dto) {
		return postRepository.delete(dto);
	}
}
