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

@WebServlet(name = "XoaTSKT", urlPatterns= { "/ThongSoKyThuat/Xoa" })
public class XoaTSKTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongSoKyThuatDAO thongsokythuatDAO;
    public XoaTSKTServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         thongsokythuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maTSKT = request.getParameter("maTSKT");
		
    	ThongSoKyThuat tsKyThuat = new ThongSoKyThuat(maTSKT);
        try {
			thongsokythuatDAO.deleteTSKT(tsKyThuat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/ThongSoKyThuat";
        response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
