package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.LoginRepository;

/**
 * @author shirayamawakana
 * ログイン・ログアウト機能用のserviceクラス
 *
 */
@Service
@Transactional
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	/**ログイン処理
	 * @param　メールアドレス 
	 * @param　パスワード
	 * @return　ユーザー情報　存在しない場合nullを返す
	 * */
	public User login(String email,String password) {
		User user = loginRepository.findByEmailAndPassword(email,password);
		if(user == null) {
			return null;
		}
		return user;
	}
	
	public User load(Integer id) {
		return loginRepository.load(id);
	}
	
}
