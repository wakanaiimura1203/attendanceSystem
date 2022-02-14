package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Monthly;
import com.example.repository.MonthlyRepository;

/**
 * @author shirayamawakana
 * 月次勤怠を表示するためのサービスクラス
 */
@Service
@Transactional
public class MonthlyService {
	
	@Autowired
	private MonthlyRepository monthlyRepository;
	
	/*月選択時の処理*/
	public List<Monthly> load(Monthly monthly){
		monthlyRepository.update(monthly);
		List<Monthly> monthlyList = monthlyRepository.load(monthly);
//		if(monthlyList.size() == 0) {
//			monthlyRepository.save(monthly);
//		}
		return monthlyList;
	}
		
	//public Monthly save(Monthly monthly) {
//		/*カレンダークラスを生成*/
//		Calendar cal = Calendar.getInstance();
//		/*入力された年情報をカレンダーにセット*/
//		int year = monthly.getYear();
//		int month = Integer.parseInt(monthly.getYearMonth().substring(5,7));
//		cal.set(Calendar.YEAR,year);
//		cal.set(Calendar.MONTH,month-1);
//		
//		monthly.setMonth(month);
//		/*選択月の最終日を求める*/
//		int result = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//		
//		for(int i =1; i<= result; i++) {
//			monthly.setDay(i);
//		}
		//monthlyRepository.save(monthly);
		//return monthly;
	//}

}
