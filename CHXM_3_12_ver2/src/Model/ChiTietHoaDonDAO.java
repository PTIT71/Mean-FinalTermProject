package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.*;


public class ChiTietHoaDonDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ChiTietHoaDonDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean InsertCTHD(ChiTietHoaDon CTHD) throws SQLException {
    	String sql = "EXEC Them_CTHD ?,?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	
    	statement.setString(1, CTHD.getMaHD());
    	statement.setString(2, CTHD.getMaSP());
    	statement.setInt(3, CTHD.getSoLuong());
    	statement.setFloat(4, CTHD.getDonGia());
    	boolean rowInserted = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowInserted;
    }
    public List<ChiTietHoaDon> listAllCTHDs(String maHD) throws SQLException {
    	List<ChiTietHoaDon> liCTHDs = new ArrayList<ChiTietHoaDon>();
    	String sql = "Select * FROM CHITIETHOADON WHERE TrangThai = 0 AND MaHD = ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, maHD);
    	ResultSet resultSet = statement.executeQuery();
    	while (resultSet.next()) {
    		String maCTHD = resultSet.getString("MaCTHD");
			String maSP = resultSet.getString("MaSP");
			int soLuong = resultSet.getInt("SoLuong");
			Float donGia = resultSet.getFloat("DonGia");
			DecimalFormat dFormat = new DecimalFormat("###,###,###");
			String gia = dFormat.format(donGia) + " VNĐ";
			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maCTHD, maHD, maSP, soLuong, donGia,gia);
			liCTHDs.add(chiTietHoaDon);
		}
    	resultSet.close();
    	statement.close();
    	disconnect();
    	return liCTHDs;
    }
    public boolean UpdateCTHD(ChiTietHoaDon chiTietHoaDon) throws SQLException {
    	String sql = "EXEC Sua_CTHD ?,?,?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, chiTietHoaDon.getMaCTHD());
    	//System.out.print(chiTietHoaDon.getMaCTHD());
    	statement.setString(2, chiTietHoaDon.getMaHD());
    	statement.setString(3, chiTietHoaDon.getMaSP());
    	statement.setInt(4, chiTietHoaDon.getSoLuong());
    	statement.setFloat(5, chiTietHoaDon.getDonGia());
    	 boolean rowUpdated = statement.executeUpdate() > 0;
         statement.close();
         disconnect();
         return rowUpdated;     
    }
    public ChiTietHoaDon getCTHD_MoiNhat() throws SQLException {
    	ChiTietHoaDon chiTietHoaDon = null;
    	String sql = "Select * FROM CHITIETHOADON";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	ResultSet resultSet = statement.executeQuery();
    	while(resultSet.next()) {
    		String maCTHD = resultSet.getString("MaCTHD");
    		String maHD = resultSet.getString("MaHD");
    		String maSP = resultSet.getString("MaSP");
    		int soLuong = resultSet.getInt("SoLuong");
    		Float donGia = resultSet.getFloat("DonGia");
    		chiTietHoaDon = new ChiTietHoaDon(maCTHD, maHD, maSP, soLuong, donGia);
    	}
    	 resultSet.close();
         statement.close();
         return chiTietHoaDon;
    }
    public boolean DeleteCTHD(ChiTietHoaDon chiTietHoaDon) throws SQLException {
    	String sql = "EXEC Xoa_ChiTiet ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, chiTietHoaDon.getMaCTHD());
    	   
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;   
    }
}