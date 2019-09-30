<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Danh sách phiếu nhập</title>
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
					<li>Danh sách phiếu nhập hàng</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<!-- Bảng chính -->
				
				<div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">Bảng danh sách sản phẩm</h3>
                            </div>
                            <div class="box-body"  style="height:400px; overflow:scroll">
                                <div class="row">
                                    <div class="col-xs-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                                            <input type="text" class="form-control" onkeyup="myFunctionHD()" id="myInput"
                                                placeholder="Tìm">
                                        </div>
                                    </div>
                                    <div class="col-xs-2">
                                        <div class="btn-them">
                                            <a href="PhieuNhap/ShowFormThem">
                                                <button type="button" class="btn btn-primary"><i class="fa fa-plus"></i> Thêm</button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-bordered table-hover" id="myTable">
                                    <thead>
                                        <tr>
                                          <th>Mã phiếu</th>                                       
                                          <th>Ngày nhập</th>
                                          <th>Số lượng</th>
                                          <th>Mã sản phẩm</th>
                                          <th>Giá nhập</th>
                                          <th>Sửa</th>
                                        </tr>
                                      </thead>
                
                                      <tbody>
                                      <c:forEach var="pn" items="${listPhieuNhap}">
                                    <tr>
                                        <td><c:out value="${pn.maPNH}" /></td>
                                        <td><c:out value="${pn.thoiGian}" /></td>
                                        <td><c:out value="${pn.soLuong}" /></td>
                                        <td><c:out value="${pn.maSP}" /></td>
                                        <td><c:out value="${pn.gia}" /></td>
                                        
                                        <td><span> <a href="PhieuNhap/ShowFormSua?maPNH=<c:out value='${pn.maPNH }' />">
														<button type="button" class="btn btn-info">
															<i class="fa fa-pencil"></i> Sửa
														</button>
												</a>
										</span></td>
					
                                    </tr>
                            		</c:forEach>
                                        
                                         
                                      </tbody>
                                </table>
                            </div>
                        </div>
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