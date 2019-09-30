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

@WebServlet(name = "XoaLoaiSanPham", urlPatterns= { "/LoaiSanPham/Xoa" })
public class XoaLoaiSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    public XoaLoaiSanPhamServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         loaiSanPhamDAO = new LoaiSanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maLoai = request.getParameter("maLoai");
		
    	LoaiSanPham loaisanpham = new LoaiSanPham(maLoai, "NULL");
        try {
			loaiSanPhamDAO.deleteLoaiSP(loaisanpham);
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
