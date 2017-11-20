package com.chat.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chat.serivce.UserService;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {

	@Autowired
	private UserService userService;
	
	/**
	 * 회원가입 신청 화면
	 * @return
	 */
	@RequestMapping("join/joinForm.do")
	public ModelAndView joinForm() {
		ModelAndView mv = new ModelAndView("/join/joinForm");
		return mv;
	}

	/**
	 * 회원가입 신청
	 * @param id		아이디
	 * @param name		닉네임
	 * @param mail		이메일
	 * @param pwd		패스워드
	 * @return
	 */
	@RequestMapping(value="join/userInsert.ajax", method=RequestMethod.POST)
	public ModelAndView userInsert(@RequestParam ("id") String id, @RequestParam ("name") String name, @RequestParam ("mail") String mail, 
			@RequestParam ("pwd") String pwd, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		userService.userInsert(id, name, mail, pwd);
		ModelAndView mv = new ModelAndView("jsonView");

		return mv;
	}
	
	/**
	 * 회원가입 완료 화면
	 * @return
	 */
	@RequestMapping("join/joinComplete.do")
	public ModelAndView joinComplete() {
		ModelAndView mv = new ModelAndView("/join/joinComplete");
		return mv;
	}
	
	/**
	 * 중복체크 화면
	 * @param type		체크타입
	 * @return
	 */
	@RequestMapping("join/duplicationCheck.do")
	public ModelAndView duplicationCheck(@RequestParam ("type") String type) {
		ModelAndView mv = new ModelAndView("/join/duplicationCheck");
		mv.addObject("type", type);

		return mv;
	}
	
	/**
	 * ID 중복체크
	 * @param user_id	아이디
	 * @return
	 */
	@RequestMapping(value="join/idCount.ajax", method=RequestMethod.POST)
	public ModelAndView idCheck(@RequestParam ("user_id") String user_id, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("count", userService.idCheck(user_id));
		
		return mv;
	}
	
	/**
	 * 닉네임 중복체크
	 * @param user_name	닉네임
	 * @return
	 */
	@RequestMapping(value="join/nameCount.ajax", method=RequestMethod.POST)
	public ModelAndView nameCheck(@RequestParam ("user_name") String user_name, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("count", userService.nameCheck(user_name));
		
		return mv;
	}
	
	/**
	 * 이메일 중복체크
	 * @param user_name	닉네임
	 * @return
	 */
	@RequestMapping(value="join/mailCount.ajax", method=RequestMethod.POST)
	public ModelAndView mailCheck(@RequestParam ("user_mail") String user_mail, @RequestParam Map<String, Object> paramMap, ModelMap model) {

		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("count", userService.mailCheck(user_mail));
		
		return mv;
	}

}