<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp"%>

<div class="content">
	문제가 발생했습니다. 관리자에게 문의하세요.<br>
	
	${e }
	
	<hr>

	<a href="/board/list">메인 페이지로 돌아가기</a>
</div>

<%@ include file="./include/footer.jsp"%>