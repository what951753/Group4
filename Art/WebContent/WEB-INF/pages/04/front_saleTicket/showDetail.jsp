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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</head>

<body>
<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
<div class="container">

		<form name="order" action="<c:url value='/04/seatSearch.ctrl'/>" method="get">

		<!-- 用param.取，相當於request.getParameter-->
		<c:set var="actid" value="${param.actid}" scope="session"/>
<%-- 		<c:set var="title" value="${param.title}" scope="session" /> --%>
<%-- 		<c:set var="description" value="${param.description}" /> --%>
		<H1>節目詳細</H1>
		<H2>節目名稱:</H2>		
		<H2>${param.title}</H2>
		<H2>地點:</H2>		
		<H2>${param.site}</H2>
<!-- 		<H2>主辦單位:</H2>		 -->
<%-- 		<H2>${}</H2> --%>
<!-- 		<H2>演出單位:</H2>		 -->
<%-- 		<H2>${}</H2> --%>
		<H2>活動日期:</H2>		
		<H2>${param.startdate} ~ ${param.enddate}</H2>
		
		
		節目簡介:
		<P>${param.description}</P><br><br>
		
		<br><br><input type="submit" class="btn btn-outline-info" value="購買">
		</form>
		
		
</body>

</html>