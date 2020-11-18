<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sofa{
	width: 60px;
	border-width: 3px;
	border-style: dashed;
	border-color: #FFFFFF;
}
.sofatick{
	width: 60px;
	border-width: 3px;
	border-style: dashed;
	border-color: #FFFFFF;
}
.sofa1 {
	width: 60px;
}
.sofademo {
	width: 60px;
}
.progressbar{
	width: 200px;
}


</style>
</head>
<body>
	<c:set var="seat" value="${requestScope.seat}" />

<div class="container">
	<table>
	<tr >
		<td class="progressbar">Step 1</td>
		<td class="progressbar">Step 2</td>
		<td class="progressbar">Step 3</td>
		<td class="progressbar">Step 4</td>
	</tr>
	<tr>
	<td  colspan="4" style="width: 50%">
		<div class="progress">
<!-- 		28  -->
		<a class="process-wizard-dot"></a>
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 3%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
		</div>
	</td>

	</tr>
	<tr>
		<td>選擇區域</td>
		<td>選擇張數</td>
		<td>購票確認</td>
		<td>完成訂購</td>
	</tr>
	</table>
	
	
	<h1>座位表</h1>
	<h2>請勾選位置</h2>
	<p>請在灰色空位上點選您要的位置</p>
	<table>
	<tr>
		<td>座位資訊</td>
		<td id="showseat" ></td>
	</tr>
	<tr id="selectseattr" >
		<td>已選擇的排號資訊 </td>
		<td id="selectseat"></td>
		<input type="hidden" value="" id=""/>
	</tr>
	<tr>
		<td>已選擇座位數量</td>
		<td id="selectnum"></td>
	</tr>
	</table>


	<table>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A1}" id="A1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A2}" id="A2"></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A3}" id="A3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A4}" id="A4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A5}" id="A5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A6}" id="A6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A7}" id="A7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A8}" id="A8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A9}" id="A9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.A10}" id="A10" ></td>

		</tr><br><br>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B1}" id="B1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B2}" id="B2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B3}" id="B3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B4}" id="B4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B5}" id="B5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B6}" id="B6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B7}" id="B7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B8}" id="B8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B9}" id="B9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.B10}" id="B10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C1}" id="C1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C2}" id="C2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C3}" id="C3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C4}" id="C4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C5}" id="C5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C6}" id="C6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C7}" id="C7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C8}" id="C8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C9}" id="C9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.C10}" id="C10" ></td>

		</tr>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D1}" id="D1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D2}" id="D2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D3}" id="D3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D4}" id="D4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D5}" id="D5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D6}" id="D6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D7}" id="D7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D8}" id="D8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D9}" id="D9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.D10}" id="D10" ></td>

		</tr>
		
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E1}" id="E1" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E2}" id="E2" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E3}" id="E3" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E4}" id="E4" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E5}" id="E5" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E6}" id="E6" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E7}" id="E7" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E8}" id="E8" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E9}" id="E9" ></td>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofa${seat.E10}" id="E10" ></td>

		</tr>
	</table>
	<br>
	<br>
	<table>
		<tr>
			<td><img src="<c:url value='/images/04/sofaOff.png' />" alt="" title="" class="sofademo">空位</td>
			<td><img src="<c:url value='/images/04/sofa.png' />" alt="" title="" class="sofademo">已售出</td>
			<td><img src="<c:url value='/images/04/sofaTick.png' />" alt="" title=""class="sofademo">已加入購物車</td>
		</tr>
	</table>
	<form name="order" action="<c:url value='/04/booking'/>" method="get">
	<br><br><input type="submit" class="btn btn-outline-info" value="下一步">
	</form>
</div>	
	
<script src="https://code.jquery.com/jquery-3.5.1.js"
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
		crossorigin="anonymous"></script>
 	<script> 
 	//將已劃位的位置改為sofa.png
 	 $(".sofa1").attr("src", "<c:url value='/images/04/sofa.png' />");

 	    //點擊更換圖片 利用圖片src的value來判斷 		
 	    $(".sofa").mouseover(function() {
 	 	    //顯示選取框
			$(this).css("border-color", "#FFAC55");
			//顯示已選座位數量
			$("#showseat").text($(this).attr('id'));
 		}).mouseout(function() {
 			//隱藏選取框
 			$(this).css("border-color", "#FFFFFF")
 		}).click(function() {
 			if ($(this).attr("src") == "<c:url value='/images/04/sofaOff.png' />") {
 	 			//換成選取座位圖
 				$(this).attr("src", "<c:url value='/images/04/sofaTick.png' />")				
 				$("#selectseat").append("<td class='seat' id='td"+$(this).attr('id')+"'>"+$(this).attr('id')+"<td>");
 				$("#selectnum").text($(".seat").length);
 				if ($(".seat").length ==5) {
 					alert("最多選擇五個座位");
				}
 			} else {
 	 			//換回空位
 	 			var id ="td"+$(this).attr('id');
 				$(this).attr("src", "<c:url value='/images/04/sofaOff.png' />")
//   				$("td").remove("#"+id);
 				$("#"+id).remove();
 				$("#selectnum").text($(".seat").length);
 			}
 		});    
		
//  	   $(".sofatick").mouseover(function() {
// 			$(this).css("border-color", "#FFAC55");
// 		}).mouseout(function() {
// 			$(this).css("border-color", "#FFFFFF")
// 		}).click(function() {
// 			$("td").remove(".seat");
// 			$("#selectseat").empty("#tdA5");
//  			$(".seat").remove();
//  				$("#selectnum").text($(".seat").length);
// 				$(this).attr("src", "<c:url value='/images/04/sofaOff.png' />")
// 				$(this).attr("class","sofa")
// 		});    
 
			//游標移至圖片顯示座位名
// 			$('.sofa').each(function() {
// 				$(this).mouseover(function() {
// 					$("#showseat").text($(this).attr('id'));
// 				});
// 			});
			//顯示選取座位名
// 				$(".sofa").click(function() {
// 					if ($(this).attr("src") == "<c:url value='/images/04/sofaTick.png' />") {
// 					$("#selectseat").append("<td class='seat' id='tdA5'>"+$(this).attr('id')+"<td>");
// // 					$("#selectseat").append("<td class='seat' id=td"+$(this).attr('id')+">"+$(this).attr('id')+"<td>");
// 					$("#selectnum").text($(".seat").length);
// 		 			}else {
// 		 			$(".seatid").remove();
// 		 			}
// 				});
				
// 				$(".sofatick").click(function() {
// 				var $id =$(this).attr('id');			
// 					$(".seat").empty("#tdA5");
// 					$(".seat").remove();
// 		 			$("#selectnum").text($(".seat").length);
			
// 				});

		</script> 
<script>

</script>

</body>
</html>