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

@WebServlet("/KiemTraDangNhap_Admin")
public class KiemTraDangNhap_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminDAO adminDAO;
    public KiemTraDangNhap_Admin() {
        super();
    }
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        adminDAO = new AdminDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String tenDN = request.getParameter("tenDangNhap");
		String matKhau = MD5Tool.md5(request.getParameter("matKhau"));
		Admin admin = new Admin(tenDN, matKhau);
		request.getSession().setAttribute("tenAD", tenDN);
		boolean kt;
		try {
			kt = adminDAO.ktDangNhap(admin);
			if (kt == true )
			{
				String url = request.getContextPath() + "/TrangChuAdmin.jsp";
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
