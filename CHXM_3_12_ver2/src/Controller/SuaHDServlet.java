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

@WebServlet(name = "SuaHoaDon", urlPatterns= { "/HoaDon/Sua" })
public class SuaHDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HoaDonDAO hoaDonDAO;
    public SuaHDServlet() {
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
		String maKH = request.getParameter("maKH");
		boolean trangThai = Boolean.parseBoolean( request.getParameter("trangThai"));
        HoaDon hoaDon = new HoaDon(maHD, maKH, trangThai);
        try {
			hoaDonDAO.UpdateHoaDon(hoaDon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/HoaDon";
        response.sendRedirect(url);
	      
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
