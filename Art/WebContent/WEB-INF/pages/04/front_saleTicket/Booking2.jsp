<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%request.setCharacterEncoding("UTF-8");%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>購物車</title>
    <style>
        td {
            width: 100px;
        }

       .halfnum {
            width: 30px;
        }
        .adultnum {
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
        #1{
        float:right;
        }
       

    </style>
<!-- CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- jQuery and JS bundle w/ Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</head>

<body>
<form name="order2" action="<c:url value='/04/booking3'/> " method="get">


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
  		<div class="progress-bar progress-bar-striped bg-info" role="progressbar" style="width: 53%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
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







<c:set var="name" value="${param.name}" scope="session"/> 
<c:set var="email" value="${param.email}" scope="session"/> 
<c:set var="tel" value="${param.tel}" scope="session"/> 
<c:set var="add" value="${param.add}" scope="session"/> 
    <H1>訂購人資訊</H1>
 <table class= "table table-bordered">
        
        <tr>
            <td>訂購人姓名
            </td>
            <td>
             <input type="text" name="name" value="">
        </tr>
        <tr>
            <td>電子郵件
            </td>
            <td>
             <input type="text" name="email" value="">
             </td>
        </tr>
        <tr>
            <td>電話
            </td>
            <td>
             <input type="text" name="tel">
            </td>
        </tr>
        <tr>
            <td>地址
            </td>
            <td>
             <input type="text" name="add">
            </td>
        </tr>
     </table><br><br> <br>  
		<H2>訂購票券</H2>
      <table class= "table table-bordered">  
        <tr>
            <td class="title">節目名稱</td>
            <td>票種</td>
            <td>數量</td>
            <td >價格</td>
            <td class="price2">總價</td>
<!--             <td>操作</td> -->
        </tr>
        <%--使用JSTL 執行for loop ${show.no}取map內value --%>
     <%--    <c:set var="sum" value="${0}"/>  --%>
        <c:forEach items="${cartlist}" var="show" varStatus="idx">
       <!-- 傳送訂單資訊 -->
        
		<tr>
            <td>${show.title}</td>
            <td>全票</td>
             <td>
                <input type="button" value="-" name="minus" class="minus" id="minus">
                <input type="text" name="adultnum" id="adultnum" class="adultnum" value="${show.adultnum}" >
                <input type="button" value="+" name="plus" class="plus" id="plus">
            </td>
           <td name="price" class="price" id="price" >NT$1000</td>

            <td>NT$<input type="text" name="total1" id="total1" class="total1"value="${show.total1}" readonly="readonly" /></td>


<!--             <td > -->
<!--             <input type="button" value="修改" name="submit" class="submit" id="submit"  > -->
<!--             <input type="button" value="刪除" name="submit" class="submit" id="submit"  ></td> -->
         </tr>
      
         <tr>
            <td>${show.title}</td>
            <td>半票</td>
            <td>
                <input type="button" value="-" name="minus2" class="minus2" id="minus2">
                <input type="text" name="halfnum" id="halfnum" class="halfnum" value="${show.halfnum}" >
                <input type="button" value="+" name="plus2" class="plus2" id="plus2">
            </td>
            
            <td name="price" class="price" id="price" >NT$500</td>
            <td>NT$<input type="text" name="total2" id="total2" class="total2"value="${show.total2}" readonly="readonly" /></td>
<!--             <td > -->
<!--             <input type="button" value="修改" name="submit" class="submit" id="submit"  > -->
<%--             <input type="button" value="刪除" name="submit" class="submit" id="submit" onclick="<c:url value='/_04_ShopCart/DelectCart'/>"></td> --%>
        </tr>
			
<!-- 		設定totalprice加總 -->
<%-- 		<c:set var="sum" value="${sum + show.totalprice}" scope="session" /> --%>
		<c:set var="sum" value="${sum + show.totalprice}"  />
		</c:forEach>
