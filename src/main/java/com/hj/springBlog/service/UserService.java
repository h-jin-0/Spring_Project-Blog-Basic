package com.hj.springBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private MyUserDetailService myUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional
	public int 회원가입(ReqJoinDto dto) {
		try {
			//아이디 중복체크
			int result=userRepository.findByUsername(dto.getUsername());

			if(result==1) {
				return ReturnCode.아이디중복;
			}else {
				//패스워드 암호화 하기!
				String encodePassword=passwordEncoder.encode(dto.getPassword());
				dto.setPassword(encodePassword);//암호화되서 들어간다.토큰이 알아서 바꿔서해준다.
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
		User principal=myUserDetailService.getPrincipal();//여기서 세션을 들고옴
	
		String encodePassword=passwordEncoder.encode(dto.getPassword());
		int result=userRepository.update(dto);
		if(result==1) {
			User user= userRepository.findById(dto.getId());
			principal.setPassword(encodePassword);
			principal.setProfile(user.getProfile());
			return 1;
		}else {
			return -1;
		}
		
	}
}
