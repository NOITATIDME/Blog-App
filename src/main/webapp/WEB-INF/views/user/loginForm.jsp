<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/login"  method="post">
	  <div class="form-group">
	    <input type="text" name="username" class="form-control" placeholder="Enter username" required="required">
	  </div>
	  <div class="form-group">
	    <input type="password" name="password" class="form-control" placeholder="Enter password" required="required">
	  </div>
	  
	  <button type="submit" class="btn btn-primary">로그인</button>
	  <a href="https://kauth.kakao.com/oauth/authorize?client_id=4d34c5d2365704a449a37316df740a7c&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
	  	 <img height="39px" src="/image/kakao_login_button.png">
	  </a>
	  </form>
</div>




<%@ include file="../layout/footer.jsp" %>
