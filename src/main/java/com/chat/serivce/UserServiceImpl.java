package com.chat.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.UserDAO;
import com.chat.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	/**
	 * 회원가입
	 * @param id		아이디
	 * @param name		닉네임
	 * @param mail		이메일
	 * @param pwd		패스워드
	 */
	public void userInsert(String id, String name, String mail, String pwd) {
		UserVO user = new UserVO();

	    user.setUser_id(id);
	    user.setUser_name(name);
	    user.setUser_mail(mail);
	    user.setUser_pwd(pwd);
		
	    userDAO.userInsert(user);
	}

	/**
	 * ID 중복체크
	 * @param id		아이디
	 * @return idCheck
	 */
	public int idCheck(String id) {
		UserVO user = new UserVO();
	    user.setUser_id(id);

		return userDAO.idCheck(user);
	}
	
	/**
	 * 닉네임 중복체크
	 * @param name		닉네임
	 * @return nameCheck
	 */
	public int nameCheck(String name) {
		UserVO user = new UserVO();
	    user.setUser_name(name);

		return userDAO.nameCheck(user);
	}
	
	/**
	 * 이메일 중복체크
	 * @param mail		닉네임
	 * @return mailCheck
	 */
	public int mailCheck(String mail) {
		UserVO user = new UserVO();
	    user.setUser_mail(mail);

		return userDAO.mailCheck(user);
	}

	/**
	 * 로그인 체크
	 * @param id		아이디
	 * @param pwd		패스워드
	 * @return userCheck
	 */
	public List<UserVO> userCheck(String id, String pwd) {
		UserVO user = new UserVO();
		
		user.setUser_id(id);
		user.setUser_pwd(pwd);

		return userDAO.userCheck(user);
	}
	
	/**
	 * 아이디 찾기
	 * @param user_mail 이메일
	 * @return idSearchResult
	 */
	public String idSearchResult(String user_mail) {
		UserVO user = new UserVO();

	    user.setUser_mail(user_mail);

		return userDAO.idSearchResult(user);
	}
	
	/**
	 * 비밀번호 찾기
	 * @param user_id	아이디
	 * @return pwdSearchResult
	 */
	public String pwdSearchResult(String user_id) {
		UserVO user = new UserVO();

	    user.setUser_id(user_id);

		return userDAO.pwdSearchResult(user);
	}
	
	/**
	 * 비밀번호 수정
	 * @param user_id	아이디
	 * @param user_pwd	변경될 비밀번호
	 */
	public void pwdChange(String user_id, String user_pwd) {
		UserVO user = new UserVO();

	    user.setUser_id(user_id);
	    user.setUser_pwd(user_pwd);

	    userDAO.pwdChange(user);
	}

	/**
	 * 회원정보
	 * @param id		아이디
	 * @return userInfo
	 */
	public List<UserVO> userInfo(String id) {
		UserVO user = new UserVO();
		user.setUser_id(id);

		return userDAO.userInfo(user);
	}
	
	/**
	 * 회원정보 수정
	 * @param id		아이디
	 * @param name		닉네임
	 * @param mail		이메일
	 */
	public void userUpdate(String id, String name, String mail) {
		UserVO user = new UserVO();

	    user.setUser_id(id);
	    user.setUser_name(name);
	    user.setUser_mail(mail);

	    userDAO.userUpdate(user);
	}
	
}
