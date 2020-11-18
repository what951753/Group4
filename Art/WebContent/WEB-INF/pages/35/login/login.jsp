<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<style>
tr {
	text-align: left;
}

.authError, .errors {
	color: red;
	padding: 10px;
}

fieldset {
	text-align: center;
	width: 400px;
	margin: 0 auto;
}
</style>
<body>
	<fieldset>
		<legend>請輸入帳號密碼</legend>
		<c:url var="url" value='/35/loginCheck.ctrl' />
		<form:form action="${url}" method="POST" modelAttribute="member">
			<table class="loginForm">
				<tr>
					<td colspan=2 class="authError">${authError}</td>
				</tr>
				<tr>
					<td><form:label path="name">會員名稱:</form:label></td>
					<td><form:input path="name" value="${name}" /></td>
					<td class="errors">${errors.user}</td>
				</tr>
				<tr>
					<td><form:label path="password">密碼:</form:label></td>
					<td><form:input type="password" path="password" value="${password}" /></td>
					<td class="errors">${errors.pwd}</td>
				</tr>
				<tr>
					<td><label>記住密碼:</label></td>
					<td><input type="checkbox" name="rememberMe"
					    <c:if test='${requestScope.rememberMe==true}'>
					    checked='checked'
              			</c:if>  
						value="yes" /></td>
				</tr>
				<tr>
					<td style="padding-top: 20px;"><form:button value="Send"
							id='sendData'>登入</form:button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>