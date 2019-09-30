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

@WebServlet(name = "ThemSP", urlPatterns= { "/SanPham/Them1" })
public class ThemSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO sanPhamDAO;
    public ThemSPServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String tenXe = request.getParameter("tenXe");
		String maLoai = request.getParameter("loaiXe");
		String maTSKT = request.getParameter("maTSKT");
		Float gia = Float.parseFloat(request.getParameter("giaThanh"));
		SanPham sanPham = new SanPham(tenXe, gia, maLoai, maTSKT);
		try {
			sanPhamDAO.insertSanPham(sanPham);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = request.getContextPath() + "/SanPham";
		response.sendRedirect(url);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
}