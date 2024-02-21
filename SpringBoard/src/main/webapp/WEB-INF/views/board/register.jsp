<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<div class="box box-primary">
	<div class="box-header with-border">
		<h3 class="box-title">게시판 글 쓰기</h3>
	</div>

	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label>
				<input type="text" class="form-control" id="exampleInputEmail1" name="title" placeholder="제목을 입력하세요.">
			</div>
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" name="writer" placeholder="이름을 입력하세요.">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" name="content" placeholder="내용을 입력하세요."></textarea>
			</div>
		</div>


		<div class="box-footer">
			<button type="submit" class="btn btn-primary">글 쓰기</button>
		</div>
	</form>
</div>

<%@ include file="../include/footer.jsp"%>