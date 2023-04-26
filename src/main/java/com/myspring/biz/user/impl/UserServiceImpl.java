package com.myspring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.biz.user.UserService;
import com.myspring.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	// UserServiceImpl 클래스의 비즈니스 메소드를 구현할 때, 멤버변수로 선언된 UserDAO ,객체를 이용하여 DB 연동 처리

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
		// Setter 인젝션 처리를 위한 Setter 메소드 추가
	}

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

}
