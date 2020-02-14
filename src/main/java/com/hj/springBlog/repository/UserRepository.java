package com.hj.springBlog.repository;

import com.hj.springBlog.model.user.User;
import com.hj.springBlog.model.user.dto.ReqJoinDto;
import com.hj.springBlog.model.user.dto.ReqLoginDto;
import com.hj.springBlog.model.user.dto.ReqProfileDto;

public interface UserRepository {

	int save(ReqJoinDto dto);

	int findByUsername(String username);

	User authentication(String username);

	User findByUsernameAndPassword(ReqLoginDto dto);

	int update(ReqProfileDto dto);

	User findById(int id);

}
