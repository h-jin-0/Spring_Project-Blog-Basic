package com.hj.springBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.springBlog.model.RespCode;
import com.hj.springBlog.model.user.dto.ReqJoinDto;
import com.hj.springBlog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		try {
			//아이디 중복체크
			int result=userRepository.findByUsername(dto.getUsername());
			if(result==1) {
				return RespCode.아이디중복;
			}else {
				return userRepository.save(dto);
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
