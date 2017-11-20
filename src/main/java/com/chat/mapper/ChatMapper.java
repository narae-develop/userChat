package com.chat.mapper;

import java.util.ArrayList;

import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

public interface ChatMapper {

	/**
	 * 대화내용 리스트
	 * @param ChatVO
	 */
	ArrayList<ChatVO> chatList(ChatVO chat);
	
	/**
	 * 대화내용 입력
	 * @param ChatVO
	 */
	void chatInsert(ChatVO chat);

}