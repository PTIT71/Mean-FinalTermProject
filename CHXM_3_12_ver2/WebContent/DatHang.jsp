 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html lang="zxx">
   <head>
      <title>Đặt hàng</title>
      <!--meta tags -->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="keywords" content="" />
      <!--//meta tags ends here-->
      <!--booststrap-->
      <link href="guest_user/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
      <!--//booststrap end-->
      <!-- font-awesome icons -->
      <link href="guest_user/css/fontawesome-all.min.css" rel="stylesheet" type="text/css" media="all">
      <!-- //font-awesome icons -->
      <!-- For Clients slider -->
      <link rel="stylesheet" href="guest_user/css/flexslider.css" type="text/css" media="all" />
      <!--flexs slider-->
      <link href="guest_user/css/JiSlider.css" rel="stylesheet">
      <!--Shoping cart-->
      <!-- <link rel="stylesheet" href="guest_user/css/shop.css" type="text/css" />
 -->      <!--//Shoping cart-->
      <!--stylesheets-->
      <link href="guest_user/css/style.css" rel='stylesheet' type='text/css' media="all">
      <link href="guest_user/css/login.css" rel='stylesheet' type='text/css' media="all">
      <link href="guest_user/css/background_dong.css" rel='stylesheet' type='text/css' media="all">
      <!--//stylesheets-->
      <link href="//fonts.googleapis.com/css?family=Sunflower:500,700" rel="stylesheet">
      <link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet">
      <script type="text/javascript" src="guest_user/assests/js/jquery-3.3.1.min.js"></script>
	 <script type="text/javascript" src="guest_user/js/kiemtradangnhap.js"></script> 
    <script type="text/javascript"> 
        function validateForm() {
        	$("#myModal").modal();
            var sp =  $("#inputTenSP").val();
            var sl = $("#inputSL").val();
            if (sp == "") {
                $("#validate-tenSP").html("Vui lòng nhập tên sản phẩm")
            }
            if(sl == "")
                {
                    $("#validate-sl").html("Vui lòng nhập số lượng sản phẩm")
                }
                
            if(sp=="" | sl==""){
                return false;
            }
        return true;
    }
</script>
   </head>
   <body>   
	<!-- //main-->
	<h2>FORM ĐẶT HÀNG</h2>
	<div class="row" id="particle-container">
	<div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
    <div class="particle"></div>
	<div class="col-lg-2 col-md-2"></div>
	<div class="col-lg-8 col-md-8">
		<form action="DatHang" method="Post">
		
		  <div class="container">
		  	<label>Tên đăng nhập</label>
		  	<input type="text" value='${ten}' name="ten" /><br>
		    <label class="col-sm-3 control-label">Tên xe</label>
             <select id="inputTenSP" name="maSP"  
			class="form-control select2 select2-hidden-accessible"
			style="width: 65%;" tabindex="-1" aria-hidden="true">
			<c:forEach items="${listSP}" var="sp"> 
  			<option value="${sp.maSP }"><c:out value="${sp.tenSP },          Đơn giá: ${sp.gia}"></c:out></option>
			</c:forEach>
			</select> <br>
            <small class="text-danger" id="validate-tenSP"></small><br>
		    <label for="exampleInputSL"><b>Số lượng</b></label>
		    <input type="text" placeholder="Nhập số lượng" name="soLuong" id="inputSL"> 
		    <small class="text-danger" id="validate-sl"></small>
                <small  class="form-text text-muted" style="color : red"> Vui lòng nhập số lượng vào đây</small>
            
		  </div>
		  <div class="container" style="background-color:#f1f1f1" >
			  <button type="submit" onclick="return validateForm();">Xác nhận </button>
		  </div>
			  <div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Tiếp tục đặt hàng</h4>
				      </div>
				      <div class="modal-body">
				        <p>Bạn có muốn đặt hàng tiếp không?</p>
				      </div>
				      <div class="modal-footer">
				        
				        <button type="button" class="btn btn-default" data-dismiss="modal">Có</button>
				      </div>
				    </div>
				
				  </div>
		  </div>
		   <a href="KhachHang/XuatHoaDon"><button type="button">Hoàn tất</button></a>
		</form>
	</div>
	<div class="col-lg-2 col-md-2"></div>
	
      <!-- footer -->
      	<footer>
      		<jsp:include page="guest_user/footer/footerlevel1.jsp"></jsp:include>
      	</footer>
      <!-- //Modal 1-->
     
   </body>
</html>