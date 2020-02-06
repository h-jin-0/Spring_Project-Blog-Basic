package com.hj.springBlog.repository;

import com.hj.springBlog.model.user.dto.ReqJoinDto;

public interface UserRepository {

	int save(ReqJoinDto dto);
	int findByUsername(String username);

}
