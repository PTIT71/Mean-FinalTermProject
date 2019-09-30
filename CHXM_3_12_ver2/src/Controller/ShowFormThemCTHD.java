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

@WebServlet(name = "ShowFormThemCTHD", urlPatterns= { "/ChiTietHoaDon/ShowFormThem" })
public class ShowFormThemCTHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private SanPhamDAO sanPhamDAO;
    public ShowFormThemCTHD() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         chiTietHoaDonDAO = new ChiTietHoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maHD = request.getParameter("maHD");
		String maSP = "maxe003";
		int sl = 0;
		float dongia = 0;
		List<SanPham> liSanPhams;
        ChiTietHoaDon newCTHD = new ChiTietHoaDon(maHD, maSP, sl, dongia);
        ChiTietHoaDon CTHD_MoiNhat = null;
		try {
			 chiTietHoaDonDAO.InsertCTHD(newCTHD);
			 CTHD_MoiNhat = chiTietHoaDonDAO.getCTHD_MoiNhat();
			 liSanPhams = sanPhamDAO.listAllSanPham();
			 request.setAttribute("listSP", liSanPhams);
		        request.setAttribute("cthd", CTHD_MoiNhat);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemCTHD.jsp");
		        dispatcher.forward(request, response);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
}
