package com.example.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Ontime;

@Repository
public class OntimeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ontime>ONTIMES_ROW_MAPPER = new BeanPropertyRowMapper<>(Ontime.class);
	
//	public Ontime load(Ontime ontime) {
//		String sql = "SELECT * FROM ontimes where user_id=:userId";
//		SqlParameterSource param = new BeanPropertySqlParameterSource(ontime);
//		template.queryForObject(sql, param, ONTIMES_ROW_MAPPER);
//		
//		return template.queryForObject(sql, param, ONTIMES_ROW_MAPPER);
//	}
	
	public Ontime save(Ontime ontime){
		SqlParameterSource param = new BeanPropertySqlParameterSource(ontime);
		
		//ontimesテーブル内のuser_idが重複している場合はUPDATE、重複がなければINSERT
		String inputSql = "INSERT INTO ontimes(user_id,standard_start_time,standard_end_time,break_time) "
						+ "VALUES(:userId,:standardStartTime,:standardEndTime,'01:00') "
						+ "ON DUPLICATE KEY UPDATE "
						+ "standard_start_time =:standardStartTime,standard_end_time =:standardEndTime;";
		template.update(inputSql, param);
		
		//ontimesの休憩時間をmonthlyに反映
		String updateBreakSql = "UPDATE monthly,ontimes "
							  + "SET monthly.break_time = ontimes.break_time "
							  + "WHERE monthly.user_id = ontimes.user_id "
							  + "AND monthly.user_id = :userId ";
		template.update(updateBreakSql, param);
		
		return null;
	}

	
}
