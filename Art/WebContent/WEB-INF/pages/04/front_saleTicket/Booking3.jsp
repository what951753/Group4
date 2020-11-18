<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>確認訂單資訊</title>
    <style>
        td {
            width: 100px;
        }

        .orderNum {
            width: 30px;
        }
        .title{
         width:200px;
        }
        .total1{
        width: 120px;
        }
        .total2{
        width: 120px;
        }
        .totalprice{
        width: 120px;
        }
        
        .price2{
        width:200px;
        }
    </style>

<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</head>

<body>


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
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 78%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
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








<form name="order2" action="<c:url value='/04/booking3'/> " method="get">
<c:set var="name" value="${param.name}" scope="session"/> 
<c:set var="email" value="${param.email}" scope="session"/> 
<c:set var="tel" value="${param.tel}" scope="session"/> 
<c:set var="add" value="${param.add}" scope="session"/> 
<c:set var="totalprice" value="${param.total3}" scope="session"/> 
    <H1>確認訂單資訊</H1>
    <table class= "table table-bordered">
        <tr>
            <td>訂購人姓名
            </td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             ${email}
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
            
             ${tel}
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             ${add}
            </td>
        </tr>
     </table><br><br> <br>  

      <table class= "table table-bordered">  
        
        <tr>
            <td class="title">節目名稱</td>
            <td>票種</td>
            <td>數量</td>
            <td>價格</td>
            <td class="price2">總價</td>
           
        </tr>
        
         </tr>
        <%--使用JSTL 執行for loop ${show.no}取map內value --%>
        <c:forEach items="${cartlist}" var="show" varStatus="idx">
        <tr>
       <!-- 傳送訂單資訊 -->
       <form name="order" action="" method="get">
		<tr>
            <td>${show.title}</td>
            <td>全票</td>
            <td>${show.halfnum}</td>  
           <td name="price" class="price" id="price" >1000</td>
            <td>${show.total1}</td>
           
         </tr>
         <tr>
         
     
         
            <td>${show.title}</td>
            <td>半票</td>
            <td>${show.halfnum}</td>         
            <td name="price" class="price" id="price" >500</td>
            <td>${show.total2}</td>
        </tr>
			</form>
			
			
		</c:forEach>       
        <tr><td>總計</td><td></td><td></td><td></td><td>${totalprice}</td><tr>

    </table><br>
    </form>
          <input type="button" value="修改訂單" name="" class="btn btn-outline-info" id="" onclick="history.back()">  
          <input type="submit" value="送出訂單" name="1" class="btn btn-outline-info" id="1">  
</div>
    
<!-- <script src="js\jquery-3.5.1.min.js"></script> -->
 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</script>

    <script>

    $("#1").click(function () {
    	if (confirm("是否送出訂單? ")) {
    		window.location ="<c:url value='/_04_ShopCart/DelectCart'/>" 
    	} else {
    		return false;
    	}
    	
    })

    </script>

</body>

</html>