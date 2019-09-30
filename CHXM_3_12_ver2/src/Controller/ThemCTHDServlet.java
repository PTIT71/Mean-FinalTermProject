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

@WebServlet(name = "ThemCTHD", urlPatterns= { "/ChiTietHoaDon/Them" })
public class ThemCTHDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    public ThemCTHDServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
         chiTietHoaDonDAO = new ChiTietHoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String maCTHD = request.getParameter("maCTHD");
		String maHD = request.getParameter("maHD");
		String maSP = request.getParameter("maSP");
		int soLuong =  Integer.parseInt(request.getParameter("soLuong"));
		Float donGia = Float.parseFloat(request.getParameter("donGia"));
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maCTHD, maHD, maSP, soLuong, donGia);
        try {
			chiTietHoaDonDAO.UpdateCTHD(chiTietHoaDon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("maHD",maHD );
        String url = request.getContextPath() + "/ChiTietHoaDon";
        response.sendRedirect(url);
	      
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
