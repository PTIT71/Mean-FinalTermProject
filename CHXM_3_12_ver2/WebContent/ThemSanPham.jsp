<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Thêm sản phẩm</title>
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
<script src="admin/dist/js/validate.js"></script>
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
					<li><a href="TrangChuAdmin.jsp"><iclass ="fafa-dashboard">
							</i>Trang chủ</a></li>
					<li><a href="SanPham.jsp"><i class="fa fa-motorcycle"></i>Sản
							phẩm</a></li>
					<li class="active">Thêm sản phẩm</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Thêm sản phẩm</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<c:if test="${sp == null }">
							<form action="Them" method="Post" class="form-horizontal" id="Them_SP" enctype="multipart/form-data">
							</c:if>
							<c:if test="${sp != null }">
							<form action="Sua" method="Post" class="form-horizontal" id="Sua_SP" enctype="multipart/form-data">
							</c:if>
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">Mã xe máy:</label>

										<div class="col-sm-10">
											<input type="text" id="maxe" name="maSP" class="form-control"
												placeholder="Mã"
												value="<c:out value='${sp.maSP}' />" > <small id="txtmaxe"
												style="color: red"></small>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Tên xe máy:</label>

										<div class="col-sm-10">
											<input type="text" id="tenxe" name="tenXe"
												class="form-control" placeholder="Tên"
												value="<c:out value='${sp.tenSP}' />"> 
												<small id="txttenxe" style="color: red" ></small>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Đơn giá:</label>

										<div class="col-sm-10">
											<input type="number" id="dongia" name="giaThanh"
												class="form-control" placeholder="Đơn giá"
												value="<c:out value='${sp.giaThanh}' />"> 
												<small id="txtdongia" style="color: red"></small>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Loại xe:</label>

										<div class="col-sm-10">
											<select id="loaixe" name="loaiXe"  
												class="form-control select2 select2-hidden-accessible"
												style="width: 100%;" tabindex="-1" aria-hidden="true">
												<c:forEach items="${listLoaiSP}" var="lsp"> 
												
												<option value="${lsp.maLoai }"><c:out value="${lsp.tenLoai }"></c:out></option>
												
												</c:forEach>
											</select> <small id="txtloaixe" style="color: red"></small>
										</div>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Mã loại thông số kỹ
											thuật</label>

										<div class="col-sm-8">
											<select id="maTSKT" name="maTSKT"  
												class="form-control select2-search__field"
												aria-autocomplete="list" style="width: 100%;" tabindex="-1"
												aria-hidden="true">
												<c:forEach items="${listTSKT}" var="kt"> 
												
												<option value="${kt.maTSKT}"><c:out value="${kt.tenXe }"></c:out></option>
												
												</c:forEach>
											</select> <small id="txtmaTSKT" style="color: red"></small>
									</div>
									
										<div class="col-sm-2">
											<button id="xemTSKT" type="button" class="btn btn-info" onClick="xem()">
												<i class="fa fa-book"></i> Xem
											</button>
											<small id="xemTSK" style="color: red"></small>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Hình ảnh</label>

										<div class="col-sm-10">
											<input type="file" id="hinhanh" name="hinhanh" class="form-control" value="<c:out value='${sp.hinhAnh}' />">
											<input type="hidden" name="hinhtext"  value="<c:out value='${sp.hinhAnh}' />"> 
										</div>
										
									</div>
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<a href=""><button type="button"
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
				
					 <div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    
			      <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title">Modal Header</h4>
			        </div>
			        <div class="modal-body">
			        
			        	<form class="form-horizontal">
			        		<div class="form-group">
								<label class="col-sm-2 control-label">Mã TSKT:</label>
								<div class="col-sm-10">
										<input type="text" id="maTSKT_modal" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Tên xe:</label>
								<div class="col-sm-10">
										<input type="text" id="tenxeKT" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Khối Lượng</label>
								<div class="col-sm-10">
										<input type="text" id="kl" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Dung tích bình xăng</label>
								<div class="col-sm-10">
										<input type="text" id="dungtichxang" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Khích thước lốp trước</label>
								<div class="col-sm-10">
										<input type="text" id="loptruoc" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Khích thước lốp sau</label>
								<div class="col-sm-10">
										<input type="text" id="lopsau" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Loại động cơ</label>
								<div class="col-sm-10">
										<input type="text" id="dongco" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Dung tích xy lanh</label>
								<div class="col-sm-10">
										<input type="text" id="xylanh" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Công suất tối đa</label>
								<div class="col-sm-10">
										<input type="text" id="toida" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Dung tích nhớt</label>
								<div class="col-sm-10">
										<input type="text" id="nhot" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Hộp số:</label>
								<div class="col-sm-10">
										<input type="text" id="hopso" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">Hệ thống khởi động</label>
								<div class="col-sm-10">
										<input type="text" id="khoidong" class="form-control">
								</div>
							</div>
			          </form>
			        </div>
			        <div class="modal-footer">
			          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
		
		<script type="text/javascript">
			function xem(){
				//document.getElementById("ten").innerHTML = "Đây là thông số kỹ thuật";
				var ma = $("#maTSKT").val();
				$.ajax({
					method:"POST",
					data:{
						ma: ma,
					},
					url : "GetKT",
					success: function(data){
						console.log("Dữ liệu lấy lên : ")
						console.log(data);
						var tskt = JSON.parse(data);
						console.log("Dữ liệu sau khi parse JSON : ")
						console.log(tskt);
						$("#myModal").modal();
						$("#maTSKT_modal").val(tskt.maSP);
						$("#tenxeKT").val(tskt.tenSP);
						$("#kl").val(tskt.kl);
						$("#dungtichxang").val(tskt.dungtichxang);
						$("#loptruoc").val(tskt.ktloptruoc);
						$("#lopsau").val(tskt.ktlopsau);
						$("#dongco").val(tskt.loaidongco);
						$("#xylanh").val(tskt.dungtichxylanh);
						$("#toida").val(tskt.congsuattoida);
						$("#nhot").val(tskt.dungtichnhotmay);
						$("#hopso").val(tskt.hopso);
						$("#khoidong").val(tskt.hethongkhoidong);
						$("#myModal").modal();
					}
				})
			}		
		</script>
		

</body>
</html>