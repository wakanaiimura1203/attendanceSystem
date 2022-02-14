package com.example.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Monthly;
import com.example.domain.Time;

/**
 * @author shirayamawakana
 * 月次勤怠を取得するためのリポジトリ
 */
@Repository
public class MonthlyRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/*Monthlyドメインのローマッパー*/
	private static final RowMapper<Monthly>MONTHLY_ROW_MAPPER = new BeanPropertyRowMapper<>(Monthly.class);
	
	private static final ResultSetExtractor<List<Monthly>> MONTHLY_EXTRACTOR =(rs) -> {
		List<Monthly> monthlyList = new ArrayList();
		
		Monthly monthly = null;
		while(rs.next()) {
			Integer userId = rs.getInt("user_id");
			monthly = monthlyList.get(userId);
			
			if(monthly == null) {
				monthly = new Monthly();
				monthly.setId(rs.getInt("id"));
				monthly.setUserId(rs.getInt("user_id"));
				monthly.setYear(rs.getInt("year"));
				monthly.setMonth(rs.getInt("month"));
				monthly.setDay(rs.getInt("day"));
				monthly.setDayOfWeek(rs.getString("day_of_week"));
				monthly.setAttendanceStatus(rs.getString("attendance_status"));
				monthly.setStartTime(rs.getString("start_time"));
				monthly.setEndTime(rs.getString("end_time"));
				monthly.setBreakTime(rs.getString("break_time"));
				monthly.setOverTime(rs.getString("over_time"));
				monthly.setInputStatus(rs.getString("input_status"));
				monthly.setComment(rs.getString("comment"));
				
				/*Timeをインスタンス化し中身を入れてMonthlyにセット*/
				Time time = new Time();
				time.setId(rs.getInt("id"));
				time.setUserId(rs.getInt("user_id"));
				time.setDateOfDay(rs.getDate("date_of_day"));
				time.setInputStartTime(rs.getString("input_start_time"));
				time.setInputEndTime(rs.getString("input_end_time"));
				
				monthly.setTime(time);
			}
		}
		return monthlyList;
	
	};
	
	
	/* 月を選択し「選択」ボタン押下時の処理
	 * まずmonthlyテーブルに選択した年月を格納*/
	public List<Monthly> load(Monthly monthly) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(monthly);
		String serchSql = "SELECT * FROM monthly "
						+ "WHERE user_id = :userId "
						+ "AND year = :year "
						+ "AND month = :month "
						+ "ORDER BY day ASC";
		
//		String serchSql = "SELECT user_id,year,month,day,day_of_week,attendance_status,TIME_FORMAT(start_time,'%k:%i'),TIME_FORMAT(end_time,'%k:%i'),"
//						+ "TIME_FORMAT(break_time,'%k:%i'),TIME_FORMAT(over_time,'%k:%i'),input_status,comment "
//						+ "FROM monthly "
//						+ "WHERE user_id = :userId "
//						+ "AND year = :year "
//						+ "AND month = :month "
//						+ "ORDER BY day ASC";
		
//		String serchSql = "SELECT monthly.user_id,monthly.year,monthly.month,monthly.day,monthly.day_of_week,monthly.input_status,monthly.attendance_status,"
//						+ "monthly.start_time,monthly.end_time,monthly.break_time,monthly.over_time,monthly.comment,"
//						+ "times.input_start_time,times.input_end_time "
//						+ "FROM monthly "
//						+ "LEFT OUTER JOIN times "
//						+ "ON monthly.user_id = times.user_id "
//						+ "AND monthly.user_id = :userId "
//						+ "AND monthly.year = :year "
//						+ "AND monthly.month = :month "
//						+ "AND monthly.year = YEAR(times.date_of_day) "
//						+ "AND monthly.month = MONTH(times.date_of_day) "
//						+ "AND monthly.day = DAY(times.date_of_day) "
//						+ "WHERE monthly.user_id = :userId "
//						+ "ORDER BY day ASC;";
		/*もしリスト内が空であればsaveメソッドの処理に飛ぶ*/
		List<Monthly> monthlyList = template.query(serchSql, param,MONTHLY_ROW_MAPPER);
		if(monthlyList.size() == 0) {
			return save(monthly);
		}
		/*monthlyListとtimesテーブルを結合して持ってくる*/
