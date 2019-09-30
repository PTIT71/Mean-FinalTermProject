<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sửa hóa đơn</title>
    <metacontent ="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no "name="viewport"> <!-- Bootstrap 3.3.7 -->
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
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <script src="${home}admin/dist/js/jquery.validate.min.js"></script>
    <style>
        .tab {
        display: none;
        }
  </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<!-- Main content -->
			<section class="content">
			
				<div class="row">
                    <div class="col-sm-2"></div>
                    <div class="col-md-8">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">HÓA ĐƠN</h3>
                            </div>

                            <div class="box-body">
                                <form  class="form-horizontal"  action="KhachHang/XuatHoaDon" method="post">
                                    
                                        <div class="form-group">
                                        <label class="col-sm-3 control-label">Mã hóa đơn</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" value="<c:out value='${hd.maHD}' />" >
                                            </div>
                                            <label class="col-sm-3 control-label">Mã khách hàng</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" value="<c:out value='${hd.maKH}' />" >
                                            </div>
                                             <label class="col-sm-3 control-label">Ngày đặt hàng</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" value="<c:out value='${hd.ngayLap}' />" >
                                            </div>
                                            <label class="col-sm-3 control-label">Tổng tiền</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" value="<c:out value='${hd.tong}' />" >
                                            </div>
                                            <label class="col-sm-3 control-label">Trạng thái thanh toán</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control" value="<c:out value='${hd.trangThai}' />" >
                                            </div>
										</div>
								</form>
                            </div>
                        </div>
                        <div class="col-md-6">
                        </div>
                    </div>
                    <div class="col-sm-2"></div>
                     <a href="DangXuat?ten=<c:out value='${ten}' />"><button type="button">Đăng xuất</button></a>
                </div>
			
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		
	
</body>
</html>