<tr><td>總計</td><td></td><td></td><td></td><td>NT$<input type="text" name="total3" id="total3" class="totalprice"value="${sum}" readonly="readonly" /></td><tr>

   </table>     
          <input type="submit" value="繼續購票" name="1" class="btn btn-outline-info" id="1">  
    	 </form>
   		<form name="order" action="<c:url value='/_04_ShopCart/ClearCart'/>" method="POST">
          <br><input type="submit" value="全部清除" name="clear" class="btn btn-outline-info" id="clear"> 
    	 </form>
<%--    		<form name="order" action="<c:url value='/_04_ShopCart/Delect'/>" method="POST"> --%>
<!--           <input type="submit" value="刪除測試" name="clear" class="clear" id="clear">  -->
<!--     	 </form> -->
            
<%--             <form name="order" action="<c:url value='/_04_ShopCart/Delect'/>" method="POST"> --%>
<!--           <input type="submit" value="刪除測試" name="clear" class="clear" id="clear">  -->
<!--     	 </form> -->

</div>   

 <script src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<script>
        //全票
        $(document).ready(function(){

        $(".adultnum").val(count);
        $("#plus").click(function () {
        	//設定數量上限為5
        	if (count < 5) {
        		count++;
            } else if (count=5 ) {
            	count = 5;
            	alert("最多訂購五張");
            }
        $(".adultnum").val(count);
        $("#total1").val(count*parseInt(1000))
        $("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus").click(function () {
        	//設定數量下限0
        	if (count >0) {
        		count--;
            } else if (count=0 ) {
            	count = 0;
            }
        $("#adultnum").val(count);
        $("#total1").val(count*parseInt(1000))
		$("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        return count;
        }) 

        $("#halfnum").val(count2);
        $("#plus2").click(function () {
        	if (count2 < 5) {
        		count2++;
            } else if (count2=5 ) {
            	count2 = 5;
            	alert("最多訂購五張");
            }
        $("#halfnum").val(count2);  
        $("#total2").val(count2*parseInt(500))
       	$("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 
        $("#minus2").click(function () {
        	if (count2 >0) {
        		count2--;
            } else if (count2=0 ) {
            	count2 = 0;
            }
        $("#halfnum").val(count2);
        $("#total2").val(count2*parseInt(500)) 
        $("#total3").val(count*parseInt(1000)+count2*parseInt(500))
        }) 

    }) 
    //半票

    </script> 


<!--  <script> 
//         //全票
//         $(document).ready(function(){
//         	/* 價格顯示 */

//         	/* $("select").change(function(){
//         		  $("#price").text("500");
//         		}); */

//         $(".adultnum").val(count);
//         $(".plus").click(function () {
//         	//設定數量上限為5
//         	if (count < 5) {
//         		count++;
//             } else if (count=5 ) {
//             	count = 5;
//             	alert("最多訂購五張");
//             }
//         $(".adultnum").val(count);
//         $(".total1").val(count*parseInt(1000))
//         $(".total3").val(count*parseInt(1000)+count2*parseInt(500))
//         }) 
//         $(".minus").click(function () {
//         	//設定數量下限0
//         	if (count >0) {
//         		count--;
//             } else if (count=0 ) {
//             	count = 0;
//             }
//         $(".adultnum").val(count);
//         $(".total1").val(count*parseInt(1000))
// 		$(".total3").val(count*parseInt(1000)+count2*parseInt(500))
//         return count;
//         }) 
//         $(".halfnum").val(count2);
//         $(".plus2").click(function () {
//         	if (count2 < 5) {
//         		count2++;
//             } else if (count2=5 ) {
//             	count2 = 5;
//             	alert("最多訂購五張");
//             }
//         $(".halfnum").val(count2);  
//         $(".total2").val(count2*parseInt(500))
//        	$(".total3").val(count*parseInt(1000)+count2*parseInt(500))
//         }) 
//         $(".minus2").click(function () {
//         	if (count2 >0) {
//         		count2--;
//             } else if (count2=0 ) {
//             	count2 = 0;
//             }
//         $(".halfnum").val(count2);
//         $(".total2").val(count2*parseInt(500)) 
//         $(".total3").val(count*parseInt(1000)+count2*parseInt(500))
//         }) 

//     }) 
//     //半票

 </script>  -->

</body>

</html>