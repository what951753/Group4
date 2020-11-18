<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>節目內容</title>
<style>
td {
	width: 100px;
}

.halfnum {
	width: 30px;
}

.adultnum {
	width: 30px;
}

.title {
	width: 200px;
}

.total1 {
	width: 120px;
}

.total2 {
	width: 120px;
}

.totalprice {
	width: 120px;
}

.price2 {
	width: 200px;
}
</style>
</head>

<body>
<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
<div class="container">
	<form name="order"
		action="<c:url value='/_04_ShopCart/ShopCartServlet'/>" method="post">

		<!-- 用param.取，相當於request.getParameter-->
		<c:set var="title" value="${param.title}" scope="session" />
		<c:set var="actid" value="${param.actid}" />
		<c:set var="description" value="${param.description}" />
		<H1>節目詳細</H1>
		節目名稱:
		<P>${title}</P>
		節目簡介:
		<P>${description}</P><br><br>
		
		
</body>

</html>