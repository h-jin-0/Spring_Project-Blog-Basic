package com.hj.springBlog.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.springBlog.model.ReturnCode;
import com.hj.springBlog.model.comment.dto.ReqDetailDto;
import com.hj.springBlog.model.comment.dto.RespDetailDto;
import com.hj.springBlog.model.user.User;
import com.hj.springBlog.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private HttpSession session;

	public RespDetailDto 댓글등록(ReqDetailDto dto) {
		int result = commentRepository.save(dto);
		
		if(result == 1) { // 댓글쓰기 성공
			//  select
			return commentRepository.findById(dto.getId());
		}else { // 댓글쓰기 실패
			return null;
		}
	}

	public int 댓글삭제(int id) {
		RespDetailDto comment = commentRepository.findById(id);
		User principal = (User) session.getAttribute("principal");
		if (principal.getId() == comment.getUserId()) {
			return commentRepository.delete(id);
		} else {
			return ReturnCode.권한없음;
		}
	}

	public List<RespDetailDto> 댓글목록보기(int postId) {

		return commentRepository.findByPostId(postId);
	}
}
