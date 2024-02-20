<%@ include file="./include/header.jsp"%>

<h1>Hello world!</h1>

<P>The time on the server is ${serverTime}.</P>
<button type="button" class="btn btn-block btn-success bg-orange">Success</button>

<%@ include file="./include/footer.jsp"%>

<!-- 
	1. 지시어 include: 컴파일 전에 소스코드 포함
	< %@ include file="" %>
	
	2.액션 태그 include: 컴파일 후에 소스코드(페이지) 포함
	<jsp:include page=""></jsp:include>
-->