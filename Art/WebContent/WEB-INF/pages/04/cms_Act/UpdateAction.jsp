<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p{
/*  自動換行  */
white-space:pre-wrap;
}
</style>
</head>

<body>
<%-- 	<jsp:include page="/fragment/top.jsp" /> --%>
		<br>
		<br>
	<form method=GET action="<c:url value='Update2.ctrl'/>">
<div class="form-group">
		<div class="container">
	<h1>活動修改</h1>
			<p></p>
			<table class="table table-bordered">
<!-- 				<tr> -->
<!-- 					<td>NO</td> -->
<!-- 					<td><input type="text" name="no" ></td> -->
<!-- 				</tr> -->
					<input type="hidden" name="actno" value="${requestScope.actno}">
					<input type="hidden" name="page" value="${requestScope.page}">
					<input type="hidden" name="searchString" value="${requestScope.searchString}">
				<tr>
				
					<td>編號</td>
					<td>${requestScope.actno}</td>
				</tr>
				<tr>			
					<td>標題</td>
					<td><input type="text" name="title" value="${requestScope.title}" class="form-control" ></td>
				</tr>
				<tr>
					<td>分類</td>
					<td><select id="category" class="form-control"  name="category">
							<option value="${requestScope.category}" selected>選擇分類</option>
							<option value="1">音樂</option>
							<option value="2">戲劇</option>
							<option value="3">舞蹈</option>
							<option value="4">親子</option>
							<option value="5">獨立音樂</option>
							<option value="6">展覽</option>
							<option value="7">講座</option>
							<option value="8">電影</option>
							<option value="11">綜藝</option>
							<option value="13">競賽</option>
							<option value="14">徵選</option>
							<option value="15">其他</option>
							<option value="16">科教</option>
							<option value="17">演唱會</option>
							<option value="19">研習課程</option>
					</select></td>
				</tr>
				<tr>
					<td>縣市名</td>
					<td><select id="site" class="form-control"  name="location" value="${requestScope.location}">
							<option value="${requestScope.location}" selected>選擇縣市</option>
							<option value="">==北部地區==</option>
							<option value="基隆">基隆</option>
							<option value="台北">台北</option>
							<option value="新北">新北</option>
							<option value="桃園">桃園</option>
							<option value="新竹">新竹</option>
							<option value="">==中部地區==</option>
							<option value="苗栗">苗栗</option>
							<option value="台中">台中</option>
							<option value="彰化">彰化</option>
							<option value="南投">南投</option>
							<option value="雲林">雲林</option>
							<option value="">==南部地區==</option>
							<option value="嘉義">嘉義</option>
							<option value="南投">南投</option>
							<option value="高雄">高雄</option>
							<option value="屏東">屏東</option>
							<option value="">==東部地區==</option>
							<option value="宜蘭">宜蘭</option>
							<option value="花蓮">花蓮</option>
							<option value="台東">台東</option>

					</select></td>
				</tr>
				<tr>
					<td>地點</td>
					<td><input type="text" name="locationName" value="${requestScope.locationName}" class="form-control" ></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td>活動開始日</td> -->
<!-- 					<td><input type="date" name="time"></td> -->
<!-- 				</tr> -->
				<tr>
					<td>主辦單位</td>
					<td><input type="text" name="mainunit" value="${requestScope.mainunit}" class="form-control" ></td>
				</tr>
				<tr>
					<td>演出單位</td>
					<td><input type="text" name="showunit" value="${requestScope.showunit}" class="form-control" ></td>
				</tr>
				<tr>
					<td>活動開始日</td>
					<td><input type="date" name="startdate" value="${requestScope.startdate}" id="startdate" class="form-control" ></td>
				</tr>
				<tr>
					<td>活動結束日</td>
					<td><input type="date" name="enddate" value="${requestScope.enddate}" id="enddate" class="form-control" ></td>
				</tr>
				<tr>
					<td>活動描述</td>
					<td><textarea rows="8" cols="" name="description"  class="form-control" >${requestScope.description}</textarea>
					</td>
				</tr>
				
			</table>

			<input type="submit" value="送出修改" name=""
				class="btn btn-outline-info" id="" onclick="return update()">
	</div>
	</div>
	</form>
	
	
		<script>
		function insert() {
			var msg = "確認是否更新?";
			if (confirm(msg) == true) {
				return true;
			} else {
				return false;
			}
		}

		document.getElementById("startdate").onchange = function () {
		    var input = document.getElementById("enddate");
		    input.setAttribute("min", this.value);
		}
	</script>
</body>
</html>