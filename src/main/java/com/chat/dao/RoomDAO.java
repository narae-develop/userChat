package com.chat.dao;

import java.util.List;

import com.chat.vo.RoomVO;

public interface RoomDAO {
	
	/**
	 * 채팅방 리스트
	 * @param RoomVO
	 */
	List<RoomVO> roomList(RoomVO paging);
	
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
	List<RoomVO> lastChatInfo();
	
	/**
	 * 채팅방 정보 로드
	 * @param RoomVO
	 */
	List<RoomVO> chatInfo(RoomVO room);
	
	/**
	 * 채팅방 방장 체크
	 * @param RoomVO
	 */
	List<RoomVO> masterCheck(RoomVO room);
	
	/**
	 * 채팅방 삭제
	 * @param RoomVO
	 */
	void roomRemove(RoomVO room);
	
}
