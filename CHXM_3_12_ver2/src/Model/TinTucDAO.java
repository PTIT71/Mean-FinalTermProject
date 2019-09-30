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




public class TinTucDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public TinTucDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean InsertTinTuc(TinTuc tinTuc) throws SQLException {
    	String sql = "EXEC Them_Tin ?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, tinTuc.getTua());
    	statement.setString(2, tinTuc.getNoiDung());
    	statement.setString(3, tinTuc.getHinhAnh());
    	boolean rowInserted = statement.executeUpdate() > 0;
    	statement.close();
    	disconnect();
    	return rowInserted;
    }
    public List<TinTuc> ListAllTinTucs() throws SQLException {
    	List<TinTuc> liTinTucs = new ArrayList<TinTuc>();
    	String sql = "SELECT * FROM TINTUC WHERE TrangThai = 0";
    	connect();
    	Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			String maTin = resultSet.getString("MaTin");
			String tua = resultSet.getString("Tua");
			String noiDung = resultSet.getString("NoiDung");
			String hinhAnh = resultSet.getString("HinhAnh");
			TinTuc tinTuc = new TinTuc(maTin, tua, noiDung, hinhAnh);
			liTinTucs.add(tinTuc);
		}
		resultSet.close();
		statement.close();
		disconnect();
		return liTinTucs;
    }
    public boolean DeleteTinTuc(TinTuc tinTuc) throws SQLException {
    	String sql = "EXEC Xoa_Tin ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, tinTuc.getMaTin());
    	boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    public boolean UpdateTinTuc(TinTuc tinTuc) throws SQLException {
    	String sql = "EXEC Sua_Tin ?,?,?,?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, tinTuc.getMaTin());
    	statement.setString(2, tinTuc.getTua());
    	statement.setString(3, tinTuc.getNoiDung());
    	statement.setString(4, tinTuc.getHinhAnh());
    	boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;  
    }
    public TinTuc getTinTuc(String maTin) throws SQLException {
    	TinTuc tinTuc = null;
    	String sql = "SELECT * FROM TINTUC WHERE MaTin = ?";
    	connect();
    	PreparedStatement statement = jdbcConnection.prepareStatement(sql);
    	statement.setString(1, maTin);
    	ResultSet resultSet = statement.executeQuery();
    	if(resultSet.next()) {
    		String maTinTuc = resultSet.getString("MaTin");
    		String tua = resultSet.getString("Tua");
    		String noiDung = resultSet.getString("NoiDung");
    		String hinhAnh = resultSet.getString("HinhAnh");
    		tinTuc =  new TinTuc(maTinTuc, tua, noiDung, hinhAnh);
    	}
    	 resultSet.close();
         statement.close();
         return tinTuc;
    }
    
}
