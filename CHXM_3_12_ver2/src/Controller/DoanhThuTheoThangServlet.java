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

@WebServlet("/DoanhThuTheoThangServlet")
public class DoanhThuTheoThangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HoaDonDAO hoaDonDAO;
    public DoanhThuTheoThangServlet() {
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
				thongKes = hoaDonDAO.DoanhThuTheoThang("2018");
				request.setAttribute("listDT", thongKes);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DoanhThuTheoThang.jsp");
				requestDispatcher.forward(request, response);
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
