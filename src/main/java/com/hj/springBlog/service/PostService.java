package com.hj.springBlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.springBlog.model.ReturnCode;
import com.hj.springBlog.model.post.Post;
import com.hj.springBlog.model.post.dto.ReqDeleteDto;
import com.hj.springBlog.model.post.dto.ReqUpdateDto;
import com.hj.springBlog.model.post.dto.ReqWriteDto;
import com.hj.springBlog.model.post.dto.RespListDto;
import com.hj.springBlog.model.user.User;
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
	public List<RespListDto> 글목록() {
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
	public int 수정완료(ReqUpdateDto dto) {
		//직접 세션의 컨텍스트홀더에 접근해서 컨텍스트를 가져와서 그 안의 어선티케이션을 가져와서 그 안의 프린시펄을 가져온다.
		//직접 ㅅ세션 객체에 접근하여 가져오기
		User principal=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Post post = postRepository.findById(dto.getId());
		
		if(principal.getId() == post.getUserId()) {
			return postRepository.update(dto); // 1, 0, -1
		}else {
			return ReturnCode.권한없음; // -3
		}
	}
	public Post 수정하기(int id,User principal) {

		Post post = postRepository.findById(id);
		
		if(principal.getId() == post.getUserId()) {
			return post;
		}else {
			return null;
		}
	}
	
}
