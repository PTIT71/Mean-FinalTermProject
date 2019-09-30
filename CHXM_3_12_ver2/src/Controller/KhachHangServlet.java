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

@WebServlet(name = "KhachHang", urlPatterns= { "/KhachHang" })
public class KhachHangServlet extends HttpServlet {
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
    	response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
    	List<KhachHang> listKhachHang;
		try {
			listKhachHang = KhachHangDAO.listAllKhachHangs();
	        request.setAttribute("listKhachHang", listKhachHang);
		} catch (SQLException e) {
		
			e.printStackTrace();
			request.setAttribute("loi", e.toString());
		}
    	
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/KhachHangList.jsp");
    	dispatcher.forward(request, response);
    }
 
    
}
