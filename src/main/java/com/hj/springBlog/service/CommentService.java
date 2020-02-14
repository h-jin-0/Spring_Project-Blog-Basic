package com.hj.springBlog.service;

import java.util.List;

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

	public RespDetailDto 댓글등록(ReqDetailDto dto) {
		int result = commentRepository.save(dto);

		if (result == 1) {
			return commentRepository.findById(dto.getId());
		} else {
			return null;
		}
	}

	public int 댓글삭제(int id,User principal) {
		RespDetailDto comment = commentRepository.findById(id);

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
