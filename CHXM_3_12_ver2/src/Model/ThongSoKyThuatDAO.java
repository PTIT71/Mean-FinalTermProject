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



public class ThongSoKyThuatDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ThongSoKyThuatDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public boolean insertTSKT(ThongSoKyThuat thongsokythuat) throws SQLException {
		String sql = "EXEC Them_TSKT ?,?,?,?,?,?,?,?,?,?,?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, thongsokythuat.getTenXe());
		statement.setString(2, thongsokythuat.getKhoiLuong());
		statement.setString(3, thongsokythuat.getDungTichBinhXang());
		statement.setString(4, thongsokythuat.getKtLopTruoc());
		statement.setString(5, thongsokythuat.getKtLopSau());
		statement.setString(6, thongsokythuat.getLoaiDongCo());
		statement.setString(7, thongsokythuat.getDungTichXiLanh());
		statement.setString(8, thongsokythuat.getCongSuatToiDa());
		statement.setString(9, thongsokythuat.getDungTichNhotMay());
		statement.setString(10, thongsokythuat.getHopSo());
		statement.setString(11, thongsokythuat.getHeThongKhoiDong());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<ThongSoKyThuat> listAllTSKT() throws SQLException
	{
		List<ThongSoKyThuat> listTSKT = new ArrayList<ThongSoKyThuat>();
		String sql = "Select * from THONGSOKYTHUAT WHERE TrangThai = 0";
		
		connect();
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.print("lay duoc loai TSKT");
		while (resultSet.next()) {
			String ma = resultSet.getString("MaTSKT");
			String tenxe = resultSet.getString("TenXe");
			String kl = resultSet.getString("KhoiLuong");
			String dtbx = resultSet.getString("DungTichBinhXang");
			String ktlt = resultSet.getString("KichThuocLopTruoc");
			String ktls = resultSet.getString("KichThuocLopSau");
			String loaiDC = resultSet.getString("LoaiDongCo");
			String dtxl = resultSet.getString("DungTichXiLanh");
			String cstd = resultSet.getString("CongSuatToiDa");
			String dtnm = resultSet.getString("DungTichNhotMay");
			String hopso = resultSet.getString("HopSo");
			String htkd = resultSet.getString("HeThongKhoiDong");
			ThongSoKyThuat thongSoKyThuat = new ThongSoKyThuat(ma, tenxe, kl, dtbx, ktlt, ktls,loaiDC, dtxl, cstd, dtnm, hopso, htkd );
			
			listTSKT.add(thongSoKyThuat);
		}
		
		resultSet.close();
		statement.close();
		disconnect();
		
		return listTSKT;
		
	}
	public boolean deleteTSKT(ThongSoKyThuat tsKyThuat) throws SQLException {
        String sql = "EXEC Xoa_TSKT ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, tsKyThuat.getMaTSKT());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateTSKT(ThongSoKyThuat thongsokythuat) throws SQLException {
        String sql = "EXEC Sua_TSKT ?,?,?,?,?,?,?,?,?,?,?,?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, thongsokythuat.getMaTSKT());
        statement.setString(2, thongsokythuat.getTenXe());
		statement.setString(3, thongsokythuat.getKhoiLuong());
		statement.setString(4, thongsokythuat.getDungTichBinhXang());
		statement.setString(5, thongsokythuat.getKtLopTruoc());
		statement.setString(6, thongsokythuat.getKtLopSau());
		statement.setString(7, thongsokythuat.getLoaiDongCo());
		statement.setString(8, thongsokythuat.getDungTichXiLanh());
		statement.setString(9, thongsokythuat.getCongSuatToiDa());
		statement.setString(10, thongsokythuat.getDungTichNhotMay());
		statement.setString(11, thongsokythuat.getHopSo());
		statement.setString(12, thongsokythuat.getHeThongKhoiDong());
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    
    public ThongSoKyThuat getTSKT(String maTSKT) throws SQLException {
        ThongSoKyThuat thongsokythuat = null;
        String sql = "SELECT * FROM THONGSOKYTHUAT,dbo.SANPHAM WHERE SANPHAM.MaTSKT = THONGSOKYTHUAT.MaTSKT AND SANPHAM.MaTSKT = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, maTSKT);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String ma = resultSet.getString("MaTSKT");
        	String tenxe = resultSet.getString("TenXe");
			String kl = resultSet.getString("KhoiLuong");
			String dtbx = resultSet.getString("DungTichBinhXang");
			String ktlt = resultSet.getString("KichThuocLopTruoc");
			String ktls = resultSet.getString("KichThuocLopSau");
			String loaiDC = resultSet.getString("LoaiDongCo");
			String dtxl = resultSet.getString("DungTichXiLanh");
			String cstd = resultSet.getString("CongSuatToiDa");
			String dtnm = resultSet.getString("DungTichNhotMay");
			String hopso = resultSet.getString("HopSo");
			String htkd = resultSet.getString("HeThongKhoiDong");
			String hinhanh = resultSet.getString("HinhAnh");
			thongsokythuat = new ThongSoKyThuat(ma, tenxe, kl, dtbx, ktlt, ktls, loaiDC, dtxl, cstd, dtnm, hopso, htkd, hinhanh);
            }
         
        resultSet.close();
        statement.close();
         
        return thongsokythuat;
    }
    
    public String layTS(String ma) throws SQLException {
		String sql = "EXEC dbo.LayKT ?";
		
		
		connect();
		PreparedStatement preparedStatement = jdbcConnection.prepareStatement(sql);
		preparedStatement.setString(1, ma);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			String maSP = resultSet.getString(1);
			String tenSP= resultSet.getString(2);
			String kl = resultSet.getString(3);
			String dungtichbinhxang = resultSet.getString(4);
			String ktloptruoc = resultSet.getString(5);
			String ktlopsau = resultSet.getString(6);
			String loaidongco = resultSet.getString(7);
			String dungtichxilanh = resultSet.getString(8);
			String congsuattoida = resultSet.getString(9);
			String dungtichnhotmay = resultSet.getString(10);
			String hopso = resultSet.getString(11);
			String hethongkhoidong = resultSet.getString(12);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("{");
			stringBuilder.append("\"maSP\":\""+maSP+"\",");//"maSP":"ma001",
			stringBuilder.append("\"tenSP\":\""+tenSP+"\",");
			stringBuilder.append("\"kl\":\""+kl+"\",");
			stringBuilder.append("\"dungtichxang\":\""+dungtichbinhxang+"\",");
			stringBuilder.append("\"ktloptruoc\":\""+ktloptruoc+"\",");
			stringBuilder.append("\"ktlopsau\":\""+ktlopsau+"\",");
			stringBuilder.append("\"loaidongco\":\""+loaidongco+"\",");
			stringBuilder.append("\"dungtichxylanh\":\""+dungtichxilanh+"\",");
			stringBuilder.append("\"congsuattoida\":\""+congsuattoida+"\",");
			stringBuilder.append("\"dungtichnhotmay\":\""+dungtichnhotmay+"\",");
			stringBuilder.append("\"hopso\":\""+hopso+"\",");
			stringBuilder.append("\"hethongkhoidong\":\""+hethongkhoidong+"\"");
			stringBuilder.append("}");
			return stringBuilder.toString();
		}
		return "";
		
	}
}
