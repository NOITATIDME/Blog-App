package com.cos.blogapp.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.handler.ex.MyAsyncNotFoundException;
import com.cos.blogapp.util.Script;
import com.cos.blogapp.web.dto.CMRespDto;

//@ControllerAdvice 이친구는 1. 익셉션 핸들링, 2. @Controller 의 역할까지 한다.
@ControllerAdvice
public class GlobalExceptionHandler {
	// RuntimeException 으로 처리 -> 모든 예외를 처리할 수 있는데 세분화 할 수 없다.
	@ExceptionHandler(value = RuntimeException.class)
	public @ResponseBody String error1(RuntimeException e) {
		System.out.println("오류가 터졌습니다. : "+e.getMessage()); // No value present : db가 응답해줄 데이터가 없다.
		return Script.href("/", e.getMessage());
	}
	
	@ExceptionHandler(value = MyAsyncNotFoundException.class)
	public @ResponseBody CMRespDto<String> error2(MyAsyncNotFoundException e) {
		System.out.println("오류 터졌어 : "+e.getMessage());
		return new CMRespDto<String>(-1, e.getMessage(), null);
	}
	
}