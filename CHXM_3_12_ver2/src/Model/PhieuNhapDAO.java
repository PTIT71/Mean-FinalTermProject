package Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.java.*;
public class PhieuNhapDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PhieuNhapDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertPN(PhieuNhap phieunhap) throws SQLException {
		String sql = "EXEC Them_Phieu ?,?,?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, phieunhap.getSoLuong());
		statement.setString(2, phieunhap.getMaSP());
		statement.setFloat(3, phieunhap.getGiaNhap());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
    public List<PhieuNhap> listAllPhieuNhap() throws SQLException
	{
		List<PhieuNhap> listPhieuNhap = new ArrayList<PhieuNhap>();
		String sql = "Select * from PHIEUNHAPHANG WHERE TrangThai = 0";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc phieu nhap");
		while (resultSet.next()) {
			String maPHN = resultSet.getString("MaPNH");
			Date thoigian = resultSet.getDate("ThoiGian");
			int soLuong = resultSet.getInt("SoLuong");
			String maSP = resultSet.getString("MaSP");
			Float giaNhap = resultSet.getFloat("GiaNhap");
			DecimalFormat dFormat = new DecimalFormat("###,###,###");
			String gia = dFormat.format(giaNhap) + " VNĐ";
			PhieuNhap phieuNhap = new PhieuNhap(maPHN, thoigian, soLuong, maSP, giaNhap, gia);
			
			listPhieuNhap.add(phieuNhap);
			
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listPhieuNhap;
		
	}
    public boolean updatePhieuNhap(PhieuNhap phieunhap) throws SQLException {
        String sql = "EXEC Sua_Phieu ?,?,?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, phieunhap.getMaPNH());
        statement.setInt(2, phieunhap.getSoLuong());
		statement.setString(3, phieunhap.getMaSP());
		statement.setFloat(4, phieunhap.getGiaNhap());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    public PhieuNhap getPhieuNhap(String maPNH) throws SQLException{
    	PhieuNhap phieuNhap = null;
    	String sql = "Select * from PHIEUNHAPHANG WHERE MaPNH=?";
    	connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, maPNH);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	String maPHN = resultSet.getString("MaPNH");
			Date thoigian = resultSet.getDate("ThoiGian");
			int soLuong = resultSet.getInt("SoLuong");
			String maSP = resultSet.getString("MaSP");
			Float giaNhap = resultSet.getFloat("GiaNhap");
			phieuNhap = new PhieuNhap(maPHN, thoigian, soLuong, maSP, giaNhap);
            }
         
        resultSet.close();
        statement.close();
        return phieuNhap;
    }
	
}
