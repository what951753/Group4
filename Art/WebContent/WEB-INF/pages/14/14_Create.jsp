<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.group4._14_shopAP.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

<!-- 	<button type="button" class="btn btn-info btn-sm" value="button" -->
<%-- 		onclick="location.href='<c:url value='/DemoServlet'/>'">回上一頁</button> --%>

<br>
<br>
 

	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">新增商品</h6>
		</div>
		<div class="card-body">
			新增商品<span style="color: crimson; font-size: smaller">(*字號欄位不可空白)</span>
		</div>
		
		<form class="form-group" ACTION="createProduct.ctrl">
		<input type="hidden" name="function" value="create" />

		<div>
			<p>
				品名<span style="color: crimson; font-size: larger">*</span>： <input
					type="text" name="APTITLE" required="required" value="某東西">
			</p>
		</div>
		<div>
			<p>
				價格<span style="color: crimson; font-size: larger">*</span>： <input
					type="text" name="APPRICE" required="required" value="999">
			</p>
			<p>
				數量<span style="color: crimson; font-size: larger">*</span>： <input
					type="number" name="APNUM" required="required" min="1" value="50">
			</p>
			<p>
				類型<span style="color: crimson; font-size: larger">*</span>： <input
					type="text" name="APTYPE" required="required" value="">
			</p>
		</div>
		<div>
		<textarea name="APDES" class="cls" id="" cols="100" rows="10" >

		</textarea>
		
		</div>

		<div>
			<input class="btn" type="button" name="check2" value="顯示空白阿">
			<input class="btn2" type="submit" name="check2" value="完成新增">
		</div>
		<div class="test" ></div>
	</form>
		
		
		
		</div>
	</div>

<script>
$(document).ready(function (){
	  $('.btn').click(function(e){
	    var str1 =$('textarea').val();
	    console.log(str1);
	    str2 = str1.replace("a", "t");

	     //textarea換行轉成<br>
	    str2 = str2.replace("c","g");
			$('.test').html(str2);
	  });
	});
</script>
