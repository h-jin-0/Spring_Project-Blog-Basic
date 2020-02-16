package com.hj.springBlog.repository;

import java.util.List;

import com.hj.springBlog.model.post.Post;
import com.hj.springBlog.model.post.dto.Criteria;
import com.hj.springBlog.model.post.dto.ReqDeleteDto;
import com.hj.springBlog.model.post.dto.ReqUpdateDto;
import com.hj.springBlog.model.post.dto.ReqWriteDto;
import com.hj.springBlog.model.post.dto.RespListDto;
import com.hj.springBlog.model.post.dto.ReqPaging;

public interface PostRepository {

	List<RespListDto> findAll();
	int save(ReqWriteDto dto);
	Post findById(int postId);
	int update(ReqUpdateDto dto);
	int delete(ReqDeleteDto dto);
	List<RespListDto> listPaging(ReqPaging reqPaging);
	int totalCount();
}
