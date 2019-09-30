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

public class LoaiSanPhamDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public LoaiSanPhamDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public boolean insertLSP(LoaiSanPham loaiSanPham) throws SQLException {
		String sql = "EXEC Them_LoaiSP ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, loaiSanPham.getTenLoai());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<LoaiSanPham> listAllLoaiSanPham() throws SQLException
	{
		List<LoaiSanPham> listLSP = new ArrayList<LoaiSanPham>();
		String sql = "Select * from LOAISANPHAM WHERE TrangThai = 0";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc loai san pham");
		while (resultSet.next()) {
			String maloai = resultSet.getString("MaLoai");
			String tenloai = resultSet.getString("TenLoaiSP");
			LoaiSanPham loaiSanPham = new LoaiSanPham(maloai, tenloai);
			
			listLSP.add(loaiSanPham);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listLSP;
		
	}
	public boolean deleteLoaiSP(LoaiSanPham loaiSP) throws SQLException {
        String sql = "EXEC Xoa_LoaiSP ?,?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, loaiSP.getMaLoai());
        statement.setString(2, loaiSP.getTenLoai());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateLoaiSP(LoaiSanPham loaiSP) throws SQLException {
        String sql = "EXEC Sua_LoaiSP ?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, loaiSP.getMaLoai());
        statement.setString(2, loaiSP.getTenLoai());
      
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    
    public LoaiSanPham getLoaiSP(String maLoaiSP) throws SQLException {
        LoaiSanPham loaisanpham = null;
        String sql = "SELECT * FROM LOAISANPHAM WHERE MaLoai = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, maLoaiSP);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String maLoai = resultSet.getString("MaLoai");
            String tenLoai = resultSet.getString("TenLoaiSP");
            loaisanpham = new LoaiSanPham(maLoai, tenLoai);
            }
         
        resultSet.close();
        statement.close();
         
        return loaisanpham;
    }
}