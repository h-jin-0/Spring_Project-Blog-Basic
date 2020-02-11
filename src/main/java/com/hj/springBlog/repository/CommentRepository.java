package com.hj.springBlog.repository;


import java.util.List;

import com.hj.springBlog.model.comment.dto.ReqDetailDto;
import com.hj.springBlog.model.comment.dto.RespDetailDto;

public interface CommentRepository {

//	List<ResponseTeamDto> TeamAll();
	int save(ReqDetailDto dto);
	RespDetailDto findById(int id);
	int delete(int id);
	List<RespDetailDto> findByPostId(int postId);
}
