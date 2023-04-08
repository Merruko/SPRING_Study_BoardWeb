package com.service.user;

import com.vo.user.UserVO;

public interface UserService {
	// CRUD 기능의 메소드 구현
	// 회원조회
	UserVO getUser(UserVO vo);

}