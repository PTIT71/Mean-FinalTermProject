<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Khách hàng</title>
<meta content ="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no "name="viewport"> <!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"href="admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"href="admin/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="admin/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="admin/dist/css/mycss.css">
<script src="admin/dist/js/myjs.js"></script> <script
	src="admin/dist/js/canvasjs.min.js"></script> <script
	src="admin/dist/js/mychart.js"></script>
<link rel="stylesheet" href="admin/dist/css/skins/_all-skins.min.css">
<!-- jQuery 3 --> <script
	src="admin/bower_components/jquery/dist/jquery.min.js"></script> <!-- Bootstrap 3.3.7 -->
<script src="admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="admin/dist/js/adminlte.min.js"></script> <script
	src="admin/dist/js/demo.js"></script>
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
					<li>Loại sản phẩm</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			
				<div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="box">
                        <div class="box-header text-center" style="color: red">
						<h3>Bảng phân loại xe</h3>
						<a href="ThemLoaiSanPham.jsp"> <button type="button">Thêm</button></a>
					</div>
                        <div class="box-body"  style="height:400px; overflow:scroll">
                            <table class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>Mã loại</th>
                                    <th>Tên loại</th>
                                 </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="lsp" items="${listLSP}">
                                    <tr>
                                        <td><c:out value="${lsp.maLoai}" /></td>
                                        <td><c:out value="${lsp.tenLoai}" /></td>
                                        <td><span> <a href="LoaiSanPham/ShowFormSua?maLoai=<c:out value='${lsp.maLoai}' />">
														<button type="button" class="btn btn-info">
															<i class="fa fa-pencil"></i> Sửa
														</button>
												</a>
											</span></td>
					
											<td>
												<div>

													<!-- Button to Open the Modal -->
													<div > <!-- data-toggle="modal" data-target="#myModal" -->
														<a href="LoaiSanPham/Xoa?maLoai=<c:out value='${lsp.maLoai}' />">
														<button type="button" class="btn btn-info">
															<i class="fa fa-pencil"></i> Xóa
														</button>
												</a>
													</div>

													<!-- The Modal -->
													<div class="modal fade" id="myModal">
														<div class="modal-dialog">
															<div class="modal-content">

																<!-- Modal Header -->
																<div class="modal-header">
																	<h4 class="modal-title">Cảnh báo</h4>
																	<button type="button" class="close"
																		data-dismiss="modal">&times;</button>
																</div>

																<!-- Modal body -->
																<div class="modal-body">Bạn có chắc chắn muốn xóa?
																</div>

																<!-- Modal footer -->
																<div class="modal-footer">
																	<button type="button" class="btn btn-dropbox"
																		data-dismiss="modal">Ok</button>
																	<button type="button" class="btn btn-danger"
																		data-dismiss="modal">Close</button>
																</div>

															</div>
														</div>
													</div>
												</div>
											</td>
                                    </tr>
                            		</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3"></div>
			
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