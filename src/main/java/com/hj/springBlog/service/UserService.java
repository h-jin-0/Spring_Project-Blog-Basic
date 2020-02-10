package com.hj.springBlog.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hj.springBlog.model.ReturnCode;
import com.hj.springBlog.model.user.User;
import com.hj.springBlog.model.user.dto.ReqJoinDto;
import com.hj.springBlog.model.user.dto.ReqLoginDto;
import com.hj.springBlog.model.user.dto.ReqProfileDto;
import com.hj.springBlog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;
	
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		try {
			//아이디 중복체크
			int result=userRepository.findByUsername(dto.getUsername());
			if(result==1) {
				return ReturnCode.아이디중복;
			}else {
				return userRepository.save(dto);
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@Transactional
	public User 로그인(ReqLoginDto dto) {
		return userRepository.findByUsernameAndPassword(dto);
	}
	@Transactional
	public int 회원수정(ReqProfileDto dto) {
		int result=userRepository.update(dto);
		if(result==1) {
			User user= userRepository.findById(dto.getId());
			session.setAttribute("principal", user);
			return 1;
		}else {
			return -1;
		}
		
	}
}
