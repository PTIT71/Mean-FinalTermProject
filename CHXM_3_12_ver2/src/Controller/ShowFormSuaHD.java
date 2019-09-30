package Controller;

import java.io.IOException;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import com.java.*;

@WebServlet(name = "ShowFormSuaHoaDon", urlPatterns= { "/HoaDon/ShowFormSua" })
public class ShowFormSuaHD extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HoaDonDAO hoaDonDAO;
    public ShowFormSuaHD() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         hoaDonDAO = new HoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maHD = request.getParameter("maHD");
        HoaDon existingHD;
		try {
			existingHD = hoaDonDAO.getHoaDon(maHD);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/SuaHoaDon.jsp");
		        request.setAttribute("hd", existingHD);
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
