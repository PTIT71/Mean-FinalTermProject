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

import com.java.SanPham;

import Model.SanPhamDAO;



@WebServlet("/SanPhamTonServlet")
public class SanPhamTonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SanPhamDAO sanPhamDAO;

    public SanPhamTonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		try {					
			List<SanPham> list = sanPhamDAO.listAllSanPham();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SanPhamTon.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
