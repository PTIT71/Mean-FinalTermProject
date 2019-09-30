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

@WebServlet(name = "SuaPN", urlPatterns= { "/PhieuNhap/Sua" })
public class SuaPhieuNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PhieuNhapDAO phieuNhapDAO;
    public SuaPhieuNhapServlet() {
		// TODO Auto-generated constructor stub
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         phieuNhapDAO = new PhieuNhapDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maPNH = request.getParameter("maPNH");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        String maSP = request.getParameter("maSP");
		Float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
		PhieuNhap phieuNhap = new PhieuNhap(maPNH, soLuong, maSP, giaNhap);
		try {
			phieuNhapDAO.updatePhieuNhap(phieuNhap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = request.getContextPath() + "/PhieuNhap";
        response.sendRedirect(url);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	

}
