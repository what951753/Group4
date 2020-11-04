<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>修改 ${ap.productTitle}</h2>

<h4><div>修改商品<span style="color: crimson;font-size:smaller">(*字號欄位不可空白)</span></div></h4>
 	<form ACTION="updateDoneProduct.ctrl" method="get">
 	<input type="hidden" name="function" value="updateDone"/>
 	<input type="hidden" name="productid" value="${ap.productId}"/>
 	<div>
 	<p>品名<span style="color: crimson;font-size:larger">*</span>：
 	<input type="text" name="APTITLE" required="required" value="${ap.productTitle}"></p></div>
 	<div>
 	<p>價格<span style="color: crimson;font-size:larger">*</span>：
 	<input type="text" name="APPRICE" required="required" value="${ap.productPrice}"></p>
 	<p>數量<span style="color: crimson;font-size:larger">*</span>：
 	<input type="number" name="APNUM" required="required" value="${ap.productNum}" ></p>
 	</div>
 	
    <div><input type="submit" name="check" value="完成修改"></div>
    </form>

</body>
</html>