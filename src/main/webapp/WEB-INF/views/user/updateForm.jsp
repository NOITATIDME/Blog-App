<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form>
	  <div class="form-group">
	    <input type="text"  value="${sessionScope.principal.username }" class="form-control" placeholder="Enter username"  required="required" maxlength="20" readonly="readonly">
	  </div>
	  <div class="form-group">
	    <input type="password" value="${sessionScope.principal.password }" class="form-control" placeholder="Enter password"  required="required" maxlength="20">
	  </div>
	  <div class="form-group">
	    <input type="email" value="${sessionScope.principal.email }"  class="form-control placeholder="Enter email"  required="required">
	  </div>
	  <button type="submit" class="btn btn-primary">회원수정</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %> 
