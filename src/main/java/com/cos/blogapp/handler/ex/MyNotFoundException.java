package com.cos.blogapp.handler.ex;

/**
 * 
 * @author NOITATIDME 2022.01.03
 * 1. id를 못찾았을 때 사용
 * 
 */

public class MyNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MyNotFoundException(String msg) {
		super(msg);
	}
}