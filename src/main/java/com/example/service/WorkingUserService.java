package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.WorkingUserRepository;

@Service
@Transactional
public class WorkingUserService {

	@Autowired
	private WorkingUserRepository workingUserRepository;
	
	
	/*勤務中ステータユーザーの取得*/
	public List<User> findByWorkingUser(){
		List<User> workingList = workingUserRepository.findByWorkingUser();
		return workingList;
	}
}
