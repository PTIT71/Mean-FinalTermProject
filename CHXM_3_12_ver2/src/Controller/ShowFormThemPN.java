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

@WebServlet(name = "ShowFormThemPN", urlPatterns= { "/PhieuNhap/ShowFormThem" })
public class ShowFormThemPN extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO sanPhamDAO;
    public ShowFormThemPN() {
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
		List<SanPham> liSanPhams;
		try {
			liSanPhams = sanPhamDAO.listAllSanPham();			
			request.setAttribute("listSP", liSanPhams);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ThemPhieuNhap.jsp");
			requestDispatcher.forward(request, response);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 

}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	

}
