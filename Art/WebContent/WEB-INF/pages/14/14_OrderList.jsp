<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>訂單列表</title>
<style type="text/css">
#borderA {
   border:1px solid black;
}

</style>
</head>
<body style="background: #ffffff;">


	
    <p/>
	<table style="margin-left:auto; margin-right:auto; width:810; background:#ffffff; border:2px solid black; border-style: outset; ">

		<tr id='borderA' height='50' >
			<th id='borderA'  colspan="4" align="center">訂購紀錄</th>
		</tr>
		<tr id='borderA' height='36' >
			<th id='borderA'>訂單編號</th>
			<th id='borderA'>訂購日期</th>
			<th id='borderA'>送貨地址</th>
			
		</tr>
		<c:forEach var="anOrderBean" varStatus="stat" items="${customerOrder}">
			<TR id='borderA' height='30'>
			<TD id='borderA' width="86" align="center">
			    <a  href='<c:url value='/14/OrderDetial.ctrl?memberId=測試用&orderNo=${anOrderBean.orderNoAP}' />'>
				    ${anOrderBean.orderNoAP}
			    </a>
			</TD>
			<TD id='borderA' width="100" align="center">${anOrderBean.date}</TD>
			
			<TD id='borderA' width="400" align="left">&nbsp;${anOrderBean.addAP}</TD>
							
			
		</TR>
		</c:forEach>
		<tr height='36' id='borderA'>
			<td id='borderA' align="center" colspan="4"><a href="<c:url value='/14/shopListController.ctrl' />">回首頁</a></td>
		</tr>
	</TABLE>
	</center>
</body>
</html>