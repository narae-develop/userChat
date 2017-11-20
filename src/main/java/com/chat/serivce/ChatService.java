package com.chat.serivce;

import java.util.List;

import com.chat.vo.ChatVO;

public interface ChatService {

	/**
	 * 대화내용 리스트
	 * @param seq 채팅방 번호
	 */
	public List<ChatVO> chatList(int seq);
	
	/**
	 * 대화내용 입력
	 * @param seq		채팅방 번호
	 * @param name		닉네임
	 * @param content	대화내용
	 */
	public void chatInsert(int seq, String name, String content);

}
