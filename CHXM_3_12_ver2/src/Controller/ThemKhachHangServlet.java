package Controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import com.java.*;

@WebServlet(name = "ThemKhachHang", urlPatterns= { "/KhachHang/Them" })
public class ThemKhachHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KhachHangDAO KhachHangDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        KhachHangDAO = new KhachHangDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
    	String hoTen = request.getParameter("hoTen");
        String cmnd = request.getParameter("soCMND");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("soDT");
        String tenDN = request.getParameter("tenDangNhap");
        String matKhau = MD5Tool.md5(request.getParameter("matKhau"));
        KhachHang newkhachhang = new KhachHang(hoTen, cmnd, email, diaChi, sdt, tenDN, matKhau);
        try {
			KhachHangDAO.insertKhachHang(newkhachhang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/KhachHang";
        response.sendRedirect(url);
    }
 
  
}
