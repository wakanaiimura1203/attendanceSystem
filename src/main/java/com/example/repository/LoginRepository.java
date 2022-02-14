package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * @author shirayamawakana ログイン・ログアウト機能用リポジトリ
 */
@Repository
public class LoginRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};

	/*
	 * 主キーからユーザー情報を取得する。
	 * @param id
	 * @return ユーザー情報
	 */
	public User load(Integer id) {
		String sql = "SELECT * FROM users where id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		User user = template.queryForObject(sql, param, USER_ROW_MAPPER);
		return user;
	}

	/*
	 * メールアドレスとパスワードからユーザー情報を取得
	 * @param email
	 * @param password
	 * @return ユーザー情報（1件も取得できない場合はnullを返す)
	 */
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT * FROM users WHERE email=:email AND password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
}
