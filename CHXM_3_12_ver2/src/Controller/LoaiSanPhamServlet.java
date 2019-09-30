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

@WebServlet(name = "LoaiSanPham", urlPatterns= { "/LoaiSanPham" })
public class LoaiSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    public LoaiSanPhamServlet() {
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
		List<LoaiSanPham> liLoaiSanPhams;
		try {
			liLoaiSanPhams = loaiSanPhamDAO.listAllLoaiSanPham();
			request.setAttribute("listLSP", liLoaiSanPhams);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoaiSanPham.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
}
