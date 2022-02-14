package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Time;

/**
 * @author shirayamawakana 勤怠時間を管理するためのリポジトリ
 *
 */
@Repository

public class TimeRecordRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/* timeドメインのローマッパー */
	private static final RowMapper<Time>TIME_ROW_MAPPER = new BeanPropertyRowMapper<>(Time.class);
	
	/* 出勤ボタン押下時の処理 */
	public Time save(Time time) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(time);
		String statusSql = "UPDATE users SET status ='勤務中' WHERE id = :userId";
		template.update(statusSql, param);

		if (time.getInputStartTime() == null) {
			String startTimeSql = "INSERT INTO times(user_id,date_of_day,input_start_time) "
					+ "VALUES(:userId,CURDATE(),NOW())";
			template.update(startTimeSql, param);
		}
		
		String monthlySql ="UPDATE monthly "
						 + "SET attendance_status = '出勤',break_time = '01:00' "
						 + "WHERE user_id = :userId "
						 + "AND year = YEAR(CURDATE()) "
						 + "AND month = MONTH(CURDATE()) "
						 + "AND day = DAY(CURDATE());";
		template.update(monthlySql, param);
		return null;
	}

	/* 退勤ボタン押下時の処理 */
	public Time save2(Time time) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(time);
		String statusSql = "UPDATE users SET status ='退勤' WHERE id = :userId";
		template.update(statusSql, param);

		if (time.getInputEndTime() == null) {
			String endTimeSql = "UPDATE times SET input_end_time = NOW() WHERE user_id = :userId";
			template.update(endTimeSql, param);
		} 
		return null;
	}

	/*
	 * トップページに表示用 出勤・退勤時刻を取得するための処理 userIdからTimeに入っている時刻をすべて取得
	 */
	public List<Time> load(Integer userId) {
		String sql = "SELECT * FROM times WHERE user_id = :userId AND date_of_day = CURRENT_DATE();";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		List<Time> timeList = template.query(sql, param, TIME_ROW_MAPPER);
		if(timeList.size() == 0) {
			return null;
		}
		return timeList;
////		SqlParameterSource param = new BeanPropertySqlParameterSource(userId);
//		if(userId != null) {
//		String sql = "SELECT * FROM times WHERE user_id = :userId AND date_of_day = CURDATE() ";
//		List<Time> timeList = template.query(sql,param,VIEWTIME_ROW_MAPPER);
//		if(timeList.size() == 0) {
//			return null;
//		}
//		return timeList.get(0);
//		}
//		return userId;
//		
	}

}
