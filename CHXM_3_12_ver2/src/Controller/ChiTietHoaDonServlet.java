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

@WebServlet(name = "ChiTietHoaDon", urlPatterns= { "/ChiTietHoaDon" })
public class ChiTietHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    public ChiTietHoaDonServlet() {
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
		List<ChiTietHoaDon> liCTHDs;
		String maHD = "" ;
		maHD = request.getParameter("maHD");
		if(maHD == null)
		{
			maHD = (String) request.getSession().getAttribute("maHD");
		}
		try {
			
			liCTHDs = chiTietHoaDonDAO.listAllCTHDs(maHD);
			request.setAttribute("listCTHD", liCTHDs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ChiTietHoaDon.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}