//		List<Monthly> monthlyList = new ArrayList<>();
//		if(serchSql != null) {
//			String sql ="SELECT monthly.user_id,monthly.year,monthly.month,monthly.day,monthly.day_of_week,monthly.input_status,monthly.comment"
//					  + "times.user_id,times.start_time,times.end_time," //times.break_start_time,times.break_end_time,"
//					  + "times.over_time" //,times.standard_start_time,times.standard_end_time,times.comment"
//					  + "FROM monthly"
//					  + "LEFT OUTER JOIN times"
//					  + "ON monthly.user_id = :userId,"
//					  + "AND times.user_id = :user_id,"
//					  + "AND monthly.year = :year,"
//					  + "AND monthly.year = YEAR(times.date_of_day)";
			
//			monthlyList = template.query(sql,param,MONTHLY_ROW_MAPPER);
//			}
		return monthlyList;
		}
	
	
	/*monthlyテーブルに指定の年月がない場合、日付曜日とともに値を格納*/
	public List<Monthly> save(Monthly monthly) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(monthly);
		
		/*カレンダークラスを生成*/
		Calendar cal = Calendar.getInstance();
		/*入力された年情報をカレンダーにセット*/
		int year = monthly.getYear();
		int month = Integer.parseInt(monthly.getYearMonth().substring(5,7));
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month-1);
		monthly.setMonth(month);
		
		/*選択月の最終日を求める*/
		int result = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i =1; i<= result; i++) {
			monthly.setDay(i);
			/*カレンダーに年月日をセットし曜日を求める*/
			cal.set(year,month,i);
			monthly.setDayOfWeek(Integer.toString(cal.get(Calendar.DAY_OF_WEEK)-1));
			
			String daySql ="INSERT INTO monthly(user_id,year,month,day,day_of_week)"
						 + "VALUES(:userId,:year,:month,:day,:dayOfWeek)";
//						 + "CASE"
//						 + "WHEN day = :day THEN"
//						 + "END";
			template.update(daySql, param);
			
			//timesの時間をmonthlyに反映　→timeRecordRepositoryに移動？
//			String updateTimeSql = "UPDATE monthly,times "
//								 + "SET monthly.start_time = times.input_start_time,"
//								 + "monthly.end_time = times.input_end_time, "
//								 + "WHERE monthly.user_id = times.user_id "
//								 + "AND monthly.user_id = :userId "
//								 + "AND monthly.year = :year "
//								 + "AND monthly.month = :month "
//								 + "AND monthly.year = YEAR(times.date_of_day) "
//								 + "AND monthly.month = MONTH(times.date_of_day) "
//								 + "AND monthly.day = DAY(times.date_of_day);";
//			template.update(updateTimeSql, param);
		}
		
		
//		String updateSql = "UPDATE monthlys SET day = :day WHERE user_id=:userId";
//		template.update(updateSql, param);
		return load(monthly);
	}
	
	public List<Monthly> update(Monthly monthly){
		SqlParameterSource param = new BeanPropertySqlParameterSource(monthly);
		//timesの時間をmonthlyに反映　→timeRecordRepositoryに移動？
		String updateTimeSql = "UPDATE monthly,times "
							 + "SET monthly.start_time = times.input_start_time,"
							 + "monthly.end_time = times.input_end_time "
							 + "WHERE monthly.user_id = times.user_id "
							 + "AND monthly.user_id = :userId "
							 + "AND monthly.year = YEAR(times.date_of_day) "
							 + "AND monthly.month = MONTH(times.date_of_day) "
							 + "AND monthly.day = DAY(times.date_of_day);";
		template.update(updateTimeSql, param);
		return null;
	}
	
	
}
