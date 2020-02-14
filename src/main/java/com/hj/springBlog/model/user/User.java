package com.hj.springBlog.model.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements UserDetails{
	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private String role;//USER,MANAGER,ADMIN
	private Timestamp createDate;
	@Builder
	public User(String username, String password, String email, String profile, String role, Timestamp createDate) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.role = role;
		this.createDate = createDate;
	}
	//username, password의 getter도 만들어져야하는데
	//우리는 필드명을 username,password로 만들었고,Lombok도 있어서 안만들어지는거임!!
	
	//여러개의 권한을 리턴하는거임
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> collectors=new ArrayList<>();
		collectors.add(new SimpleGrantedAuthority("ROLE_"+role));
		//"ROLE_"+   이거를 안적어주면 스프링이 인식을 못한다.
		//이렇게 권한 1개만 만들었다 그러니까 컬렉션의 0번지를 보면된다.
		return collectors;
	}
	//계정이 만료되었는지 체크하여 리턴한다(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	//계정이 잠겨있는지 체크하여 리턴한다(true:잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	//비밀번호가 만료되었는지 체크하여 리턴한다.(true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	//해당 계정이 활성화 되어있느지 체크하여 리턴한다(true:활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
