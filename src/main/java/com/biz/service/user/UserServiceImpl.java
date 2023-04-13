package com.biz.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.vo.user.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	public UserVO loginUser(UserVO vo) {
		return userDAO.loginUser(vo);
	}	
}