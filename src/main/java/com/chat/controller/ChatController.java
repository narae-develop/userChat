package com.chat.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chat.serivce.ChatService;
import com.chat.serivce.RoomService;
import com.chat.vo.ChatVO;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	@Autowired
	private RoomService roomService;

	/**
	 * 채팅기능 (대화내용 리스트)
	 * @param seq 채팅방 번호
	 * @return
	 */
	@RequestMapping(value="chat/chatList.ajax", method=RequestMethod.POST)
	public ModelAndView chatList(@RequestParam ("seq") int seq, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		ModelAndView mv = new ModelAndView("jsonView");
		
		if(roomService.chatInfo(seq).isEmpty()){
			mv.addObject("pageBack", true);
		} else {
			List<ChatVO> chatList = chatService.chatList(seq);
			
			mv.addObject("pageBack", false);
			mv.addObject("chatList", chatList);
		}

		return mv;
	}

	/**
	 * 채팅기능(대화내용 입력)
	 * @param seq		채팅방 번호
	 * @param name		닉네임
	 * @param content	대화내용
	 * @return
	 */
	@RequestMapping(value="chat/chatInsert.ajax", method=RequestMethod.POST)
	public ModelAndView chatInsert(@RequestParam ("seq") int seq, @RequestParam ("id") String id, @RequestParam ("name") String name, 
			@RequestParam ("content") String content, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		ModelAndView mv = new ModelAndView("jsonView");
		
		if(roomService.chatInfo(seq).isEmpty()){
			mv.addObject("pageBack", true);
		} else {
			chatService.chatInsert(seq, name, content);
			List<ChatVO> chatList = chatService.chatList(seq);
			
			mv.addObject("pageBack", false);
			mv.addObject("chatList", chatList);
		}

		return mv;
	}

	/**
	 * 채팅기능만 하는 데모버전
	 * @return
	 */
	@RequestMapping("chat/chatEntryDemo.do")
	public ModelAndView chatEntryDemo() {
		ModelAndView mv = new ModelAndView("/chat/chatEntryDemo");
		mv.addObject("chatList", chatService.chatList(1));

		return mv;
	}

}