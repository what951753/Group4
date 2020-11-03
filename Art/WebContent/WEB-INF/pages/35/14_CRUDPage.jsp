<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.head {
	text-align: center;
}
</style>
<script type="text/javascript">

function reconfirmOrder(pid,page){
	swal("提示","確認刪除？", "warning",{
	    buttons: {
	      danger: {
	          text: "是",
	          visible: true
	        },
	      "不是": true,
//	      "是": true
	      
	    },
	  })
	  .then((value) => {
	    switch (value) {
	      case "danger":
	    	swal("提示","商品已刪除", "success")
	    	setTimeout(function(){window.location="<c:url value='/14/deleteProduct.ctrl?productid="+pid+"&pageNo="+page+"' />" ; },2000);
	        break;
	      case "不是":
	        swal("提示","商品未刪除", "info");
	        break;
	      default:
	    	  swal("提示","商品未刪除", "info");
	        break;
	    }
	  });
};

</script>

</head>
<body>
	<div class="container">
		<h1 style="margin-top: 50px; text-align: center;">洋行後台</h1>

		<button type="button" class="btn btn-info btn-sm" value="新增商品"
			onclick="location.href='<c:url value='/14/Create.ctrl' />'">新增</button>


		<button type="button" class="btn btn-info btn-sm" value="全部商品"
			onclick="location.href='<c:url value='/CRUD.controller' />'">前往新天地</button>
		

		<div style='text-align: center;'>

			<c:if test='${not empty OrderErrorMessage}'>
				<h3>
					<font color='red'>${OrderErrorMessage}</font>
				</h3>
				<c:remove var="OrderErrorMessage" />
				<c:remove var="SuccessMessage" />
			</c:if>

		</div>
		<div style='text-align: center;'>
			<c:if test='${not empty SuccessMessage}'>
				<h3>
					<font color='#1b9aaa'>${SuccessMessage}</font>
				</h3>
				<c:remove var="SuccessMessage" />
				<c:remove var="OrderErrorMessage" />
			</c:if>
		</div>

		<br>
		<table class="table table-striped" style="height: 100px;">
			<tr class="head">
				<th scope="col">貨號</th>
				<th scope="col">商品名稱</th>
				<th scope="col">售價</th>
				<th scope="col">庫存</th>
				<th scope="col" colspan="3">功能</th>
			</tr>
			<c:forEach var="searchAP" varStatus="stat" items="${pList}">
				<FORM>
					<tbody>
						<tr>

							<td class="align-middle" scope="row" style="text-align: center;">${searchAP.productId}</td>
							<td class="align-middle">${searchAP.productTitle}</td>
							<td class="align-middle" style="text-align: center;">${searchAP.productPrice}</td>
							<td class="align-middle" style="text-align: center;">${searchAP.productNum}</td>
							<td class="align-middle"><button type="button"
									class="btn btn-info btn-sm" value="全部商品"
									onclick="location.href='<c:url value='/14/updateProduct.ctrl?productid=${searchAP.productId}' />'">修改</button></td>
							<td><Input class="btn btn-info btn-sm" type="button"
								name="delete" value="刪除"
								onclick="reconfirmOrder(${searchAP.productId},${pageNo})"></td>
						</tr>
					</tbody>

				</FORM>
			</c:forEach>
		</table>
	</div>

	<div style="margin-left: 500px;">第 ${pageNo} 頁 // 共 ${totalPages}
		頁</div>
	<div class="container">
		<div class="row justify-content-md-center">



			<nav aria-label="Page navigation example" style="margin: auto;">
				<ul class="pagination" style="margin: auto;">
					<li class="page-item" style="margin: auto;"><c:if
							test="${pageNo > 1}">
							<a class="page-link"
								href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo-1}' />"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
						</c:if></li>
					<c:forEach var='page' items='${pages}'>
						<li class="page-item"><a class="page-link"
							href="<c:url value='/14/CRUD.ctrl?pageNo=${page}' />">${page}</a></li>
					</c:forEach>
					<c:if test="${pageNo != totalPages}">
						<li class="page-item"><a class="page-link"
							href="<c:url value='/14/CRUD.ctrl?pageNo=${pageNo+1}' />"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>



</body>
</html>