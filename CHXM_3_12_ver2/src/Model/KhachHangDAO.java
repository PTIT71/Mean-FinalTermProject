package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.*;

public class KhachHangDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public KhachHangDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
     
    public boolean insertKhachHang(KhachHang khachhang) throws SQLException {
        String sql = "EXEC Them_KH ?,?,?,?,?,?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, khachhang.getHoTen());
        statement.setString(2, khachhang.getsoCMND());
        statement.setString(3, khachhang.getEmail());
        statement.setString(4, khachhang.getDiaChi());
        statement.setString(5, khachhang.getsoDT());
        statement.setString(6, khachhang.getTenDangNhap());
        statement.setString(7, khachhang.getMatKhau());
       
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
     
    public List<KhachHang> listAllKhachHangs() throws SQLException {
        List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
         
        String sql = "SELECT * FROM KHACHHANG WHERE TrangThai = 0";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String maKH = resultSet.getString("MaKH");
            String hoTen = resultSet.getString("HoTen");
            String cmnd = resultSet.getString("CMND");
            String email = resultSet.getString("Email");
            String diaChi = resultSet.getString("DiaChi");
            String sdt = resultSet.getString("SDT");
            String tenDN = resultSet.getString("TenDangNhap");
            String matKhau = resultSet.getString("MatKhau");
            KhachHang khachhang = new KhachHang(maKH, hoTen, cmnd, email, diaChi, sdt, tenDN, matKhau);
            listKhachHang.add(khachhang);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listKhachHang;
    }
     
    public boolean deleteKhachHang(KhachHang khachhang) throws SQLException {
        String sql = "EXEC Xoa_KH ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, khachhang.getMaKH());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateKhachHang(KhachHang khachhang) throws SQLException {
        String sql = "EXEC Sua_KH ?,?,?,?,?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, khachhang.getMaKH());
        statement.setString(2, khachhang.getHoTen());
        statement.setString(3, khachhang.getsoCMND());
        statement.setString(4, khachhang.getEmail());
        statement.setString(5, khachhang.getDiaChi());
        statement.setString(6, khachhang.getsoDT());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public boolean ktDangNhap(KhachHang khachHang) throws SQLException {
    	String sql = "EXEC ktDangNhap_KH ?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, khachHang.getTenDangNhap());
    	statement.setString(2, khachHang.getMatKhau());
    	boolean rowKiemTra = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowKiemTra;
    }
    public boolean DatLaiMK(KhachHang khachHang) throws SQLException {
    	String sql = "EXEC DoiMK_KH ?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, khachHang.getTenDangNhap());
    	statement.setString(2, khachHang.getEmail());
    	statement.setString(3, khachHang.getMatKhau());
    	boolean kt = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return kt;
    }
    public KhachHang getKhachHang(String maKH) throws SQLException {
        KhachHang khachhang = null;
        String sql = "SELECT * FROM KHACHHANG WHERE MaKH = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, maKH);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String hoTen = resultSet.getString("HoTen");
            String cmnd = resultSet.getString("CMND");
            String email = resultSet.getString("Email");
            String diaChi = resultSet.getString("DiaChi");
            String sdt = resultSet.getString("SDT");
            String tenDN = resultSet.getString("TenDangNhap");
            String matKhau = resultSet.getString("MatKhau");
            khachhang = new KhachHang(maKH, hoTen, cmnd, email, diaChi, sdt, tenDN, matKhau);
        }
         
        resultSet.close();
        statement.close();
         
        return khachhang;
    }
    public String getKhachHangTheoTenDN(String tenDangNhap) throws SQLException {
        String maKH = null;
        String sql = "SELECT * FROM KHACHHANG WHERE TenDangNhap = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, tenDangNhap);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	maKH = resultSet.getString("MaKH");
        }
         
        resultSet.close();
        statement.close();
         
        return maKH;
    }
    public boolean XuLyDangXuat(String maKH) throws SQLException {
    	String sql = "EXEC DangXuat ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, maKH);
    	boolean rowUpdated = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowUpdated;
    }
}
