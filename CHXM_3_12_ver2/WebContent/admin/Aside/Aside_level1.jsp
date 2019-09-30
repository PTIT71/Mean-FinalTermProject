<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="home" value="/" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">CÁC CHỨC NĂNG CHÍNH</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i><span>Danh mục sản phẩm</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${home }LoaiSanPham"><i class="fa fa-arrows"></i> Loại sản phẩm</a></li>
            <li><a href="${home }SanPham"><i class="fa fa-motorcycle"></i> Sản phẩm</a></li>
            <li><a href="${home }ThongSoKyThuat"><i class="fa fa-gears"></i> Thông số kỹ thuật</a></li>
            <li><a href="${home }PhieuNhap"><i class="fa fa-wpforms"></i> Nhập hàng</a>
        </li>
          </ul>
        </li>
        <li>
          <a href="${home }HoaDon">
            <i class="fa fa-files-o"></i><span>Hóa đơn</span>
          </a>
        </li>
        <li>
          <a href="${home }KhachHang">
            <i class="fa fa-th"></i> <span>Khách hàng</span>
          </a>
        </li>
        <li>
          <a href="${home }TinTuc">
            <i class="fa fa-th"></i> <span>Tin tức</span>
          </a>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i><span>Thống kê</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${home }DoanhThuTheoThangServlet"><i class="fa fa-bar-chart-o"></i> Doanh thu</a></li>
            <li><a href="${home }SanPhamDaBanServlet"><i class="fa fa-line-chart"></i> Sản phẩm bán chạy</a></li>
            <li><a href="${home }SanPhamTonServlet"><i class="fa fa-area-chart"></i> Sản phẩm tồn</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</body>
</html>