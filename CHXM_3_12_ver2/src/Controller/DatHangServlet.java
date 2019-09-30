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

@WebServlet(name = "KH_DatHang", urlPatterns= { "/DatHang" })
public class DatHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HoaDonDAO hoaDonDAO;
    private KhachHangDAO khachHangDAO;
    private ChiTietHoaDonDAO chiTietHoaDonDAO;
    private SanPhamDAO sanPhamDAO;
    public DatHangServlet() {
    	super();
    }
    
    public void init() {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
  
         hoaDonDAO = new HoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
         khachHangDAO = new KhachHangDAO(jdbcURL, jdbcUsername, jdbcPassword);
         chiTietHoaDonDAO = new ChiTietHoaDonDAO(jdbcURL, jdbcUsername, jdbcPassword);
         sanPhamDAO = new SanPhamDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		request.setCharacterEncoding("utf-8"); 
		String ten = request.getParameter("ten");
		String maSP = request.getParameter("maSP");
		int sl = Integer.parseInt(request.getParameter("soLuong"));
		String maKH;
		String maHD = "1";
		HoaDon hd_MoiNhat1 = null;
		HoaDon hd_MoiNhat2 = null;
		try {
			hd_MoiNhat1 = hoaDonDAO.getHoaDon_MoiNhat();
			//String maKH_HD_MoiNhat = hd_MoiNhat1.getMaKH();
			//maKH = khachHangDAO.getKhachHangTheoTenDN(ten);
			/*Date ngay_HD_MoiNhat = hd_MoiNhat1.getNgayLap();
			java.util.Date time_hientai = new java.util.Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String ngay_hientai = format.format(time_hientai);
			String ngay_HD_moinhat = format.format(ngay_HD_MoiNhat);*/
			int daHT = hd_MoiNhat1.getDaHoanTat();
			maKH = khachHangDAO.getKhachHangTheoTenDN(ten);
			if( daHT == 1) //!maKH_HD_MoiNhat.equals(maKH) || !ngay_HD_moinhat.equals(ngay_hientai)
			{
				//thêm hóa đơn
				HoaDon hoaDon = new HoaDon(maHD, maKH);
				hoaDonDAO.InsertHoaDon(hoaDon);
			}
			//thêm chi tiết hóa đơn
			hd_MoiNhat2 = hoaDonDAO.getHoaDon_MoiNhat();
			String maHD_MoiNhat = hd_MoiNhat2.getMaHD();
			SanPham sPham = sanPhamDAO.getSP(maSP);
			Float donGia = sPham.getGiaThanh();
			ChiTietHoaDon CTHD = new ChiTietHoaDon(maHD_MoiNhat, maSP, sl, donGia);
			chiTietHoaDonDAO.InsertCTHD(CTHD);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String url = request.getContextPath() + "/ShowFormDatHang";
		response.sendRedirect(url);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}