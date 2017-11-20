package com.chat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.mapper.UserMapper;
import com.chat.vo.ChatVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SqlSession sqlSession;

	/**
	 * 회원가입
	 * @param UserVO
	 * @return userInsert
	 */
	public void userInsert(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		resultMapper.userInsert(user);
	}
	
	/**
	 * ID 중복체크
	 * @param UserVO
	 * @return idCheck
	 */
	public int idCheck(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.idCheck(user);
	}
	
	/**
	 * 닉네임 중복체크
	 * @param UserVO
	 * @return nameCheck
	 */
	public int nameCheck(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.nameCheck(user);
	}
	
	/**
	 * 이메일 중복체크
	 * @param UserVO
	 * @return mailCheck
	 */
	public int mailCheck(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.mailCheck(user);
	}
	
	/**
	 * 로그인 체크
	 * @param UserVO
	 * @return userCheck
	 */
	public List<UserVO> userCheck(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.userCheck(user);
	}
	
	/**
	 * 회원정보
	 * @param UserVO
	 * @return userInfo
	 */
	public List<UserVO> userInfo(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.userInfo(user);
	}
	
	/**
	 * 회원정보 수정
	 * @param UserVO
	 * @return userUpdate
	 */
	public void userUpdate(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		resultMapper.userUpdate(user);
	}
	
	/**
	 * 아이디 찾기
	 * @param UserVO
	 * @return idSearchResult
	 */
	public String idSearchResult(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.idSearchResult(user);
	}
	
	/**
	 * 비밀번호 찾기
	 * @param UserVO
	 * @return idSearchResult
	 */
	public String pwdSearchResult(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		return resultMapper.pwdSearchResult(user);
	}
	
	/**
	 * 비밀번호 수정
	 * @param UserVO
	 * @return pwdChange
	 */
	public void pwdChange(UserVO user) {
		UserMapper resultMapper = sqlSession.getMapper(UserMapper.class);
		resultMapper.pwdChange(user);
	}

}
