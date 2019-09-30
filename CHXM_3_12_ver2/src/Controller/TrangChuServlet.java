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


@WebServlet("/TrangChuServlet")
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SanPhamDAO sanPhamDAO;

    public TrangChuServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			List<SanPham> sanPhams = sanPhamDAO.listAllSanPham();
			request.setAttribute("listSP", sanPhams);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/mau.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public static void main(String[] args) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO("jdbc:sqlserver://localhost:1433;databaseName=Web_CuaHangXeMay","liem1230","123456");
		try {
			List<SanPham> sanPhams = sanPhamDAO.listAllSanPham();
			for (SanPham sanPham : sanPhams) {
				System.out.println(sanPham.getHinhAnh()+ "_" + sanPham.getTenSP());			
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
