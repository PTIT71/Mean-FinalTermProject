package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.*;
public class SanPhamDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    public SanPhamDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertSanPham(SanPham sanpham) throws SQLException {
		String sql = "EXEC Them_SP ?,?,?,?,?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, sanpham.getTenSP());
		statement.setFloat(2, sanpham.getGiaThanh());
		statement.setString(3, sanpham.getMaLoai());
		statement.setString(4, sanpham.getMaTSKT());
		statement.setString(5, sanpham.getHinhAnh());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
    public List<SanPham> listAllSanPham() throws SQLException
	{
		List<SanPham> listSP = new ArrayList<SanPham>();
		String sql = "Select * from SANPHAM WHERE TrangThai = 0";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc san pham");
		while (resultSet.next()) {
			String maSP = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			DecimalFormat dFormat = new DecimalFormat("###,###,###");
			String giathanh = dFormat.format(giaThanh) + " VNĐ";
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhanh = resultSet.getString("HinhAnh");
			SanPham sanPham = new SanPham(maSP, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhanh,giathanh);
			
			listSP.add(sanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listSP;
		
	}
    public boolean deleteSP(SanPham sanpham) throws SQLException {
        String sql = "EXEC Xoa_SP ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, sanpham.getMaSP());
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    public boolean updateSP(SanPham sanpham) throws SQLException {
        String sql = "EXEC Sua_SP ?,?,?,?,?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, sanpham.getMaSP());
        statement.setString(2, sanpham.getTenSP());
        statement.setFloat(3, sanpham.getGiaThanh());
        statement.setString(4, sanpham.getMaLoai());
        statement.setString(5, sanpham.getMaTSKT());
        statement.setString(6, sanpham.getHinhAnh());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    public SanPham getSP(String maSP) throws SQLException {
        SanPham sanpham = null;
        String sql = "SELECT * FROM SANPHAM WHERE MaSP = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, maSP);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String maSanPham = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
			String hinhAnh	= resultSet.getString("HinhAnh");
            sanpham = new SanPham(maSanPham, tenSP, giaThanh, soLuongTon, maloai, maTSKT, hinhAnh);
            }
         
        resultSet.close();
        statement.close();
         
        return sanpham;
    }
    public String getMaLoai(String tenLoai) throws SQLException {
    	String sql = "EXEC LayMa ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, tenLoai);
    	
    	statement.setQueryTimeout(90);
    	statement.setEscapeProcessing(true);
    	ResultSet resultSet = statement.executeQuery();
    	
    	String maLoai = resultSet.getString(1);
    	return  maLoai;
    }
    public List<SanPham> TimKiemSPTheoTen(String ten) throws SQLException{
    	List<SanPham> listSP = new ArrayList<SanPham>();
    	String sql = "EXEC tkSP_Ten ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, ten);
    	ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	String maSanPham = resultSet.getString("MaSP");
			String tenSP = resultSet.getString("TenSP");
			Float giaThanh = resultSet.getFloat("GiaThanh");
			DecimalFormat dFormat = new DecimalFormat("###,###,###");
			String giathanh = dFormat.format(giaThanh) + " VNĐ";
			int soLuongTon = resultSet.getInt("SoLuongTon");
			String maloai = resultSet.getString("MaLoai");
			String maTSKT = resultSet.getString("MaTSKT");
            SanPham sanpham = new SanPham(maSanPham, tenSP, giaThanh, soLuongTon, maloai, maTSKT, giathanh);
            listSP.add(sanpham);
            }
         
        resultSet.close();
        statement.close();
         
        return listSP;
    }
    
    public static void main(String[] args) {
    	SanPhamDAO sanPhamDAO = new SanPhamDAO("jdbc:sqlserver://localhost:1433;databaseName=Web_CuaHangXeMay", "liem1230", "123456");
    	try {
			List<SanPham> sanPhams = sanPhamDAO.listAllSanPham();
			for (SanPham sanPham : sanPhams) {
				System.out.println(sanPham.getTenSP() + " ...... "+ sanPham.getSoLuongTon());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}

