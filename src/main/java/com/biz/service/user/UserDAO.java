package com.biz.service.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biz.vo.user.UserVO;

// DAO(Data Access Object)
@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// CRUD 기능의 메소드 구현
	// 로그인
	public UserVO loginUser(UserVO vo) {
		System.out.println("===> MyBatis로 loginUser() 기능 처리");
		return (UserVO) mybatis.selectOne("UserMapper.loginUser", vo);
	}
}