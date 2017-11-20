package com.chat.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.RoomDAO;
import com.chat.vo.RoomVO;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	
	/**
	 * 채팅방 리스트
	 * @param skipCnt	스킵건수
	 * @param listSize	페이지에 보여줄 게시물 수
	 * @return roomList
	 */
	public List<RoomVO> roomList(int skipCnt, int listSize) {
		RoomVO paging = new RoomVO();
		
		paging.setSkipCnt(skipCnt);
		paging.setPageSize(listSize);

		return roomDAO.roomList(paging);
	}
	
	/**
	 * 총 채팅방 수
	 * @return listTotalCount
	 */
	public int listTotalCount() {
		return roomDAO.listTotalCount();
	}
	
	/**
	 * 채팅방 개설
	 * @param room_title	방제목
	 * @param master_id		방장 아이디
	 * @param master_name	방장 닉네임
	 * @return null
	 */
	public void roomAdd(String room_title, String master_id, String master_name) {
		RoomVO room = new RoomVO();
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

	    room.setRoom_title(room_title);
	    room.setMaster_id(master_id);
	    room.setMaster_name(master_name);
	    room.setDate(sqlDate);
		
	    roomDAO.roomAdd(room);
	}
	
	/**
	 * 제일 마지막 채팅방 정보 로드
	 * @return lastChatInfo
	 */
	public List<RoomVO> lastChatInfo() {
		return roomDAO.lastChatInfo();
	}
	
	/**
	 * 채팅방 정보 로드
	 * @param seq 채팅방 번호
	 * @return chatInfo
	 */
	public List<RoomVO> chatInfo(int seq) {
		RoomVO detail = new RoomVO();
		
		detail.setSeq(seq);

		return roomDAO.chatInfo(detail);
	}
	
	/**
	 * 채팅방 방장 체크
	 * @param seq		채팅방 번호
	 * @param user_id	유저아이디
	 * @return masterCheck
	 */
	public List<RoomVO> masterCheck(int seq, String user_id) {
		RoomVO room = new RoomVO();
		
		room.setSeq(seq);
		room.setMaster_id(user_id);

		return roomDAO.masterCheck(room);
	}
	
	/**
	 * 채팅방 삭제
	 * @param seq 채팅방 번호
	 */
	public void roomRemove(int seq) {
		RoomVO room = new RoomVO();
		
		room.setSeq(seq);
		
		roomDAO.roomRemove(room);
	}
	
}