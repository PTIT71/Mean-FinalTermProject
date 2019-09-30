package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.Admin;

import Model.AdminDAO;

@WebServlet(name = "ADDangXuat", urlPatterns= { "/Admin/DangXuat" })
public class DangXuatAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminDAO adminDAO;
    public DangXuatAdmin() {
        super();
    }
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        adminDAO = new AdminDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDN = request.getParameter("tenAD");
		Admin admin = new Admin(tenDN);
		boolean kt;
		try {
			kt = adminDAO.DangXuat(admin);
			if(kt == true) {
				String url = request.getContextPath() + "/mau.jsp";
				response.sendRedirect(url);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
