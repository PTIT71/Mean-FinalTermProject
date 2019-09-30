package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.HoaDon;

import Model.HoaDonDAO;


/**
 * Servlet implementation class XuatHoaDon
 */
@WebServlet(name = "XuatHoaDon", urlPatterns= { "/KhachHang/XuatHoaDon" })
public class XuatHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 HoaDonDAO hoaDonDAO;
    public XuatHoaDonServlet() {
        super();
    }
    public void init() {
      	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
           String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
           String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    
           hoaDonDAO = new HoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
      }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			HoaDon hoaDon = hoaDonDAO.getHoaDon_MoiNhat();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/XuatHoaDon.jsp");
	        request.setAttribute("hd", hoaDon);
	        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
