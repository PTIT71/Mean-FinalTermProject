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

@WebServlet(name = "DangXuat", urlPatterns= { "/KhachHang/DangXuat" })
public class DangXuat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HoaDonDAO hoaDonDAO;
    KhachHangDAO khachHangDAO;
    public DangXuat() {
        super();
        
    }
    public void init() {
   	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        hoaDonDAO = new HoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
        khachHangDAO = new KhachHangDAO(jdbcURL, jdbcUsername, jdbcPassword);
        
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String ten = request.getParameter("ten");
		String maKH;
		try {
			HoaDon hoaDon = hoaDonDAO.getHoaDon_MoiNhat();
			hoaDonDAO.HoanTatHD(hoaDon);
			
			maKH = khachHangDAO.getKhachHangTheoTenDN(ten);
			khachHangDAO.XuLyDangXuat(maKH);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mau.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
