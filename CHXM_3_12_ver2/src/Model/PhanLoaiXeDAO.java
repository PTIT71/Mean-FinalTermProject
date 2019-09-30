package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.SanPham;

public class PhanLoaiXeDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public PhanLoaiXeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    public List<SanPham> listAllXeTayGa() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "Select * from SANPHAM WHERE TrangThai = 0 AND MaLoai = 'ML002'";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    
    public List<SanPham> listAllXeSo() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "Select * from SANPHAM WHERE TrangThai = 0 AND MaLoai = 'ML001'";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    
    public List<SanPham> listAllXeConTay() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "Select * from SANPHAM WHERE TrangThai = 0 AND MaLoai = 'ML003'";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    
    public List<SanPham> listAllXePhanKhoiLon() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "Select * from SANPHAM WHERE TrangThai = 0 AND MaLoai = 'ML004'";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    
    public List<SanPham> listAllXeDuoi20tr() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "SELECT * FROM dbo.SANPHAM WHERE GiaThanh < 20000000";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    
    public List<SanPham> listAllXeTren80tr() throws SQLException
   	{
   		List<SanPham> listSP = new ArrayList<SanPham>();
   		String sql = "SELECT * FROM dbo.SANPHAM WHERE GiaThanh > 80000000";
   		
   		connect();
   		Statement statement = jdbcConnection.createStatement();
   		ResultSet resultSet = statement.executeQuery(sql);
   		System.out.print("lay duoc san pham");
   		while (resultSet.next()) {
   			String maSP = resultSet.getString("MaSP");
   			String tenSP = resultSet.getString("TenSP");
   			Float giaThanh = resultSet.getFloat("GiaThanh");
   			int soLuongTon = resultSet.getInt("SoLuongTon");
   			String maloai = resultSet.getString("MaLoai");
   			String maTSKT = resultSet.getString("MaTSKT");
   			String hinhanh = resultSet.getString("HinhAnh");
   			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
   			
   			listSP.add(sanPham);
   			
   		}
   		
   		resultSet.close();
   		statement.close();
   		disconnect();
   		
   		return listSP;
   		
   	}
    
    public List<SanPham> listAllXe20tr40tr() throws SQLException
   	{
   		List<SanPham> listSP = new ArrayList<SanPham>();
   		String sql = "SELECT * FROM dbo.SANPHAM WHERE GiaThanh < 40000000 AND GiaThanh > 20000000";
   		
   		connect();
   		Statement statement = jdbcConnection.createStatement();
   		ResultSet resultSet = statement.executeQuery(sql);
   		System.out.print("lay duoc san pham");
   		while (resultSet.next()) {
   			String maSP = resultSet.getString("MaSP");
   			String tenSP = resultSet.getString("TenSP");
   			Float giaThanh = resultSet.getFloat("GiaThanh");
   			int soLuongTon = resultSet.getInt("SoLuongTon");
   			String maloai = resultSet.getString("MaLoai");
   			String maTSKT = resultSet.getString("MaTSKT");
   			String hinhanh = resultSet.getString("HinhAnh");
   			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
   			
   			listSP.add(sanPham);
   			
   		}
   		
   		resultSet.close();
   		statement.close();
   		disconnect();
   		
   		return listSP;
   		
   	}
    
    public List<SanPham> listAllXe40tr80tr() throws SQLException
   	{
   		List<SanPham> listSP = new ArrayList<SanPham>();
   		String sql = "SELECT * FROM dbo.SANPHAM WHERE GiaThanh < 80000000 AND GiaThanh >= 40000000";
   		
   		connect();
   		Statement statement = jdbcConnection.createStatement();
   		ResultSet resultSet = statement.executeQuery(sql);
   		System.out.print("lay duoc san pham");
   		while (resultSet.next()) {
   			String maSP = resultSet.getString("MaSP");
   			String tenSP = resultSet.getString("TenSP");
   			Float giaThanh = resultSet.getFloat("GiaThanh");
   			int soLuongTon = resultSet.getInt("SoLuongTon");
   			String maloai = resultSet.getString("MaLoai");
   			String maTSKT = resultSet.getString("MaTSKT");
   			String hinhanh = resultSet.getString("HinhAnh");
   			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh);
   			
   			listSP.add(sanPham);
   			
   		}
   		
   		resultSet.close();
   		statement.close();
   		disconnect();
   		
   		return listSP;
   		
   	}
}
