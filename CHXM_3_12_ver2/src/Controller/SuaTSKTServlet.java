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

@WebServlet(name = "SuaTSKT", urlPatterns= { "/ThongSoKyThuat/Sua" })
public class SuaTSKTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongSoKyThuatDAO thongSoKyThuatDAO;
    public SuaTSKTServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         thongSoKyThuatDAO = new ThongSoKyThuatDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String tenXe = request.getParameter("tenXe");
        String khoiluong = request.getParameter("khoiLuong");
        String dungTichBinhXang = request.getParameter("dungTichBinhXang");
        String ktLopTruoc = request.getParameter("ktLopTruoc");
        String ktLopSau = request.getParameter("ktLopSau");
        String loaiDongCo = request.getParameter("loaiDongCo");
        String dungTichXiLanh = request.getParameter("dungTichXiLanh");
        String congSuatToiDa = request.getParameter("congSuatToiDa");
        String dungTichNhotMay = request.getParameter("dungTichNhotMay");
        String hopSo= request.getParameter("hopSo");
        String heThongKhoiDong= request.getParameter("heThongKhoiDong");
        String maTSKT = request.getParameter("maTSKT");
        ThongSoKyThuat thongSoKyThuat = new ThongSoKyThuat(maTSKT, tenXe, khoiluong, dungTichBinhXang, ktLopTruoc, ktLopSau, loaiDongCo,
        		dungTichXiLanh, congSuatToiDa, dungTichNhotMay, hopSo, heThongKhoiDong);
        try {
			thongSoKyThuatDAO.updateTSKT(thongSoKyThuat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String url = request.getContextPath() + "/ThongSoKyThuat";
        response.sendRedirect(url);
	      
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
