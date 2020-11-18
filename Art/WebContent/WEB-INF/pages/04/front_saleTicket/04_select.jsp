<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢結果</title>
<style>
.page li {
	display: inline;
}

.date {
	width: 200px;
}

.title {
	width: 700px;
}

.site {
	width: 300px;
}

.buy {
	width: 50px;
}
</style>
</head>
<body>
	<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
	<div class="container">
		<!-- 頂部按鈕	 -->
		<form method=GET action="<c:url value='/04/SearchTo.ctrl?'/>">
			<br>
			<!-- 隱藏屬性 用來傳遞頁數 -->
			<input type="hidden" name="page" value=""> <input
				type="hidden" name="site" value=""> <input type="hidden"
				name="startdate" value=""> <input type="hidden"
				name="enddate" value=""> <input type="hidden"
				name="searchString" value="">

			<button name="category" type="submit" value="1" class="btn btn-info">音樂</button>
			<button name="category" type="submit" value="2" class="btn btn-info">戲劇</button>
			<button name="category" type="submit" value="3" class="btn btn-info">舞蹈</button>
			<button name="category" type="submit" value="4" class="btn btn-info">親子</button>
			<button name="category" type="submit" value="5" class="btn btn-info">獨立音樂</button>
			<button name="category" type="submit" value="6" class="btn btn-info">展覽</button>
			<button name="category" type="submit" value="7" class="btn btn-info">講座</button>
			<button name="category" type="submit" value="8" class="btn btn-info">電影</button>
			<button name="category" type="submit" value="11" class="btn btn-info">綜藝</button>
			<button name="category" type="submit" value="13" class="btn btn-info">競賽</button>
			<button name="category" type="submit" value="14" class="btn btn-info">徵選</button>
			<button name="category" type="submit" value="15" class="btn btn-info">其他</button>
			<button name="category" type="submit" value="16" class="btn btn-info">科教</button>
			<button name="category" type="submit" value="17" class="btn btn-info">演唱會</button>
			<button name="category" type="submit" value="19" class="btn btn-info">研習課程</button>
		</form>

		搜尋結果
		<c:set var="totalnum" value="${requestScope.totalnum}" />
		<c:set var="PerPage" value="${requestScope.PerPage}" />
		<c:set var="totalPages" value="${requestScope.totalPages}" />
		<c:set var="beginIndex" value="${requestScope.beginIndex}" />
		<c:set var="endIndex" value="${requestScope.endIndex}" />
		<c:set var="page" value="${requestScope.page}" />
		<c:set var="currentPage"
			value="${requestScope.key_list.subList(beginIndex,endIndex)}" />

		<p>總筆數:${totalnum} 每頁筆數:${PerPage} 總頁數:${totalPages} 目前位於第${page}頁</p>

		<table class="table table-bordered">
			<tr>
				<th class="date">日期</th>
				<th class="title">節目名稱</th>
				<th class="site">場地</th>
				<!-- 			<th class="date">日期</th> -->
				<th class="buy">購買</th>
			</tr>

			<%--使用JSTL 執行for loop ${show.no}取map內value --%>
			<c:forEach items="${currentPage}" var="show" varStatus="idx">
				<tr>
<!-- 					傳送訂單資訊 -->
					<form method=GET action="<c:url value='/04/showDetail'/>">
					<td>${show.startdate}~ ${show.enddate}</td>
					<td>${show.title}</td>
					<td>${show.site}</td>
					<td><input type=SUBMIT value="購買" class="btn btn-outline-info"></td>
<!-- 					這些隱藏欄位都會送到後端 -->
					<Input type='hidden' name='title' value='${show.title}'>
					<Input type='hidden' name='actid' value='${show.no}'>
					<Input type='hidden' name='site' value='${show.site}'>
					<Input type='hidden' name='startdate' value='${show.startdate}'>
					<Input type='hidden' name='enddate' value='${show.enddate}'>
					<Input type='hidden' name='description' value='${show.description}'>

					</form>
					</tr>
					
					<%-- <tr>
					傳送訂單資訊
					<form:form method="GET" action="/04/Booking1"  modelAttribute="showitem">
					<td><form:label path="date">${show.startdate}~ ${show.enddate}</form:label></td>
										<td>${show.date}</td>
					<td><form:label path="ACT_TITLE">${show.title}</form:label></td>
					<td>${show.title}</td>
					<td><form:label path="ACT_LOCATION_NAME">${show.title}</form:label></td>
					<td>${show.site}</td>
					<td><input type=SUBMIT value="購買" class="btn btn-outline-info"></td>
					這些隱藏欄位都會送到後端
					<Input type='hidden' name='title' value='${show.title}'>
					<Input type='hidden' name='actid' value='${show.no}'>
					<Input type='hidden' name='description' value='${show.description}'>

					</form:form>
					
					</tr> --%>
					
					

			</c:forEach>


		</table>
		<br>

		<!-- 頁數區 -->

		<div class="btn-toolbar" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group mr-2" role="group" aria-label="First group">
				<ul class="page">
					<button type="button" class="btn btn-secondary"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=1&searchString=${searchString}&category=${category}&site=${site}&startdate=${startdate}&enddate=${enddate}"/>'">首頁</button>

					<button type="button" class="btn btn-secondary"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&site=${site}&startdate=${startdate}&enddate=${enddate}"/>'">&laquo;</button>

					<c:forEach begin="1" end="${totalPages}" varStatus="loop">
						<c:set var="active" value="${loop.index==page?'active':''}" />
						<button type="button" class="btn btn-secondary"
							onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${loop.index}&searchString=${searchString}&category=${category}&site=${site}&startdate=${startdate}&enddate=${enddate}"/>'">${loop.index}</button>
					</c:forEach>
					<button type="button" class="btn btn-secondary"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${page-1>1?page-1:1}&searchString=${searchString}&category=${category}&site=${site}&startdate=${startdate}&enddate=${enddate}"/>'">&raquo;</button>
					<button type="button" class="btn btn-secondary"
						onclick="location.href='<c:url value="/04/SearchTo.ctrl?page=${totalPages}&searchString=${searchString}&category=${category}&site=${site}&startdate=${startdate}&enddate=${enddate}"/>'">最後頁</button>
			</div>




		</div>
	</div>


</body>
</html>