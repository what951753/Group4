<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊成為會員</title>
</head>
<style>
tr {
	text-align: left;
}
.errMsg{
	color: red;
	padding: 10px;
}
fieldset {
	width: 40%;
	margin: 0 auto;
}
</style>
<body>
	<fieldset>
		<legend>請填寫下列資料</legend>
		<c:url var="url" value='/35/registerCheck.ctrl' />
		<form:form action="${url}" method="POST" enctype="multipart/form-data"
			modelAttribute="member">
			<table class="registerForm">
				<tr>
					<td class="errMsg">${errMsg}</td>
				</tr>
				<tr>
					<td><form:label path="name">會員名稱:</form:label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="password">密碼:</form:label></td>
					<td><form:input type="password" path="password" /></td>
				</tr>
				<tr>
					<td><label>再次確認密碼:</label></td>
					<td><input type="password" name="passwordAuth" /></td>
				</tr>
				<tr>
					<td><form:label path="address">地址(選填):</form:label></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td><form:label path="email">E-mail:</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="tel">電話:</form:label></td>
					<td><form:input path="tel" /></td>
				</tr>
				<tr>
					<td>
						<p>
							上傳個人大頭照(選填):<input style="padding-top: 10px;" type="file"
								name="memberPic" />
						</p>
					</td>
				</tr>
				<tr>
					<td style="padding-top: 20px;"><form:button value="Send"
							id='sendData'>送出註冊資料</form:button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>