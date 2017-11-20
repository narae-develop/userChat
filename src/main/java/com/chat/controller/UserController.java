package com.chat.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chat.serivce.UserService;
import com.chat.vo.UserVO;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 내정보 화면
	 * @return
	 */
	@RequestMapping("info/myInfo.do")
	public ModelAndView myInfo() {
		ModelAndView mv = new ModelAndView("/info/myInfo");

		return mv;
	}
	
	/**
	 * 내정보 수정
	 * @return
	 */
	@RequestMapping("info/userUpdate.ajax")
	public ModelAndView userUpdate(@RequestParam ("id") String id, @RequestParam ("name") String name, @RequestParam ("mail") String mail,
			HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramMap, ModelMap model) {
		HttpSession session = request.getSession();
		userService.userUpdate(id, name, mail);
		List<UserVO> userInfo = userService.userInfo(id);
		session.setAttribute("loginInfo", userInfo);

		ModelAndView mv = new ModelAndView("jsonView");
		
		return mv;
	}
	
	/**
	 * 비밀번호 변경 팝업 로드
	 * @return
	 */
	@RequestMapping("user/pwdChange.do")
	public ModelAndView pwdChange() {
		ModelAndView mv = new ModelAndView("/user/pwdChange");
		return mv;
	}
	
	/**
	 * 비밀번호 변경 결과
	 * @return
	 */
	@RequestMapping("user/pwdChangeResult.ajax")
	public ModelAndView pwdChangeResult(@RequestParam ("user_id") String user_id, @RequestParam ("old_pwd") String old_pwd, @RequestParam ("new_pwd") String new_pwd,
			@RequestParam Map<String, Object> paramMap, ModelMap model) {
		ModelAndView mv = new ModelAndView("jsonView");
		if(userService.pwdSearchResult(user_id).equals(old_pwd)) {
			mv.addObject("missPwd", false);
			userService.pwdChange(user_id, new_pwd);
		} else {
			mv.addObject("missPwd", true);
		}

		return mv;
	}

}