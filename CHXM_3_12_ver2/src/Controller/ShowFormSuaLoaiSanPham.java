package Controller;

import java.io.IOException;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import com.java.*;

@WebServlet(name = "ShowFormSuaLoaiSanPham", urlPatterns= { "/LoaiSanPham/ShowFormSua" })
public class ShowFormSuaLoaiSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoaiSanPhamDAO loaiSanPhamDAO;
    public ShowFormSuaLoaiSanPham() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         loaiSanPhamDAO = new LoaiSanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		String maLoai = request.getParameter("maLoai");
        LoaiSanPham existingLSP;
		try {
			existingLSP = loaiSanPhamDAO.getLoaiSP(maLoai);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemLoaiSanPham.jsp");
		        request.setAttribute("lsp", existingLSP);
		        dispatcher.forward(request, response);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
}
