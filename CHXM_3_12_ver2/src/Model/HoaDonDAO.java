package Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import com.java.*;


public class HoaDonDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public HoaDonDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    public boolean InsertHoaDon(HoaDon hoadon) throws SQLException {
    	String sql = "EXEC Them_HoaDon ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, hoadon.getMaKH());
    	
    	boolean rowInserted = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowInserted;
    }
    public List<HoaDon> ListAllHoaDons() throws SQLException {
    	List<HoaDon> liHoaDons = new ArrayList<HoaDon>();
    	String sql = "Select * FROM HOADON";
    	connect();
    	Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
        	String maHD = resultSet.getString("MaHD");
        	Date ngayLap = resultSet.getDate("NgayLap");
        	String maKH = resultSet.getString("maKH");
        	Float tongTien = resultSet.getFloat("TongTien");
        	DecimalFormat format = new DecimalFormat("###,###,###");
        	String tong = format.format(tongTien) + " VNĐ";
        	int daHT = resultSet.getInt("DaHoanTat");
        	Boolean trangThai = resultSet.getBoolean("TrangThai");
        	HoaDon hoaDon = new HoaDon(maHD, ngayLap, maKH, tongTien, trangThai, daHT, tong);
        	liHoaDons.add(hoaDon);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return liHoaDons;
    }
    public boolean DeleteHoaDon(HoaDon hoadon) throws SQLException {
    	String sql = "EXEC Xoa_HoaDon ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, hoadon.getMaHD());
    	boolean rowDeleted = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowDeleted;
    }
    public boolean UpdateHoaDon(HoaDon hoadon) throws SQLException {
    	String sql = "EXEC Sua_HoaDon ?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, hoadon.getMaHD());
    	statement.setString(2, hoadon.getMaKH());
    	statement.setBoolean(3, hoadon.getTrangThai());
    	boolean rowUpdated = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowUpdated;
    }
    public HoaDon getHoaDon(String maHD ) throws SQLException {
    	HoaDon hoaDon = null;
    	String sql = "Select * FROM HOADON WHERE MaHD = ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, maHD);
    	ResultSet resultSet = statement.executeQuery();
    	while(resultSet.next()) {
        	Date ngayLap = resultSet.getDate("NgayLap");
        	String maKH = resultSet.getString("maKH");
        	Float tongTien = resultSet.getFloat("TongTien");
        	int daHT = resultSet.getInt("DaHoanTat");
        	boolean trangThai = resultSet.getBoolean("TrangThai");
        	hoaDon = new HoaDon(maHD, ngayLap, maKH, tongTien, daHT, trangThai);
    	}
    	 resultSet.close();
         statement.close();
         return hoaDon;
    }
    public HoaDon getHoaDon_MoiNhat() throws SQLException {
    	HoaDon hoaDon_MoiNhat = null;
    	String sql = "SELECT * FROM HOADON";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	ResultSet resultSet = statement.executeQuery();
    	while(resultSet.next()) {
    		String maHD = resultSet.getString("MaHD");
    		Date ngayLap = resultSet.getDate("NgayLap");
        	String maKH = resultSet.getString("maKH");
        	Float tongTien = resultSet.getFloat("TongTien");
        	DecimalFormat format = new DecimalFormat("###,###,###");
        	String tong = format.format(tongTien) + " VNĐ";
        	int daHoanTat = resultSet.getInt("DaHoanTat");
        	boolean trangThai = resultSet.getBoolean("TrangThai");
        	hoaDon_MoiNhat = new HoaDon(maHD, ngayLap, maKH, tongTien, trangThai, daHoanTat, tong);
    	}
    	resultSet.close();
        statement.close();
        return hoaDon_MoiNhat;
    }
    public boolean HoanTatHD(HoaDon hoaDon) throws SQLException {
    	String sql = "EXEC HoanTatHD ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, hoaDon.getMaHD());
    	boolean rowUpdated = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowUpdated;
    }
    
    public List<ThongKe> SanPhamDaBan(String ngay1, String ngay2) throws SQLException{
    	List<ThongKe> thongKes = new ArrayList<ThongKe>();
    	SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
    	try {
    	java.util.Date start = fomat.parse(ngay1);
    	java.util.Date end = fomat.parse(ngay2);
    	
    	String sql = "EXEC ThongKeSanPhamBanTrongTuan ?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	
    	
    		statement.setDate(1,new java.sql.Date(start.getTime()));
			statement.setDate(2,new java.sql.Date(end.getTime()));
    	
    	ResultSet resultSet = statement.executeQuery();
    	while(resultSet.next()) {
    		String maSP = resultSet.getString("MaSP");
        	String tenSP = resultSet.getString("TenSP");
        	int soLuong = resultSet.getInt("SoLuong");
        	ThongKe thongKe = new ThongKe(maSP, tenSP, soLuong);
        	thongKes.add(thongKe);
    	}
    	resultSet.close();
    	statement.close();
    	return thongKes;
    	} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public List<ThongKe> DoanhThuTheoThang(String nam) throws SQLException{
    	List<ThongKe> thongKes = new ArrayList<ThongKe>();
    
    	String sql = "EXEC dbo.ThongKeDoanhThuTheoThang ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1,nam);
		
	
    	ResultSet resultSet = statement.executeQuery();
    	while(resultSet.next()) {
    		int thang = resultSet.getInt("Thang");
        	Float tongTien = resultSet.getFloat("TongTien");

        	ThongKe thongKe = new ThongKe(thang, tongTien);
        	thongKes.add(thongKe);
    	}
    	resultSet.close();
    	statement.close();
    	return thongKes;
    }
    
    public static void main(String[] args) {
    	HoaDonDAO hoaDonDAO = new HoaDonDAO("jdbc:sqlserver://localhost:1433;databaseName=Web_CuaHangXeMay", "liem1230", "123456");
 
    	try {
			List<ThongKe> thongKes = hoaDonDAO.DoanhThuTheoThang("2018");
			for (ThongKe thongKe : thongKes) {
				System.out.println(thongKe.getThang() +"....."+ thongKe.getTongTien());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
