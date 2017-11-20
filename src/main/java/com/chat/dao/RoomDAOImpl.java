package com.chat.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.mapper.RoomMapper;
import com.chat.vo.RoomVO;
import com.chat.vo.UserVO;
import com.chat.vo.ChatVO;

@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * 채팅방 리스트
	 * @param RoomVO
	 * @return roomList
	 */
	public List<RoomVO> roomList(RoomVO paging) {
		List<RoomVO> result;
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);

		result = resultMapper.roomList(paging);

		return result;
	}
	
	/**
	 * 총 채팅방 수
	 * @return listTotalCount
	 */
	public int listTotalCount() {
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);
		return resultMapper.listTotalCount();
	}
	
	/**
	 * 채팅방 개설
	 * @param RoomVO
	 * @return roomAdd
	 */
	public void roomAdd(RoomVO room) {
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);
		resultMapper.roomAdd(room);
	}
	
	/**
	 * 제일 마지막 채팅방 정보 로드
	 * @return lastChatInfo
	 */
	public List<RoomVO> lastChatInfo() {
		List<RoomVO> result;
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);

		result = resultMapper.lastChatInfo();

		return result;
	}
	
	/**
	 * 채팅방 정보 로드
	 * @param RoomVO
	 * @return chatInfo
	 */
	public List<RoomVO> chatInfo(RoomVO room) {
		List<RoomVO> result;
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);

		result = resultMapper.chatInfo(room);

		return result;
	}
	
	/**
	 * 채팅방 방장 체크
	 * @param RoomVO
	 * @return masterCheck
	 */
	public List<RoomVO> masterCheck(RoomVO room) {
		List<RoomVO> result;
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);

		result = resultMapper.masterCheck(room);

		return result;
	}
	
	/**
	 * 채팅방 삭제
	 * @param RoomVO
	 * @return roomRemove
	 */
	public void roomRemove(RoomVO room) {
		RoomMapper resultMapper = sqlSession.getMapper(RoomMapper.class);
		resultMapper.roomRemove(room);
	}

}
