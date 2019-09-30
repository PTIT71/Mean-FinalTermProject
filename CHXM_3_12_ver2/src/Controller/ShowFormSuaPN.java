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

@WebServlet(name = "ShowFormSuaPN", urlPatterns= { "/PhieuNhap/ShowFormSua" })
public class ShowFormSuaPN extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhieuNhapDAO phieuNhapDAO;
    private SanPhamDAO sanPhamDAO;
    public ShowFormSuaPN() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         phieuNhapDAO = new PhieuNhapDAO(jdbcURL, jdbcUsername, jdbcPassword);
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maPNH = request.getParameter("maPNH");
        PhieuNhap existingPN;
        List<SanPham> liSanPhams;
		try {
			existingPN = phieuNhapDAO.getPhieuNhap(maPNH);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemPhieuNhap.jsp");
			 liSanPhams = sanPhamDAO.listAllSanPham();
			 request.setAttribute("listSP", liSanPhams);
		        request.setAttribute("pn", existingPN);
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
