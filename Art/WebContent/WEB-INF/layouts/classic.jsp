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
  <!-- Custom fonts for this template-->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.js" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css"> -->
  
<!-- <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script> -->

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<script src="https://kit.fontawesome.com/69d3e645c0.js" crossorigin="anonymous"></script>
<!-- Bootstrap core JavaScript-->
<!--   <script src="vendor/jquery/jquery.min.js"></script> -->
<!--   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
  <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

  <!-- Core plugin JavaScript-->
<!--   <script src="vendor/jquery-easing/jquery.easing.min.js"></script> -->
  <script src="<c:url value='/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

  <!-- Custom scripts for all pages-->
<!--   <script src="js/sb-admin-2.min.js"></script> -->
  <script src="<c:url value='/js/sb-admin-2.min.js'/>"></script>

  <!-- Page level plugins -->
<!--   <script src="./pages/vendor/datatables/jquery.dataTables.min.js"></script> -->
<!--   <script src="./pages/vendor/datatables/dataTables.bootstrap4.min.js"></script> -->
<%--   <script src="<c:url value='/vendor/datatables/jquery.dataTables.min.js'/>"></script> --%>
<%--   <script src="<c:url value='/vendor/datatables/dataTables.bootstrap4.min.js'/>"></script> --%>

  <!-- Page level custom scripts -->
<!--   <script src="./pages/js/demo/datatables-demo.js"></script> -->
<%--   <script src="<c:url value='/js/demo/datatables-demo.js'/>"></script> --%>

  <!-- Custom styles for this template
  <link href="../pages/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet" />
  -->

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
</body>
</html>