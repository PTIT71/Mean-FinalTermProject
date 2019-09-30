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

@WebServlet(name = "ShowFormSuaSP", urlPatterns= { "/SanPham/ShowFormSua" })
public class ShowFormSuaSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO sanPhamDAO;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    private ThongSoKyThuatDAO thongSoKyThuatDAO;

    public ShowFormSuaSP() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
         loaiSanPhamDAO = new LoaiSanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
         thongSoKyThuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maSP = request.getParameter("maSP");
        SanPham existingSP;
        List<LoaiSanPham> liLoaiSanPhams;
		List<ThongSoKyThuat> thongSoKyThuats;
		try {
			liLoaiSanPhams = loaiSanPhamDAO.listAllLoaiSanPham();			
			request.setAttribute("listLoaiSP", liLoaiSanPhams);
			thongSoKyThuats = thongSoKyThuatDAO.listAllTSKT();
			request.setAttribute("listTSKT", thongSoKyThuats);
			existingSP = sanPhamDAO.getSP(maSP);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemSanPham.jsp");
		        request.setAttribute("sp", existingSP);
		        dispatcher.forward(request, response);
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	

}
