<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
 <!DOCTYPE html>
<html lang="en">
 <head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Blank</title>
<!-- jQuery CDN minifid-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>


<!-- Custom fonts for this template-->
  <link href="<c:url value='/css/all.min.css'/>" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <script src="https://kit.fontawesome.com/23f780069c.js" crossorigin="anonymous"></script>

  <!-- Custom styles for this template -->
<link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet" />

 
</head>
 <body id="page-top">
   <!-- Page Wrapper -->
  <div id="wrapper">
	<tiles:insertAttribute name="menu" />
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</div>
<!-- Bootstrap core JavaScript-->
<!--   <script src="../pages/vendor/jquery/jquery.min.js"></script> -->
<!--    <script src="../pages/vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
<script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

 
  <!-- Core plugin JavaScript-->

<script src="<c:url value='/jquery-easing/jquery.easing.min.js'/>"></script>

  <!-- Custom scripts for all pages-->
<script src="<c:url value='/js/sb-admin-2.min.js'/>"></script>

</body>
</html>