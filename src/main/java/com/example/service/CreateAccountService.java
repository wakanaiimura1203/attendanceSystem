package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.CreateAccountRepository;

/**
 * @author shirayamawakana
 * ユーザー登録メソッドを操作するサービスクラス
 *
 */
@Service
@Transactional
public class CreateAccountService {
	
	@Autowired
	private CreateAccountRepository createAccountRepository;
	
	/**
	 * @author shirayamawakana
	 * @param User　ユーザー情報
	 */
	public void insert(User user) {
		createAccountRepository.insert(user);
	}
}
