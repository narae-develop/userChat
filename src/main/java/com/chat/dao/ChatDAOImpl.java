package com.chat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.mapper.ChatMapper;
import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

@Repository
public class ChatDAOImpl implements ChatDAO {

	@Autowired
	private SqlSession sqlSession;

	/**
	 * 대화내용 리스트
	 * @param ChatVO
	 * @return chatList
	 */
	public List<ChatVO> chatList(ChatVO chat) {
		List<ChatVO> chatList;
		ChatMapper resultMapper = sqlSession.getMapper(ChatMapper.class);

		chatList = resultMapper.chatList(chat);

		return chatList;
	}
	
	/**
	 * 대화내용 입력
	 * @param ChatVO
	 * @return chatInsert
	 */
	public void chatInsert(ChatVO chat) {
		ChatMapper resultMapper = sqlSession.getMapper(ChatMapper.class);
		resultMapper.chatInsert(chat);
	}

}
