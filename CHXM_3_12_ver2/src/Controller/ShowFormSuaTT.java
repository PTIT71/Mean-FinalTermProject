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

@WebServlet(name = "ShowFormSuaTinTuc", urlPatterns= { "/TinTuc/ShowFormSua" })
public class ShowFormSuaTT extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TinTucDAO tinTucDAO;
    public ShowFormSuaTT() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         tinTucDAO = new TinTucDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maTin = request.getParameter("maTin");
        TinTuc existingTT;
		try {
			 existingTT = tinTucDAO.getTinTuc(maTin);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemTinTuc.jsp");
		        request.setAttribute("tt", existingTT);
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
