<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<div class="content">

	<form action="" role="form" method="get">
		<input type="hidden" name="bno" value="${boardVO.bno }">
	</form>

	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">게시판 글 조회</h3>
		</div>

		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">제목</label>
				<input type="text" class="form-control" id="exampleInputEmail1" name="title" value="${boardVO.title }" readonly="readonly">
			</div>
			<div class="form-group">
				<label>작성자</label>
				<input type="text" class="form-control" name="writer" value="${boardVO.writer }" readonly="readonly">
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" rows="3" name="content" readonly="readonly">${boardVO.content }</textarea>
			</div>
		</div>

		<div class="box-footer">
			<button type="submit" class="btn btn-danger">수정하기</button>
			<button type="submit" class="btn btn-warning">삭제하기</button>
			<button type="submit" class="btn btn-success">목록이동</button>
		</div>
	</div>
</div>

<!-- JQuery -->
<script>
	$(document).ready(function() {
		// bno를 저장하는 폼태그 정보
		// console.log($("form[role='form']"));
		var formObj = $("form[role='form']");

		// onClick '수정하기'
		$(".btn-danger").click(function() {
			alert('수정하기');
			formObj.attr("action", "/board/modify").submit();
		});

		// onClick '삭제하기'
		$(".btn-warning").click(function() {
			alert('삭제하기');
			formObj.attr("action", "/board/remove").attr("method", "post").submit();
		});

		// onClick '목록이동'
		$(".btn-success").click(function() {
			alert('목록이동');
			location.href = '/board/list';
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>