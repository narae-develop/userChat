package com.chat.serivce;

import java.util.List;

import com.chat.vo.RoomVO;

public interface RoomService {
	
	/**
	 * 채팅방 리스트
	 * @param skipCnt	스킵건수
	 * @param listSize	페이지에 보여줄 게시물 수
	 */
	public List<RoomVO> roomList(int skipCnt, int listSize);
	
	/**
	 * 총 채팅방 수
	 */
	public int listTotalCount();
	
	/**
	 * 채팅방 개설
	 * @param room_title	방제목
	 * @param master_id		방장 아이디
	 * @param master_name	방장 닉네임
	 */
	public void roomAdd(String room_title, String master_id, String master_name);
	
	/**
	 * 제일 마지막 채팅방 정보 로드
	 * @return
	 */
	public List<RoomVO> lastChatInfo();
	
	/**
	 * 채팅방 정보 로드
	 * @param seq 채팅방 번호
	 */
	public List<RoomVO> chatInfo(int seq);
	
	/**
	 * 채팅방 방장 체크
	 * @param seq 		채팅방 번호
	 * @param user_id	유저아이디
	 * @return masterCheck
	 */
	public List<RoomVO> masterCheck(int seq, String user_id);
	
	/**
	 * 채팅방 삭제
	 * @param seq 채팅방 번호
	 */
	public void roomRemove(int seq);
	
}
