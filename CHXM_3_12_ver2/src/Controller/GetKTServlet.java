package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.LoaiSanPhamDAO;
import Model.SanPhamDAO;
import Model.ThongSoKyThuatDAO;

@WebServlet("/SanPham/GetKT")
public class GetKTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongSoKyThuatDAO thongSoKyThuatDAO;
    public GetKTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	thongSoKyThuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ma = request.getParameter("ma");
		
		PrintWriter out = response.getWriter();
		
		String tskt;
		try {
			tskt = thongSoKyThuatDAO.layTS(ma);
			out.println(tskt);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
