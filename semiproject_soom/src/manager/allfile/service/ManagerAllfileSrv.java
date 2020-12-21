package manager.allfile.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import manager.allfile.dao.ManagerAllfileDao;
import manager.allfile.vo.ManagerAllfileVO;

public class ManagerAllfileSrv {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static ManagerAllfileDao dao = new ManagerAllfileDao();
	
	public ManagerAllfileSrv() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int uploadFile(String f_no, String f_name) throws Exception {
		int result = 0;
		result = dao.uploadFile(conn, f_no, f_name);
		if (result != 0) {
			close();
		}

		return result;
	}
	
	public static int getBoardCount() throws Exception {
		int result = new ManagerAllfileDao().getBoardCount(conn);
		return result;
	}
	
	public static List<ManagerAllfileVO> allList(int start, int end) throws Exception {
		List<ManagerAllfileVO> list = null;
		list = dao.allList(conn, start, end);
		if(list != null) {
			close();
		}
		return list;
	}
	
	public ManagerAllfileVO selectOne(int num) throws Exception {
		ManagerAllfileVO vo = null;
		vo = dao.selectOne(conn, num);
		if (vo != null) {
			close();
		}
		return vo;
	}
}
