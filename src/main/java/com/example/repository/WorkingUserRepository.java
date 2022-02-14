package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class WorkingUserRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/*Userクラスのローマッパー*/
	private static final RowMapper<User>USER_ROW_MAPPER = new BeanPropertyRowMapper<>(User.class);
	
	/*勤務中ステータスのユーザ情報を取得*/
	public List<User> findByWorkingUser(){
		String sql = "SELECT * FROM users WHERE status = '勤務中';";
		List<User> workingList = template.query(sql, USER_ROW_MAPPER);
		
		if(workingList == null) {
			return null;
		}
		return workingList;
	}
}
