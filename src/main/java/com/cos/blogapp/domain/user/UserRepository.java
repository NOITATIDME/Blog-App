package com.cos.blogapp.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blogapp.util.MyAlgorithm;

//DAO
//save(user) 인서트, 업데이트
//findById(1) 한건셀렉트
//findAll() 전체셀렉트
//deleteById(1) 한건 삭제
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "insert into User (username, password, email) values(:username, :password, :email)", nativeQuery = true)
	void join(String username, String password, String email);

	@Query(value = "select * from User where username = :username and password = :password", nativeQuery = true)
	User mLogin(String username, String password);
	
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}

