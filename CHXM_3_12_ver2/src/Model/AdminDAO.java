package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.*;

public class AdminDAO {
	
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public AdminDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean ktDangNhap(Admin admin) throws SQLException{
    	String sql = "EXEC KiemTraDN_Admin ?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, admin.getTenDangNhap());
    	statement.setString(2, admin.getMatKhau());
    	boolean kt = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return kt;
    }
    public boolean DatLaiMatKhau(Admin admin) throws SQLException {
    	String sql = "EXEC DoiMK_Admin ?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, admin.getTenDangNhap());
    	statement.setString(2, admin.getMatKhau());
    	boolean kt = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return kt;
    }
    public boolean DangXuat(Admin admin) throws SQLException {
    	String sql = "EXEC DangXuat_Admin ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, admin.getTenDangNhap());
    	boolean kt = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return kt;
    }
}
