package com.cos.blogapp.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cos.blogapp.web.dto.JoinReqDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data
@Entity 
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; //PK (자동증가 번호)
	@Column(nullable = false, length = 20, unique = true) // null X, 길이 20, 중복 X
	private String username; // 아이디
	@Column(nullable = false, length = 70) // null X, 길이 20
	private String password; // 비밀번호
	@Column(nullable = false, length = 50) // null X, 길이 50
	private String email; // 이메일
}
