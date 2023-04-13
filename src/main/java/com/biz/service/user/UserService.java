package com.biz.service.user;

import com.biz.vo.user.UserVO;

public interface UserService {
	// CRUD 기능의 메소드 구현
	// 로그인
	UserVO loginUser(UserVO vo);

}