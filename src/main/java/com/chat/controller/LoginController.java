package com.chat.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

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

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	/**
	 * 로그인 화면
	 * @return
	 */
	@RequestMapping("user/userLogin.do")
	public ModelAndView userLogin() {
		ModelAndView mv = new ModelAndView("/user/userLogin");

		return mv;
	}
	
	/**
	 * 로그인 체크
	 * @return
	 */
	@RequestMapping("user/sessionLogin.ajax")
	public ModelAndView sessionLogin(@RequestParam ("id") String id, @RequestParam ("pwd") String pwd, 
			HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramMap, ModelMap model) {
		
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<UserVO> userInfo = userService.userCheck(id, pwd);

		if(userService.idCheck(id) == 1){ //아이디가 존재하는 경우
			mv.addObject("idCheck", true);
			if(userInfo.isEmpty()) { //아이디는 존재하나 비밀번호가 일치하지 않을 경우
				mv.addObject("userCheck", false);
				session.invalidate();
			} else { //회원 로그인 성공
				mv.addObject("userCheck", true);
				session.setAttribute("loginInfo", userInfo);
			}
		} else { //아이디가 존재하지 않을 경우
			mv.addObject("idCheck", false);
			session.invalidate();
		}

		return mv;
	}
	
	/**
	 * 로그아웃
	 * @return
	 */
	@RequestMapping("user/sessionLogout.do")
	public void sessionLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {//loginInfo 세션값이 있을 경우
			if(request.getSession().getAttribute("loginInfo") != null){
				session.invalidate(); // 세션 초기화
				//로그인 페이지로 redirect
				response.sendRedirect("../");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 아이디 찾기 팝업 로드
	 * @return
	 */
	@RequestMapping("user/idSearch.do")
	public ModelAndView idSearch() {
		ModelAndView mv = new ModelAndView("/user/idSearch");
		return mv;
	}
	
	/**
	 * 아이디 찾기 결과
	 * @return
	 */
	@RequestMapping("user/idSearchResult.ajax")
	public ModelAndView idSearchResult(@RequestParam ("user_mail") String user_mail, @RequestParam Map<String, Object> paramMap, ModelMap model) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("userId", userService.idSearchResult(user_mail));
		
		return mv;
	}
	
	/**
	 * 비밀번호 찾기 팝업 로드
	 * @return
	 */
	@RequestMapping("user/pwdSearch.do")
	public ModelAndView pwdSearch() {
		ModelAndView mv = new ModelAndView("/user/pwdSearch");
		return mv;
	}
	
	/**
	 * 비밀번호 찾기 결과
	 * @return
	 */
	@RequestMapping("user/pwdSearchResult.ajax")
	public ModelAndView pwdSearchResult(@RequestParam ("user_id") String user_id, @RequestParam Map<String, Object> paramMap, ModelMap model) {
		ModelAndView mv = new ModelAndView("jsonView");
		if(userService.pwdSearchResult(user_id) != null) {
			Random rand =new Random();
			StringBuffer randPwd =new StringBuffer();
			for(int i=0;i<8;i++){
			    if(rand.nextBoolean()){
			    	randPwd.append((char)((int)(rand.nextInt(26))+97));
			    }else{
			    	randPwd.append((rand.nextInt(10))); 
			    }
			}
			userService.pwdChange(user_id, randPwd.toString());
			mv.addObject("userPwd", randPwd);
		}

		return mv;
	}

}