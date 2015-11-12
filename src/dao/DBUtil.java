package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//管理数据库连接的工具类
//可以获取数据库的连接对象以及关闭数据库连接
public class DBUtil {

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",
					"root", "root");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return conn;
	}

	public static void closeConnection(Connection conn) throws Exception {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
