package com.chat.dao;

import java.util.List;

import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

public interface ChatDAO {

	/**
	 * 대화내용 리스트
	 * @param ChatVO
	 */
	List<ChatVO> chatList(ChatVO chat);
	
	/**
	 * 대화내용 입력
	 * @param ChatVO
	 */
	void chatInsert(ChatVO chat);

}
