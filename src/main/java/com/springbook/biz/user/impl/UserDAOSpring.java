package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

// DAO(Data Access Object)
@Repository
public class UserDAOSpring implements UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들 
	private final String USER_GET = "SELECT * FROM b_users WHERE id=? AND password=?";
	
	// CRUD 기능의 메소드 구현
	// 회원조회
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<UserVO> {
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("NAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setRole(rs.getString("ROLE"));
			return user;
		}
	}
}