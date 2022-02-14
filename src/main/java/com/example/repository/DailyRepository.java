package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Monthly;

@Repository
public class DailyRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public Monthly save(Monthly dailyData) {
		SqlParameterSource param =new BeanPropertySqlParameterSource(dailyData);
		String sql ="UPDATE monthly "
				  + "SET attendance_status = :attendanceStatus,"
				  + "start_time  = :startTime, "
				  + "end_time = :endTime, "
				  + "break_time = :breakTime, "
				  + "comment = :comment "
				  + "WHERE user_id = :userId "
				  + "AND year = :year "
				  + "AND month = :month "
				  + "AND day =:day;";
		template.update(sql, param);
		
		return null;
	}
	

}
