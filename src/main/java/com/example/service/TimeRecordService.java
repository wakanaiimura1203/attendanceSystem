package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Time;
import com.example.repository.TimeRecordRepository;

/**
 * @author shirayamawakana 「出勤」ボタン押下時の処理
 */
@Service
@Transactional
public class TimeRecordService {

	@Autowired
	private TimeRecordRepository timeRecordRepository;

	/* 出勤ボタン押下時の処理 */
	public Time save(Time time) {
		return timeRecordRepository.save(time);
	}

	/* 退勤ボタン押下時の処理 */
	public Time save2(Time viewTime) {
		return timeRecordRepository.save2(viewTime);
	}

	/* timesテーブルから情報を取得 */
	public List<Time> load(Integer userId) {
		List<Time> timeList = timeRecordRepository.load(userId);
		return timeList;
	}
}
