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

import com.java.ThongKe;

import Model.HoaDonDAO;


@WebServlet("/SanPhamDaBanServlet")
public class SanPhamDaBanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HoaDonDAO hoaDonDAO;
    public SanPhamDaBanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        hoaDonDAO = new HoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ThongKe> thongKes;
		try {
				thongKes = hoaDonDAO.SanPhamDaBan("2018-01-12", "2018-06-12");
				request.setAttribute("listSPsell", thongKes);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SanPhamBanChay.jsp");
				requestDispatcher.forward(request, response);
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngay1 = request.getParameter("ngay1");
		String ngay2 = request.getParameter("ngay2");
		List<ThongKe> thongKes;
		try {
			thongKes = hoaDonDAO.SanPhamDaBan(ngay1, ngay2);
			request.setAttribute("listSPsell", thongKes);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/SanPhamBanChay.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

}
