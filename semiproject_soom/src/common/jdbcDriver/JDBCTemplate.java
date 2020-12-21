package common.jdbcDriver;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
	private static DataSource ds = null; // DataSource ds는 아파치톰캣(WAS)가 제공하는 DBCP(DB Connection Pool) 이다.
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Context initContext1 = new InitialContext();
			Context envContext1 = (Context) initContext1.lookup("java:/comp/env");
			ds = (DataSource) envContext1.lookup("jdbc/myoracle");
			conn = ds.getConnection();
			if(conn==null) {
				System.out.println("********** 연결 실패 **********");
			} else {
				System.out.println("********** 연결 성공 **********");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

//	public static Connection getConnection() {
//		Connection conn = null;
//		Properties prop = new Properties();
//		try {
//			String currentPath = JDBCTemplate.class.getResource("./").getPath();
//			prop.load(new BufferedReader(new FileReader(currentPath+"driver.properties")));
//			Class.forName(prop.getProperty("driver"));
//			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
//			conn.setAutoCommit(false);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
