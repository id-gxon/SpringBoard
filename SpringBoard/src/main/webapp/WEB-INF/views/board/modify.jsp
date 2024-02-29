<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="content">
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">게시판 글 수정</h3>
		</div>

		<form role="form" method="post">
			<input type="hidden" name="bno" value="${boardVO.bno }">
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">제목</label>
					<input type="text" class="form-control" id="exampleInputEmail1" name="title" value="${boardVO.title }">
				</div>
				<div class="form-group">
					<label>이름</label>
					<input type="text" class="form-control" name="writer" value="${boardVO.writer }">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="3" name="content">${boardVO.content }</textarea>
				</div>
			</div>

			<div class="box-footer">
				<button type="submit" class="btn btn-danger">수정하기</button>
			</div>
		</form>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>