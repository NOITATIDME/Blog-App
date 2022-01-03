package com.cos.blogapp.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blogapp.util.Script;

//@ControllerAdvice 이친구는 1. 익셉션 핸들링, 2. @Controller 의 역할까지 한다.
@ControllerAdvice
public class GlobalExceptionHandler {
	// RuntimeException 으로 처리 -> 모든 예외를 처리할 수 있는데 세분화 할 수 없다.
	@ExceptionHandler(value = RuntimeException.class)
	public @ResponseBody String error1(RuntimeException e) {
		System.out.println("오류가 터졌습니다. : "+e.getMessage()); // No value present : db가 응답해줄 데이터가 없다.
		return Script.href("/", e.getMessage());
	}
}