<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.html"> <svg width="1.25em" height="1.25em"
			viewBox="0 0 16 16" class="bi bi-flower2" fill="currentColor"
			xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
				d="M8 16a4 4 0 0 0 4-4 4 4 0 0 0 0-8 4 4 0 0 0-8 0 4 4 0 1 0 0 8 4 4 0 0 0 4 4zm3-12a3 3 0 0 0-6 0c0 .073.01.155.03.247.544.241 1.091.638 1.598 1.084A2.987 2.987 0 0 1 8 5c.494 0 .96.12 1.372.331.507-.446 1.054-.843 1.598-1.084.02-.092.03-.174.03-.247zm-.812 6.052A2.99 2.99 0 0 0 11 8a2.99 2.99 0 0 0-.812-2.052c.215-.18.432-.346.647-.487C11.34 5.131 11.732 5 12 5a3 3 0 1 1 0 6c-.268 0-.66-.13-1.165-.461a6.833 6.833 0 0 1-.647-.487zm-3.56.617a3.001 3.001 0 0 0 2.744 0c.507.446 1.054.842 1.598 1.084.02.091.03.174.03.247a3 3 0 1 1-6 0c0-.073.01-.155.03-.247.544-.242 1.091-.638 1.598-1.084zm-.816-4.721A2.99 2.99 0 0 0 5 8c0 .794.308 1.516.812 2.052a6.83 6.83 0 0 1-.647.487C4.66 10.869 4.268 11 4 11a3 3 0 0 1 0-6c.268 0 .66.13 1.165.461.215.141.432.306.647.487zM8 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
</svg>

		<div class="sidebar-brand-text mx-3">
			得藝的一天 <sup>後台</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item h5"><a class="nav-link" href="#"> <i
			class="fa fa-tachometer" aria-hidden="true"></i> <span
			style="font-size: medium;">主控台</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">
		<h5>企業會員功能列表</h5>
	</div>

	

	<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> 
			<i class="fas fa-users"></i> <span>企業會員功能</span>
	</a>
		<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">藝文活動服務:</h6>
				<a class="collapse-item" href="#">包場場地一覽</a> <a
					class="collapse-item" href="#">場地租借</a> <a
					class="collapse-item" href="#">提供藝文活動場地</a>
				<a class="collapse-item" href="#">Other</a>
			</div>
		</div></li>
		
		<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-hand-holding-usd"></i> <span>贊助專區</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">贊助服務一覽:</h6>
				<a class="collapse-item" href="#">搜尋需贊助對象</a> <a
					class="collapse-item" href="#">金流服務</a>
			</div>
		</div></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">
		<h5>一般會員功能列表</h5>
	</div>

	<!-- Nav Item - 一般功能 Menu -->
	<!-- 票務相關 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages"
		aria-expanded="true" aria-controls="collapsePages"> <i
			class="fa fa-ticket" aria-hidden="true"></i> <span>票務服務</span>
	</a>
		<div id="collapsePages" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">我是買家:</h6>
				<a class="collapse-item" href="#">票務購物車</a> <a class="collapse-item"
					href="#">購票紀錄</a> <a class="collapse-item" href="#">猜我喜歡</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">我是賣家:</h6>
				<a class="collapse-item" href="#">票卷上架</a> <a class="collapse-item"
					href="#">票卷下架</a> <a class="collapse-item" href="#">修改商品內容</a>
			</div>
		</div>
		
		</li>
		
	<!-- 洋行相關 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages2"
		aria-expanded="true" aria-controls="collapsePages"> 
			<i class="fas fa-gifts"></i> <span>商城服務</span>
	</a>
		<div id="collapsePages2" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">我是買家:</h6>
				<a class="collapse-item" href="#">商城購物車</a> <a class="collapse-item"
					href="#">購物紀錄</a> <a class="collapse-item" href="#">猜我喜歡</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">我是賣家:</h6>
				<a class="collapse-item" href="<c:url value='/14/Create.ctrl' />">商品上架</a> <a class="collapse-item"
					href="<c:url value='/14/CRUD.ctrl' />">商品下架</a> <a class="collapse-item" href="<c:url value='/myaction.controller' />">修改商品內容</a>
			</div>
		</div>
		
		</li>
		
	<!-- 店家相關 -->	
		<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages3"
		aria-expanded="true" aria-controls="collapsePages"> 
			<i class="fas fa-store"></i> <span>店家服務一覽</span>
	</a>
		<div id="collapsePages3" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">我找過的店家:</h6>
				<a class="collapse-item" href="#">這個那個</a> <a class="collapse-item"
					href="#">紀錄</a> <a class="collapse-item" href="#">猜我喜歡</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">申請當店家:</h6>
				<a class="collapse-item" href="#">商品上架</a> <a class="collapse-item"
					href="#">商品下架</a> <a class="collapse-item" href="#">修改商品內容</a>
			</div>
		</div>
		
		</li>
		
		
		<!-- 吟遊詩人 -->	
		<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages4"
		aria-expanded="true" aria-controls="collapsePages"> 
			<i class="fas fa-person-booth"></i> <span>街頭藝人服務</span>
	</a>
		<div id="collapsePages4" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">尋找藝人:</h6>
				<a class="collapse-item" href="#">這個那個</a> <a class="collapse-item"
					href="#">這個那個</a> <a class="collapse-item" href="#">這個那個</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">我是藝人:</h6>
				<a class="collapse-item" href="#">藝人上架</a> <a class="collapse-item"
					href="#">藝人下架</a> <a class="collapse-item" href="#">修改藝人資料</a>
			</div>
		</div>
		
		</li>
		
		<!-- 課程功能 -->	
		<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapsePages5"
		aria-expanded="true" aria-controls="collapsePages"> 
			<i class="fas fa-chalkboard-teacher"></i> <span>藝術課程服務</span>
	</a>
		<div id="collapsePages5" class="collapse"
			aria-labelledby="headingPages" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">我要上課:</h6>
				<a class="collapse-item" href="#">這個那個</a> <a class="collapse-item"
					href="#">這個那個</a> <a class="collapse-item" href="#">這個那個</a>
				<div class="collapse-divider"></div>
				<h6 class="collapse-header">我要開課:</h6>
				<a class="collapse-item" href="#">課程上架</a> <a class="collapse-item"
					href="#">課程下架</a> <a class="collapse-item" href="#">修改課程資料</a>
			</div>
		</div>
		
		</li>
		

	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
			class="fas fa-fw fa-chart-area"></i> <span>待開發</span></a></li>

	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="#"> <i
			class="fas fa-fw fa-table"></i> <span>待開發</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->