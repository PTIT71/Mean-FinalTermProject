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
import com.java.MD5Tool;

import Model.AdminDAO;


@WebServlet("/DatLaiMKAdminServlet")
public class DatLaiMKAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminDAO adminDAO;
   
    public DatLaiMKAdminServlet() {
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
		String matKhau = MD5Tool.md5(request.getParameter("matKhauMoi"));
		Admin admin = new Admin(tenDN, matKhau);
		boolean kt;
		try {
			kt = adminDAO.DatLaiMatKhau(admin);
			if(kt == true)
			{
				response.getWriter().append("Ä�á»•i máº­t kháº©u thÃ nh cÃ´ng ");
				String url = request.getContextPath() + "/DangNhap_Admin.jsp";
				response.sendRedirect(url);
			}
			else if(kt == false) {
				response.getWriter().append("Ä�á»•i máº­t kháº©u khÃ´ng thÃ nh cÃ´ng ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
