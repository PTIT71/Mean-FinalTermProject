<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Phiếu nhập</title>
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
					<li>Phiếu nhập hàng</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			
				<div class="row">
          <div class="col-xs-2"></div>
          <div class="col-xs-8">
            <div class="box">
              <div class="box-header text-center" style="color: red">
						<h3>Phiếu nhập hàng</h3>
					</div>
				<c:if test="${pn != null}">
					<h4>Không cần nhập ngày, mã phiếu</h4>
				</c:if>
              <div class="box-body">
            	<c:if test="${pn == null}">
                <form action="Them" method="post" class="form-horizontal" id="Them_SP">
				</c:if>
				<c:if test="${pn != null}">
				<form action="Sua" method="post" class="form-horizontal" id="Sua_SP">
				</c:if>
        
                  <div class="box-body">
                    <div class="form-group">
                      <label class="col-sm-2 control-label">Mã phiếu:</label>
                      <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Mã" id="maphieu" name="maPNH"
                        	value="<c:out value='${pn.maPNH}' />">
                        <small id="txtmaphieu" style="color: red"></small>
                      </div>
                    </div>
                     <div class="form-group">
                      <label class="col-sm-2 control-label">Ngày nhập:</label>
                      <div class="col-sm-10">
                        <div class="input-group">
                          <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                          </div>
                          <input type="date" class="form-control" id="ngaynhap" placeholder="dd/mm/yyyy" name="ngayNhap"
                          	value="<c:out value='${pn.thoiGian}' />">
                          <small id="txtngaynhap" style="color: red"></small>
                        </div>
                      </div>
                      <script>document.querySelector("#ngaynhap").valueAsDate = new Date();</script>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label">Số lượng:</label>
                      <div class="col-sm-10">
                        <input type="number" class="form-control" placeholder="Số lượng" id="soluong" name="soLuong"
                        	value="<c:out value='${pn.soLuong}' />">
                        <small id="txtsoluong" style="color: red"></small>
                      </div>
                    </div>
                    <div class="form-group">
                     <label class="col-sm-3 control-label">Tên xe</label>
	                      <select id="maxe" name="maSP"  
							class="form-control select2 select2-hidden-accessible"
							style="width: 65%;" tabindex="-1" aria-hidden="true">
							<c:forEach items="${listSP}" var="sp"> 
							
							<option value="${sp.maSP}"><c:out value="${sp.tenSP }"></c:out></option>
							
							</c:forEach>
						</select> </br>
                        <small id="txttenxe" style="color: red"></small>
                      </div>

                    </div>
                   
                    <div class="form-group">
                      <label class="col-sm-2 control-label">Giá nhập:</label>
                      <div class="col-sm-9">
                        <input type="number" class="form-control" placeholder="Giá tiền" id="gianhap" name="giaNhap"
                        	value="<c:out value='${pn.giaNhap}' />">
                        <small id="txtgianhap" style="color: red"></small>
                      </div>
                      <div class="col-sm-1">
                        <label class="control-label">.VNĐ</label>
                      </div>
                    </div>
                    
                  </div>
                  <!-- /.box-body -->
                  <div class="box-footer">
                    <a href="SanPham.jsp"><button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i>
                        Hủy bỏ</button></a>
                    <button type="submit" onclick="return KiemTraPhieu();" class="btn btn-info pull-right"><i class="fa fa-save"></i>
                      Hoàn tất</button>
                  </div>
                  <!-- /.box-footer -->
                </form>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xs-2"></div>
        </div>
			
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<div>
			<jsp:include page="admin/footer/footer_level1.jsp"></jsp:include>
		</div>
		
		<script>
      function KiemTraMaPhieu() {
        var x = document.getElementById("maphieu").value;
        var y = String(x).length;

        if (x == "") {
          $('#txtmaphieu').html("Bạn phải nhập mã phiếu");
          return false
        }
        else if (y > 5) {
          $('#txtmaphieu').html("Bạn không được nhập mã nhiều hơn 5 ký tự");
          return false
        }
        else {
          $('#txtmaphieu').html("");
          return true
        }

      }
      function KiemTraPhieu() {
        if (KiemTraMaPhieu() == false | KiemTraTenXe() == false | KiemTraDonGia() == false | KiemTraSoLuong() == false)
          return false
        else
          return true
      }
      function KiemTraTenXe() {
        var x = document.getElementById("tenxe").value;
        if (x == "") {
          $('#txttenxe').html("Bạn không được bỏ trống tên xe");
          return false;
        }
        else {
          $('#txttenxe').html("");
          return true;
        }
      }
      function KiemTraDonGia() {
        var x = document.getElementById("gianhap").value;

        if (x == "") {
          $('#txtgianhap').html("Bạn không được bỏ trống đơn giá");
          return false;
        }
        else if (x <= 0) {
          $('#txtgianhap').html("Giá tiền không hợp lệ");
          return false;
        }
        else {
          $('#txtgianhap').html("");
          return true;
        }
      }
      function KiemTraSoLuong() {
        var x = document.getElementById("soluong").value;

        if (x == "") {
          $('#txtsoluong').html("Bạn không được bỏ trống số lượng");
          return false;
        }
        else if (x <= 0) {
          $('#txtsoluong').html("Số lượng không hợp lệ");
          return false;
        }
        else {
          $('#txtsoluong').html("");
          return true;
        }
      }
    </script>
</body>
</html>