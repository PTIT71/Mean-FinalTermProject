package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import com.java.*;

@WebServlet(name = "LoadTenLoai_maTSKT_ThemSP", urlPatterns= { "/SanPham/LoadTenLoai_maTSKT" })
public class LoadTenLoai_MaTSKT_ThemSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private ThongSoKyThuatDAO thongSoKyThuatDAO;
  
    public LoadTenLoai_MaTSKT_ThemSP() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         loaiSanPhamDAO = new LoaiSanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
         thongSoKyThuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		List<LoaiSanPham> liLoaiSanPhams;
		List<ThongSoKyThuat> thongSoKyThuats;
		try {
			liLoaiSanPhams = loaiSanPhamDAO.listAllLoaiSanPham();			
			request.setAttribute("listLoaiSP", liLoaiSanPhams);
			thongSoKyThuats = thongSoKyThuatDAO.listAllTSKT();
			request.setAttribute("listTSKT", thongSoKyThuats);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ThemSanPham.jsp");
			requestDispatcher.forward(request, response);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 

}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	

}
