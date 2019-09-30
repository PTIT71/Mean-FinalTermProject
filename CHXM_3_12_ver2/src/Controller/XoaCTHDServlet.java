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

@WebServlet(name = "XoaCTHD", urlPatterns= { "/CTHD/Xoa" })
public class XoaCTHDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    public XoaCTHDServlet() {
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
		String maCTHD = request.getParameter("maCTHD");
		String maHD = request.getParameter("maHD");
    	ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maCTHD);
        try {
			chiTietHoaDonDAO.DeleteCTHD(chiTietHoaDon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.getSession().setAttribute("maHD", maHD);
        String url = request.getContextPath() + "/ChiTietHoaDon";
        response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	

}