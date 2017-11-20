package com.chat.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chat.serivce.ChatService;
import com.chat.serivce.RoomService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ChatService chatService;
	
	/**
	 * 채팅방 리스트
	 * @param pageNum 페이지 번호
	 * @return
	 */
	@RequestMapping("room/roomList.do")
	public ModelAndView resultSelect(@RequestParam ("pageNum") int pageNum, HttpServletRequest request, HttpServletResponse response) {
		
		int totalCount = roomService.listTotalCount();	//전체 게시물 수
		final int listSize   = 5;						//페이지에 보여줄 게시물 수
		int totalPageNum  = totalCount / listSize;			//총 페이지 수
		if(totalCount % listSize != 0) {
			totalPageNum += 1;
		}
		int currentPage = pageNum;	//현재 페이지 수
		int skipCnt = (pageNum-1)*listSize;
		
		boolean preBtn = false;
		boolean nextBtn = true;

		final int pageSize = 5;
		int startPageNum = ((pageNum-1)/pageSize)*pageSize+1;
		if(startPageNum != 1) {
			preBtn = true;
		}
		int endPageNum = ((pageNum-1)/pageSize)*pageSize+pageSize;
		if(totalPageNum < endPageNum) {
			endPageNum = totalPageNum;
			nextBtn = false;
		}

		ModelAndView mv = new ModelAndView("/room/roomList");
		mv.addObject("roomList", roomService.roomList(skipCnt, listSize));
		mv.addObject("startPageNum", startPageNum);
		mv.addObject("endPageNum", endPageNum);
		mv.addObject("preBtn", preBtn);
		mv.addObject("nextBtn", nextBtn);
		mv.addObject("currentPage", currentPage);

		return mv;
	}
	
	/**
	 * 채팅창 개설 팝업 로드
	 * @return
	 */
	@RequestMapping("room/roomAddPop.do")
	public ModelAndView roomAddPop() {
		ModelAndView mv = new ModelAndView("/room/roomAddPop");
		return mv;
	}
	
	/**
	 * 채팅창 개설
	 * @param room_title		방제목
	 * @param master_id		방장 아이디
	 * @param master_name	방장 닉네임
	 * @return
	 */
	@RequestMapping(value="room/roomAdd.ajax", method=RequestMethod.POST)
	public ModelAndView roomInsert(@RequestParam ("room_title") String room_title, @RequestParam ("master_id") String master_id, 
			@RequestParam ("master_name") String master_name, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		roomService.roomAdd(room_title, master_id, master_name);

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("roomInfo", roomService.lastChatInfo());
	
		return mv;
	}
	
	/**
	 * 채팅방 닉네임 세팅 팝업 로드
	 * @param seq 채팅방 번호
	 * @return
	 */
	@RequestMapping("room/roomEntryPop.do")
	public ModelAndView roomEntryPop(@RequestParam ("seq") int seq) {
		ModelAndView mv = new ModelAndView("/room/roomEntryPop");
		mv.addObject("seq", seq);

		return mv;
	}

	/**
	 * 채팅방 입장
	 * @param seq 채팅방 번호
	 * @return
	 */
	@RequestMapping(value="chat/chatEntry.do", method=RequestMethod.GET)
	public ModelAndView chatEntry(@RequestParam ("seq") int seq, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("/chat/chatEntry");
		mv.addObject("chatInfo", roomService.chatInfo(seq));
		mv.addObject("chatList", chatService.chatList(seq));

		return mv;
	}
	
	/**
	 * 채팅방 방장 체크
	 * @param seq	채팅방 번호
	 * @param id	유저 아이디
	 * @return
	 */
	@RequestMapping(value="room/masterCheck.ajax", method=RequestMethod.POST)
	public ModelAndView masterCheck(@RequestParam ("seq") int seq, @RequestParam ("id") String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("jsonView");

		if(roomService.masterCheck(seq, id).isEmpty()){
			mv.addObject("master", false);
		} else {
			mv.addObject("master", true);
		}

		return mv;
	}
	
	/**
	 * 채팅방 삭제
	 * @param seq	채팅방 번호
	 * @return
	 */
	@RequestMapping(value="room/removeRoom.ajax", method=RequestMethod.POST)
	public ModelAndView removeRoom(@RequestParam ("seq") int seq, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("jsonView");
		roomService.roomRemove(seq);

		return mv;
	}

}