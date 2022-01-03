package com.cos.blogapp.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.domain.user.User;
import com.cos.blogapp.domain.user.UserRepository;
import com.cos.blogapp.util.MyAlgorithm;
import com.cos.blogapp.util.SHA;
import com.cos.blogapp.util.Script;
import com.cos.blogapp.web.dto.JoinReqDto;
import com.cos.blogapp.web.dto.LoginReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserRepository userRepository;
	private final HttpSession session;

	@GetMapping("/user/{id}")
	public String userInfo(@PathVariable int id) {
		// 기본은 userRepository.findById(id) 디비에서 가져와야함.
		// 편법은 세션값을 가져올수 있음.
		
		return "user/updateForm";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션무효화 (jsessionid에 있는 값 비우기)
		return "redirect:/"; // "board/list"; -> 게시글 목록 화면에 데이터 X
	}
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@PostMapping("/login")
	public @ResponseBody String login(@Valid LoginReqDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return Script.back(errorMap.toString());
		}

		User userEntity =  userRepository.mLogin(
				dto.getUsername(), SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256));
		
		if (userEntity == null) { // username, password 잘못 기입
			return Script.back("아이디 혹은 비밀번호를 잘못 입력하였습니다.");
		} else {
			// 세션 날라가는 조건
			// 1. session.invalidate() : 세션이 들고있는 정보가 날라간다.
			// 2. 브라우저를 닫으면 날라간다.
			session.setAttribute("principal", userEntity);
			return Script.href("/", "로그인 성공");
		}
	}

	
	@PostMapping("/join")
	public @ResponseBody String join(@Valid JoinReqDto dto, BindingResult bindingResult,Model model) { // username=love&password=1234&email=love@nate.com
		
		System.out.println("에러사이즈 : " + bindingResult.getFieldErrors().size() );
		// 1. 유효성 검사 실패 - 자바스크립트 응답(경고창, 뒤로가기)
		// 2. 정상 - 로그인 페이지

		//System.out.println("에러사이즈 : "+bindingResult.getFieldErrors().size());
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField() , error.getDefaultMessage() );
			}
			return Script.back(errorMap.toString());
		}
		
		String encPassword = SHA.encrypt(dto.getPassword(), MyAlgorithm.SHA256);
		
		dto.setPassword(encPassword);
		userRepository.save(dto.toEntity());
		return Script.href("/loginForm"); // 리다이렉션 (300)
	}


}
