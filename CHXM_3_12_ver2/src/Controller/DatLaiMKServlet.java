package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import com.java.*;


@WebServlet("/DatLaiMK")
public class DatLaiMKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private KhachHangDAO khachHangDAO;
	
    public DatLaiMKServlet() {
        super();
        
    }
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        khachHangDAO = new KhachHangDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String tenDN = request.getParameter("tenDangNhap");
		String email = request.getParameter("email");
		String matKhau = MD5Tool.md5(request.getParameter("matKhau"));
		KhachHang khachHang = new KhachHang(tenDN, email, matKhau);
		boolean kt;
		try {
			kt = khachHangDAO.DatLaiMK(khachHang);
			if (kt == true )
			{
				String url = request.getContextPath() + "/TrangChuAdmin.jsp";
		        response.sendRedirect(url);
			}
		} catch (SQLException e) {
			String errorMessage = "Tên đăng nhập hoặc email. Vui lòng kiểm tra lại";
			request.setAttribute("errormessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DatLaiMK.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}