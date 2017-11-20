package com.chat.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.ChatDAO;
import com.chat.vo.ChatVO;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatDAO chatDAO;

	/**
	 * 대화내용 리스트
	 * @param seq 채팅방 번호
	 * @return chatList
	 */
	public List<ChatVO> chatList(int seq) {
		ChatVO chat = new ChatVO();
		
		chat.setRoom_seq(seq);

		return chatDAO.chatList(chat);
	}
	
	/**
	 * 대화내용 입력
	 * @param seq		채팅방 번호
	 * @param name		닉네임
	 * @param content	대화내용
	 */
	public void chatInsert(int seq, String name, String content) {
		ChatVO chat = new ChatVO();

	    chat.setRoom_seq(seq);
	    chat.setUser_name(name);
	    chat.setContent(content);
		
		chatDAO.chatInsert(chat);
	}

}