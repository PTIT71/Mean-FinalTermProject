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

import Model.PhanLoaiXeDAO;

@WebServlet("/LoadXe4080Servlet")
public class LoadXe4080Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoadXe4080Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private PhanLoaiXeDAO phanLoaiXeDAO;
    public void init() {
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	phanLoaiXeDAO = new PhanLoaiXeDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		try {
			List<SanPham> sanPhams = phanLoaiXeDAO.listAllXe40tr80tr();
			request.setAttribute("listSP", sanPhams);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DanhMuc40_80.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
