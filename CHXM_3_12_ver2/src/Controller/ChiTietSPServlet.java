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

@WebServlet(name = "LoadChiTietSP", urlPatterns= { "/ChiTietSP/TSKT" })
public class ChiTietSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongSoKyThuatDAO thongSoKyThuatDAO;
    public ChiTietSPServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         thongSoKyThuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maTSKT = request.getParameter("maTSKT");
		//String maTSKT = "MaKT001";
        ThongSoKyThuat existingTSKT;
		try {
			existingTSKT = thongSoKyThuatDAO.getTSKT(maTSKT);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ChiTietSP.jsp");
		        request.setAttribute("tskt", existingTSKT);
		        dispatcher.forward(request, response);
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
