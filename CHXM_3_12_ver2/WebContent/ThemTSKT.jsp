<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Thêm</title>
<metacontent ="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no "name="viewport"> <!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"href="${home }admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"href="${home }admin/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${home }admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="${home }admin/dist/css/mycss.css">
<script src="${home }admin/dist/js/myjs.js"></script> <script
	src="${home }admin/dist/js/canvasjs.min.js"></script> <script
	src="${home }admin/dist/js/mychart.js"></script>
<link rel="stylesheet" href="${home }admin/dist/css/skins/_all-skins.min.css">
<!-- jQuery 3 --> <script
	src="${home }admin/bower_components/jquery/dist/jquery.min.js"></script> <!-- Bootstrap 3.3.7 -->
<script src="${home }admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${home }admin/dist/js/adminlte.min.js"></script> <script
	src="${home }admin/dist/js/demo.js"></script>
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
					<li><a href="ThongSoKyThuat.jsp"><i class="fa fa-gears"></i>
							Thông số kỹ thuật</a></li>
					<li>Thêm</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="box">
					<div class="box-header text-center" style="color: red">
						<h3>Thông số kỹ thuật</h3>
					</div>
					<div class="box-body">
					<c:if test="${tskt == null }">
						<form class="form-horizontal" action="ThongSoKyThuat/Them" method="post">
					</c:if>
					<c:if test="${tskt != null }">
						<form class="form-horizontal" action="${home }ThongSoKyThuat/Sua" method="post">
					</c:if>
							<div class="form-group">
								<table class="table table-striped">
									<colgroup>
										<col span="3">
									</colgroup>
									<tbody>
										<tr>
											<td><strong>Mã TSKT</strong><br>
											<input type="text" class="form-control" required
												maxlength="5" name="maTSKT" value="<c:out value='${tskt.maTSKT }'/>"></td>
											<td><strong>Tên sản phẩm</strong><br>
											<input type="text" class="form-control" required name="tenXe" 
											value="<c:out value='${tskt.tenXe }'/>"></td>
											<td><strong>Trọng lượng bản thân</strong><br>
											<input type="text" class="form-control" required name="khoiLuong"
											value="<c:out value='${tskt.khoiLuong }'/>"></td>

										</tr>
										<tr>
											<td><strong>Dung tích bình xăng</strong><br>
											<input type="text" class="form-control" required name = "dungTichBinhXang"
											value="<c:out value='${tskt.dungTichBinhXang }'/>"></td>
											<td><strong>Kích hước lớp trước</strong><br>
											<input type="text" class="form-control" required name="ktLopTruoc"
											value="<c:out value='${tskt.ktLopTruoc }'/>"></td>
											<td><strong>Kích thước lớp sau</strong><br>
											<input type="text" class="form-control" required name="ktLopSau"
											value="<c:out value='${tskt.ktLopSau }'/>"></td>

										</tr>
										<tr>
											<td><strong>Loại động cơ</strong><br>
											<input type="text" class="form-control" required name="loaiDongCo"
											value="<c:out value='${tskt.loaiDongCo}'/>"></td>
											<td><strong>Dung tích xi lanh</strong><br>
											<input type="text" class="form-control" required name="dungTichXiLanh"
											value="<c:out value='${tskt.dungTichXiLanh}'/>"></td>
											<td><strong>Công suất tối đa</strong><br>
											<input type="text" class="form-control" required name="congSuatToiDa"
											value="<c:out value='${tskt.congSuatToiDa}'/>"></td>

										</tr>
										<tr>
											<td><strong>Dung tích nhớt máyc</strong><br>
											<input type="text" class="form-control" required name="dungTichNhotMay"
											value="<c:out value='${tskt.dungTichNhotMay}'/>"></td>
											<td><strong>Hộp số</strong><br>
											<input type="text" class="form-control" required name="hopSo"
											value="<c:out value='${tskt.hopSo}'/>"></td>

											<td><strong>Hệ thống khởi động</strong><br>
											<input type="text" class="form-control" required name="heThongKhoiDong"
											value="<c:out value='${tskt.heThongKhoiDong}'/>"></td>
										</tr>
										
									</tbody>
								</table>
							</div>
							<div class="form-group">
								<a href="ThongSoKyThuat.jsp"><button type="button"
										class="btn btn-danger">
										<i class="fa fa-trash"></i>Hủy bỏ
									</button></a>
								<button type="submit" class="btn btn-info fa-pull-right">
									<i class="fa fa-info"></i> Hoàn tất
								</button>
							</div>
						</form>
					</div>
				</div>

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<div>
			<jsp:include page="admin/footer/footer_level1.jsp"></jsp:include>
		</div>
</body>
</html>