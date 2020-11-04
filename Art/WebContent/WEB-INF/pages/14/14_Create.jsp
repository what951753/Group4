<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="tw.group4._14_shopAP.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
		<button type="button" class="btn btn-info btn-sm" value="button"
			onclick="location.href='<c:url value='/DemoServlet'/>'">回上一頁</button>
			
<h4><div>新增商品<span style="color: crimson;font-size:smaller">(*字號欄位不可空白)</span></div></h4>
 	<form ACTION="createProduct.ctrl">
 	<input type="hidden" name="function" value="create"/>
 	
 	<div>
<!--  	<p>商品編號<span style="color: crimson;font-size:larger">*</span>： -->
<!--  	<input type="text" name="productid" required="required" value="200"></p> -->
 	<p>品名<span style="color: crimson;font-size:larger">*</span>：
 	<input type="text" name="APTITLE" required="required" value="某東西"></p></div>
 	<div>
 	<p>價格<span style="color: crimson;font-size:larger">*</span>：
 	<input type="text" name="APPRICE" required="required" value="999"></p>
 	<p>數量<span style="color: crimson;font-size:larger">*</span>：
 	<input type="number" name="APNUM" required="required" min="1" value="50"></p>
 	</div>
 	
    <div><input type="submit" name="check2" value="完成新增"></div>
    </form>


</body>
</html>