package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * @author shirayamawakana
 *　ユーザー登録処理用のリポジトリー
 */
@Repository
public class CreateAccountRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "INSERT INTO users(name,email,password,telephone)"
					+ "VALUES(:name,:email,:password,:telephone)";
		template.update(sql,param);
		
	}

}
	