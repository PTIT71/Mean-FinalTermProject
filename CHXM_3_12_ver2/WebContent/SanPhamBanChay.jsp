<%@page import="com.java.ThongKe"%>
<%@page import="java.util.List" %>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Bán chạy</title>
<metacontent ="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no "name="viewport"> <!-- Bootstrap 3.3.7 -->
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
	<script>
	
	window.onload = function () {

	    var chart = new CanvasJS.Chart("BieuDoSPBanChay", {
	        theme: "light2",
	        animationEnabled: true,
	        title: {
	            text: "Thong ke san đã bán trong tuần"
	        },
	        subtitles: [{
	            text: "Tp HCM, 2018",
	            fontSize: 16
	        }],
	        data: [{
	            type: "pie",
	            indexLabelFontSize: 18,
	            radius: 80,
	            indexLabel: "{label} - {y}",
	            yValueFormatString: "###0.0\"\"",
	            click: explodePie,
	            dataPoints: [
	                /* { y: 10, label: "Ex" },
	                { y: 21, label: "Win"},
	                { y: 20, label: "SH" },
	                { y: 9, label: "Wave" },
	                { y: 12, label: "AB" } */
	            	<%
	         		List<ThongKe> list = (List<ThongKe>) request.getAttribute("listSPsell");
	                for (ThongKe item : list) {
	                	out.println(String.format("{ y:%d, label: \"%s\" },", item.getSoLuong(), item.getTenSP()));
	                }
	         		%>
	            ]
	        }]
	    });
	    chart.render();
	    
	    function explodePie(e) {
	        for(var i = 0; i < e.dataSeries.dataPoints.length; i++) {
	            if(i !== e.dataPointIndex)
	                e.dataSeries.dataPoints[i].exploded = false;
	        }
	    }
	     
	    }
	</script>
	
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
					<li>Sản phẩm bán chạy</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
				<form action="SanPhamDaBanServlet" method="post">
				<input type="date" name="ngay1" >
				<input type="date" name="ngay2">
				
				<button type="submit"> Load </button>
				</form>
				</div>
				 <div class="row">
                <div id="BieuDoSPBanChay" style="height: 370px; width: 100%;">
        </div>
        <div class="row">
            <div class="box">
                <div class="box-header text-center" style="color: red">
						<h3>Số lượng đã bán</h3>
					</div>
                <div class="box-body">
                        <table class="table table-hover table-striped">
                                <thead>
                                <th></th>
                                <c:forEach items="${listSPsell}" var="sp">
                                    
                                    <th><c:out value="${sp.tenSP}"></c:out></th>
 
                                </c:forEach>
                                </thead>
                                <tbody>
                                    <th>Tống bán</th>
                                
                                 <c:forEach items="${listSPsell}" var="sp">
                                    
                                    <td><c:out value="${sp.soLuong}"></c:out></td>
 
                                </c:forEach>
                                </tbody>
                            </table>
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