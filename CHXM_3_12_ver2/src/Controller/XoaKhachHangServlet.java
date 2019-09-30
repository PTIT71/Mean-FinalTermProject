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

@WebServlet(name = "XoaKhachHang", urlPatterns= { "/KhachHang/Delete" })
public class XoaKhachHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private KhachHangDAO KhachHangDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        KhachHangDAO = new KhachHangDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String maKH = request.getParameter("maKH");
    	 
        KhachHang khachhang = new KhachHang(maKH);
        try {
			KhachHangDAO.deleteKhachHang(khachhang);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/KhachHang";
        response.sendRedirect(url);
    	
    	
    }
 
    
}
