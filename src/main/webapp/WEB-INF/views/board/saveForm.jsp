<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="/api/board"  method="post">
	  <div class="form-group">
	    <input type="text" name="title" class="form-control" placeholder="Enter title"> <!-- 테스트 후 required="required" 넣기 -->
	  </div>
	  <div class="form-group">
	  	<textarea id="summernote" rows="5" name="content"></textarea>
	  </div>
	  <button type="submit" class="btn btn-primary">글쓰기</button>
	  </form>
</div>

 <script>
       $('#summernote').summernote({
            height: 350
       });
 </script>

<%@ include file="../layout/footer.jsp" %>
