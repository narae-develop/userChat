package com.chat.serivce;

import java.util.List;

import com.chat.vo.UserVO;

public interface UserService {
	
	/**
	 * 회원가입
	 * @param id		아이디
	 * @param name		닉네임
	 * @param mail		이메일
	 * @param pwd		패스워드
	 */
	public void userInsert(String id, String name, String mail, String pwd);

	/**
	 * ID 중복체크
	 * @param id		아이디
	 */
	public int idCheck(String id);

	/**
	 * 닉네임 중복체크
	 * @param name		닉네임
	 */
	public int nameCheck(String name);
	
	/**
	 * 이메일 중복체크
	 * @param mail		이메일
	 */
	public int mailCheck(String mail);

	/**
	 * 로그인 체크
	 * @param id		아이디
	 * @param pwd		패스워드
	 */
	public List<UserVO> userCheck(String id, String pwd);

	/**
	 * 아이디 찾기
	 * @param user_mail 이메일
	 */
	public String idSearchResult(String user_mail);
	
	/**
	 * 비밀번호 찾기
	 * @param user_id	아이디
	 */
	public String pwdSearchResult(String user_id);

	/**
	 * 비밀번호 수정
	 * @param user_id	아이디
	 * @param user_pwd	변경될 비밀번호
	 */
	public void pwdChange(String user_id, String user_pwd);

	/**
	 * 회원정보
	 * @param id		아이디
	 */
	public List<UserVO> userInfo(String id);
	
	/**
	 * 회원정보 수정
	 * @param id		아이디
	 * @param name		닉네임
	 * @param mail		이메일
	 */
	public void userUpdate(String id, String name, String mail);
	
}
