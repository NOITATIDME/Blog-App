<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	response.sendRedirect("/board?page=0");
	//request.getRequestDispatcher("/board?page=0").forward(request, response);
%>