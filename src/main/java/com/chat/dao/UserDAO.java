package com.chat.dao;

import java.util.List;

import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

public interface UserDAO {

	/**
	 * 회원가입
	 * @param UserVO
	 */
	void userInsert(UserVO user);
	
	/**
	 * ID 중복체크
	 * @param UserVO
	 */
	int idCheck(UserVO user);
	
	/**
	 * 닉네임 중복체크
	 * @param UserVO
	 */
	int nameCheck(UserVO user);
	
	/**
	 * 이메일 중복체크
	 * @param UserVO
	 */
	int mailCheck(UserVO user);
	
	/**
	 * 로그인 체크
	 * @param UserVO
	 */
	List<UserVO> userCheck(UserVO user);
	
	/**
	 * 회원정보
	 * @param UserVO
	 */
	List<UserVO> userInfo(UserVO user);
	
	/**
	 * 회원정보 수정
	 * @param UserVO
	 */
	void userUpdate(UserVO user);
	
	/**
	 * 아이디 찾기
	 * @param UserVO
	 */
	String idSearchResult(UserVO user);
	
	/**
	 * 비밀번호 찾기
	 * @param UserVO
	 */
	String pwdSearchResult(UserVO user);
	
	/**
	 * 비밀번호 수정
	 * @param UserVO
	 */
	void pwdChange(UserVO user);
}
