package com.chat.mapper;

import java.util.ArrayList;

import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

public interface RoomMapper {

	/**
	 * 채팅방 리스트
	 * @param RoomVO
	 */
	ArrayList<RoomVO> roomList(RoomVO paging);
	
	/**
	 * 총 채팅방 수
	 */
	int listTotalCount();
	
	/**
	 * 채팅방 개설
	 * @param RoomVO
	 */
	void roomAdd(RoomVO room);
	
	/**
	 * 제일 마지막 채팅방 정보 로드
	 */
	ArrayList<RoomVO> lastChatInfo();
	
	/**
	 * 채팅방 정보 로드
	 * @param RoomVO
	 */
	ArrayList<RoomVO> chatInfo(RoomVO room);
	
	/**
	 * 채팅방 방장 체크
	 * @param RoomVO
	 */
	ArrayList<RoomVO> masterCheck(RoomVO room);
	
	/**
	 * 채팅방 삭제
	 * @param RoomVO
	 */
	void roomRemove(RoomVO room);

}