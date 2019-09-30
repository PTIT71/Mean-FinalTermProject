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

@WebServlet(name = "ThemLoaiSanPham", urlPatterns= { "/LoaiSanPham/Them" })
public class ThemLoaiSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    public ThemLoaiSanPhamServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         loaiSanPhamDAO = new LoaiSanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String maloai = request.getParameter("maLoai");
		String tenloai = request.getParameter("tenLoai");
		
		LoaiSanPham loaiSanPham = new LoaiSanPham(maloai, tenloai);
		try {
			loaiSanPhamDAO.insertLSP(loaiSanPham);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = request.getContextPath() + "/LoaiSanPham";
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
