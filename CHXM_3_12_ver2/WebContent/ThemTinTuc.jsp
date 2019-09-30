<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Thêm tin tức</title>
<meta content ="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no "name="viewport"> <!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"href="${home}admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"href="${home}admin/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${home}admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${home}admin/dist/css/mycss.css">
<script src="${home}admin/dist/js/myjs.js"></script> <script
	src="${home}admin/dist/js/canvasjs.min.js"></script> <script
	src="${home}admin/dist/js/mychart.js"></script>
<link rel="stylesheet" href="${home}admin/dist/css/skins/_all-skins.min.css">
<!-- jQuery 3 --> <script
	src="${home}admin/bower_components/jquery/dist/jquery.min.js"></script> <!-- Bootstrap 3.3.7 -->
<script src="${home}admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${home}admin/dist/js/adminlte.min.js"></script> <script
	src="${home}admin/dist/js/demo.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<div>
			<jsp:include page="admin/header/header_level1.jsp"></jsp:include>
		</div>

		<div>
			<jsp:include page="admin/Aside/Aside_level1.jsp"></jsp:include>
		</div>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Cửa hàng xe máy <small>Quản trị viên</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="TrangChuAdmin.jsp"><i
							class="fa fa-dashboard"></i>Trang chủ</a></li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Thêm tin tức</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<c:if test="${tt == null}">
							<form action="TinTuc/Them" method="post" class="form-horizontal" enctype="multipart/form-data">
							</c:if>
							<c:if test="${tt != null}">
							<form action="${home }TinTuc/Sua" method="post" class="form-horizontal" enctype="multipart/form-data">
							</c:if>
        
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">Mã tin</label>

										<div class="col-sm-10">
											<input type="text"  name="maTin" class="form-control"placeholder="Mã" required
											value="<c:out value='${tt.maTin}' />" > <br>
										</div>
										<label class="col-sm-2 control-label">Tựa</label>

										<div class="col-sm-10">
											<input type="text" name="Tua" class="form-control" placeholder="Tựa" required
											value="<c:out value='${tt.tua}' />"> <br>
										</div>
										<label class="col-sm-2 control-label">Nội dung</label>

										<div class="col-sm-10">
											<%-- <input type="text" name="noiDung" class="form-control" placeholder="Nội dung" required
											value="<c:out value='${tt.tua}' />">  --%>
											<textarea rows="5" cols="80" name="noiDung" value="<c:out value='${tt.noiDung}' />"> </textarea> <br>
										</div>
										<label class="col-sm-2 control-label">Hình ảnh</label>

										<div class="col-sm-10">
											<input type="file" name="hinhanh" class="form-control"  required
											value="<c:out value='${tt.hinhAnh}' />"> 
										</div>
									</div>
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<a href="TinTuc"><button type="button"
											class="btn btn-danger">
											<i class="fa fa-trash-o"></i> Hủy bỏ
										</button></a>
									<button type="submit" class="btn btn-info pull-right"
										onclick="return KT_FormThemSP();">
										<i class="fa fa-save"></i> Hoàn tất
									</button>
								</div>
								<!-- /.box-footer -->
							</form>
						</div>
					</div>
					<div class="col-md-2"></div>

				</div>
			
			</section>
			<!-- /.content -->
		</div>
		</div>
		<!-- /.content-wrapper -->
		<div>
			<jsp:include page="admin/footer/footer_level1.jsp"></jsp:include>
		</div>
</body>
</html>